package com.assembler;

import com.assembler.custom.DataMap;
import com.assembler.custom.InstructionType;
import com.assembler.custom.Utils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HackAssembler {
    private static final Logger logger = Logger.getLogger(HackAssembler.class.getName());
    private static String fileName;

    public static void main(String[] args) {
        try {
            String filePathStr = args[0];
            Path filePath = Paths.get(filePathStr);
            fileName = filePath.getFileName().toString();

            SymbolTable symbolTable = new SymbolTable();
            firstPass(filePath, symbolTable);
            secondPass(filePath, symbolTable);
        } catch (IOException exception) {
            logger.log(Level.SEVERE, "Exception occurred while running program", exception);
        }
    }

    private static void firstPass(Path filePath, SymbolTable symbolTable) throws IOException {
        Parser parser = new Parser(filePath);
        int lineNumber = 0;

        logger.info("First Pass Processing ...");
        while (parser.hasMoreLines()) {
            parser.advance();
            InstructionType type = parser.instructionType();

            logger.fine("Processing line number " + lineNumber);
            if (type == InstructionType.L_INSTRUCTION) {
                String label = parser.symbol();
                symbolTable.addEntry(label, lineNumber);

                logger.fine("Instruction is L Instruction");
                logger.fine("Label is " + label);
            } else lineNumber++;
        }
    }

    private static void secondPass(Path filePath, SymbolTable symbolTable) throws IOException {
        Parser parser = new Parser(filePath);
        Code code = new Code();

        int symbolAddress = 16;
        int lineNumber = 0;
        List<String> instructionSet = new ArrayList<>();

        logger.info("Second Pass Processing");
        while (parser.hasMoreLines()) {
            parser.advance();
            String binaryInstruction;
            InstructionType type = parser.instructionType();

            logger.fine("Processing line number " + lineNumber);
            if (type == InstructionType.A_INSTRUCTION) {
                String symbol = parser.symbol();
                int address;

                if (Utils.isNumeric(symbol)) {
                    address = Integer.parseInt(symbol);
                } else {
                    if (!symbolTable.contains(symbol))
                        symbolTable.addEntry(symbol, symbolAddress++);
                    address = symbolTable.getAddress(symbol);
                }

                binaryInstruction = Utils.toBinaryString(address, 16);
                instructionSet.add(binaryInstruction);
                lineNumber++;

                logger.fine("Processing A Instruction with address " + address);
                logger.fine("Binary Instruction is as follows " + binaryInstruction);
            } else if (type == InstructionType.C_INSTRUCTION) {
                String dest = parser.dest();
                String comp = parser.comp();
                String jump = parser.jump();

                binaryInstruction = "111" + code.comp(comp) + code.dest(dest) + code.jump(jump);
                instructionSet.add(binaryInstruction);
                lineNumber++;

                logger.fine("Processing C Instruction with\n\tdest : " + dest + "\n\tcomp : " + comp + "\n\tjump : " + jump);
                logger.fine("Binary Instruction is as follows " + binaryInstruction);
            }
        }

        logger.info("output File Created in current Directory with fileName as : result.hack");
        Utils.writeBinInstruction(fileName, instructionSet);
    }

    public static void setLoggingLevel(Level level) {
        Logger.getLogger(HackAssembler.class.getName()).setLevel(level);
    }
}