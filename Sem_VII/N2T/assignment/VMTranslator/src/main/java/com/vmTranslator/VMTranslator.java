package com.vmTranslator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.vmTranslator.Parser.CommandType;

public class VMTranslator {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get(args[0]);
        firstPass(filePath);
    }


    private static void firstPass(Path filePath) throws IOException {
        System.out.println("Input File "+filePath.toAbsolutePath());

        Parser parser = new Parser(filePath);
        CodeWriter codeWriter = new CodeWriter(filePath.getFileName().toString().replace("vm", "asm"));

        while (parser.hasMoreLines()) {
            parser.advance();
            CommandType type = parser.commandType();
            if (type == CommandType.C_INVALID)
                continue;

            switch (type) {
                case C_PUSH:
                    codeWriter.writePushPop(CommandType.C_PUSH, parser.arg1(), parser.arg2());
                    break;
                case C_POP:
                    codeWriter.writePushPop(CommandType.C_POP, parser.arg1(), parser.arg2());
                    break;
                case C_ARITHMETIC:
                    codeWriter.writeArithmetic(parser.arg1());
                    break;
                default:
                    throw new IllegalArgumentException("Instruction Not Handled");
            }
        }

        codeWriter.close();
        parser.close();
    }

}