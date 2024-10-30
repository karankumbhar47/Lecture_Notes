package com.vmTranslator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import com.vmTranslator.Parser.CommandType;
import com.vmTranslator.VMExceptions.SyntaxExceptions;
import com.vmTranslator.VMExceptions.SyntaxExceptions.*;

public class CodeWriter {
    private int labelID = 0;
    private final BufferedWriter writer;
    private final Path outputFilePath;
    public static boolean isTesting = false;

    CodeWriter(String fileName) throws IOException {
        if(!isTesting)
            outputFilePath = Paths.get("").resolve("result.asm");
        else
            outputFilePath = Paths.get("src/main/resources/VMFiles").resolve(fileName);

        writer = new BufferedWriter(new FileWriter(outputFilePath.toFile()));
    }


    public void writeArithmetic(String command, Context context) throws IOException, SyntaxExceptions {
        String program = switch (command) {
            case "add","sub","and","or" -> Utils.binaryOprProgram(command,context);
            case "neg","not" -> Utils.unaryOprProgram(command,context);
            case "gt","lt","eq" -> Utils.compOpProgram(command, labelID++,context);
            default -> throw new InvalidArithmeticCommandException(command,context.getLineNumber(),context.getCurrentLine());
        };
        if (!program.isEmpty()) {
            writer.write(program);
            writer.flush();
        }
    }


    public void writePushPop(CommandType commandType, String segment, int index, Context context) throws IOException, SyntaxExceptions {
        if(SuggestionUtils.segmentList.contains(segment)) {
            String program;
            boolean isAdderAddition = Objects.equals(segment, "local") ||
                    Objects.equals(segment, "argument") ||
                    Objects.equals(segment, "this") ||
                    Objects.equals(segment, "that");

            if (commandType == CommandType.C_PUSH) {
                if (Objects.equals(segment, "constant"))
                    program = Utils.pushConstProgram(index,context);
                else if (isAdderAddition)
                    program = Utils.pushAddProgram(segment, index,context);
                else
                    program = Utils.pushProgram(segment, index,context);
            } else if (commandType == CommandType.C_POP) {
                if (isAdderAddition)
                    program = Utils.popAddProgram(segment, index,context);
                else
                    program = Utils.popProgram(segment, index,context);
            } else
                throw new InvalidCommandException(commandType.name(),context.getLineNumber(),context.getCurrentLine());

            writer.write(program);
            writer.flush();
        }
        else
            throw new InvalidSegmentException(segment, context.getLineNumber(), context.getCurrentLine());
    }


    public void close(boolean isError) throws IOException {
        if(!isError)
            System.out.println("Output file : "+outputFilePath.toAbsolutePath());
        if (writer != null) {
            writer.flush();
            writer.close();
        }
    }
}
