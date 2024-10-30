package com.vmTranslator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.vmTranslator.Parser.CommandType;
import com.vmTranslator.VMExceptions.SyntaxExceptions;
import com.vmTranslator.VMExceptions.SyntaxExceptions.*;

public class VMTranslator {
    public static void main(String[] args) throws IOException,SyntaxExceptions {
        Path filePath = Paths.get(args[0]);
        boolean hasErrors  = ErrorPass(filePath);
        if(!hasErrors)
            firstPass(filePath);
    }

    private static boolean ErrorPass(Path filePath) throws IOException {
        Parser parser = new Parser(filePath);
        CodeWriter codeWriter = new CodeWriter(filePath.getFileName().toString().replace("vm", "asm"));
        boolean hasErrors = false;

        while (parser.hasMoreLines()) {
            try {
                parser.advance();
                CommandType type = parser.commandType();
                if (type == CommandType.C_NULL) continue;


                switch (type) {
                    case C_PUSH:
                        codeWriter.writePushPop (CommandType.C_PUSH, parser.arg1(), parser.arg2(),parser.getContext());
                        break;
                    case C_POP:
                        codeWriter.writePushPop(CommandType.C_POP, parser.arg1(), parser.arg2(),parser.getContext());
                        break;
                    case C_ARITHMETIC:
                        codeWriter.writeArithmetic(parser.arg1(),parser.getContext());
                        break;
                    case C_NULL:
                        throw new NuLLCommandFoundException(parser.getLineNumber(), parser.getCurrent_line());
                    default:
                        throw new InstructionNotHandled(type.name(),parser.getLineNumber(),parser.getCurrent_line());
                }

            } catch (Exception e) {
                System.err.println(e.getMessage());
                hasErrors = true;
            }
        }

        parser.close();
        codeWriter.close(true);
        return hasErrors;
    }


    private static void firstPass(Path filePath) throws IOException, SyntaxExceptions {
        System.out.println("Input File "+filePath.toAbsolutePath());

        Parser parser = new Parser(filePath);
        CodeWriter codeWriter = new CodeWriter(filePath.getFileName().toString().replace("vm", "asm"));

        while (parser.hasMoreLines()) {
            parser.advance();
            CommandType type = parser.commandType();
            if (type == CommandType.C_NULL)
                continue;

            switch (type) {
                case C_PUSH:
                    codeWriter.writePushPop (CommandType.C_PUSH, parser.arg1(), parser.arg2(),parser.getContext());
                    break;
                case C_POP:
                    codeWriter.writePushPop(CommandType.C_POP, parser.arg1(), parser.arg2(),parser.getContext());
                    break;
                case C_ARITHMETIC:
                    codeWriter.writeArithmetic(parser.arg1(),parser.getContext());
                    break;
                case C_NULL:
                    throw new NuLLCommandFoundException(parser.getLineNumber(), parser.getCurrent_line());
                default:
                    throw new InstructionNotHandled(type.name(),parser.getLineNumber(),parser.getCurrent_line());
            }
        }

        codeWriter.close(false);
        parser.close();
    }

}