package com.vmTranslator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vmTranslator.Parser.CommandType;
import com.vmTranslator.VMExceptions.SyntaxExceptions.*;

import static com.vmTranslator.Parser.CommandType.*;

public class VMTranslator {
    public static void main(String[] args) throws IOException {
        Path inputPath = Paths.get(args[0]);

        if (Files.isDirectory(inputPath)) {
            try (Stream<Path> paths = Files.walk(inputPath)) {
                List<Path> vmFiles = paths
                        .filter(p -> p.toString().endsWith(".vm"))
                        .collect(Collectors.toList());

                if (vmFiles.isEmpty()) {
                    System.out.println("No .vm files found in the directory.");
                    return;
                }

                String directoryName = inputPath.getFileName().toString();
                String outputFileName = directoryName + ".asm";

                processFiles(vmFiles, outputFileName);
            }
        } else {
            String outputFileName =inputPath.getFileName()
                    .toString().replace(".vm", ".asm");
            processFiles(List.of(inputPath),outputFileName);
        }
    }

    private static void processFiles(List<Path> vmFiles,String outputFileName) throws IOException {
        int retIndex = 0;
        String fileName = outputFileName.replace(".asm", "");

        CodeWriter codeWriter = new CodeWriter(outputFileName);
        codeWriter.setInputFileName(fileName);

        if (vmFiles.stream().anyMatch(f -> f.getFileName().toString().equals("Sys.vm")))
            codeWriter.writeInit(retIndex++);

        for (Path vmFile : vmFiles) {
            Parser parser = new Parser(vmFile);
            codeWriter.setInputFileName(vmFile.getFileName().toString().replace(".vm", ""));
            System.out.println("Processing file: " + vmFile.getFileName());

            while (parser.hasMoreLines()) {
                try {
                    parser.advance();
                    CommandType type = parser.commandType();
                    if (type == C_NULL) continue;

                    switch (type) {
                        case C_PUSH ->
                                codeWriter.writePushPop(C_PUSH, parser.arg1(), parser.arg2(), parser.getContext());
                        case C_POP ->
                                codeWriter.writePushPop(C_POP, parser.arg1(), parser.arg2(), parser.getContext());
                        case C_ARITHMETIC ->
                                codeWriter.writeArithmetic(parser.arg1(), parser.getContext());
                        case C_LABEL ->
                                codeWriter.writeLabel(parser.arg1());
                        case C_GOTO ->
                                codeWriter.writeGoTo(parser.arg1());
                        case C_IF ->
                                codeWriter.writeIf(parser.arg1());
                        case C_CALL ->
                                codeWriter.writeCall(parser.arg1(), parser.arg2(),retIndex++);
                        case C_FUNCTION ->
                                codeWriter.writeFunction(parser.arg1(), parser.arg2());
                        case C_RETURN ->
                                codeWriter.writeReturn();
                        case C_NULL ->
                                throw new NuLLCommandFoundException(parser.getLineNumber(), parser.getCurrent_line());
                        default ->
                                throw new InstructionNotHandled(type.name(), parser.getLineNumber(), parser.getCurrent_line());
                    }
                } catch (Exception exception) {
                    System.err.println(exception.getMessage());
                }
            }
            parser.close();
        }

        codeWriter.close();
    }
}