package com.vmTranslator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.vmTranslator.utils.Context;
import com.vmTranslator.utils.Utils;
import com.vmTranslator.VMExceptions.SyntaxExceptions;
import com.vmTranslator.VMExceptions.SyntaxExceptions.*;

public class Parser {

    public enum CommandType {
        C_ARITHMETIC, C_PUSH, C_POP,
        C_LABEL, C_GOTO, C_IF, C_FUNCTION,
        C_RETURN, C_CALL, C_NULL,
    }


    private String current_line;
    private int lineNumber;
    private final BufferedReader reader;
    private final Context context;


    Parser(Path path) throws IOException {
        reader = Files.newBufferedReader(path);
        current_line = null;
        lineNumber = 0;
        context  = new Context(lineNumber, null);
    }


    public boolean hasMoreLines() throws IOException {
        return reader.ready();
    }


    public void advance() throws IOException {
        do {
            current_line = reader.readLine();
            lineNumber++;

            context.setLineNumber(lineNumber);
            context.setCurrentLine(current_line);
            if (current_line == null) break;
            current_line = Utils.cleanLine(current_line);
        } while (current_line.isEmpty());
    }


    public CommandType commandType() throws SyntaxExceptions{
        if (current_line == null || current_line.isEmpty())
            return CommandType.C_NULL;

        String[] parts = current_line.split(" ");
        if(parts.length>0) {
            return switch (parts[0]) {
                case "push" -> CommandType.C_PUSH;
                case "pop" -> CommandType.C_POP;
                case "call" -> CommandType.C_CALL;
                case "function" -> CommandType.C_FUNCTION;
                case "label" -> CommandType.C_LABEL;
                case "goto" -> CommandType.C_GOTO;
                case "if-goto" -> CommandType.C_IF;
                case "return" -> CommandType.C_RETURN;
                case "add", "sub", "neg", "eq", "gt", "lt", "and", "or", "not" -> CommandType.C_ARITHMETIC;
                default -> throw new InvalidCommandException(parts[0],getLineNumber(),getCurrent_line());
            };
        }
        else
            throw new NuLLCommandFoundException(getLineNumber(),getCurrent_line());
    }


    public String arg1() throws SyntaxExceptions {
        if (commandType() == CommandType.C_NULL)
            throw new NuLLCommandFoundException(getLineNumber(), getCurrent_line());

        if (commandType() == CommandType.C_RETURN)
            throw new MissingFirstArgumentException(commandType().name(), getLineNumber(), getCurrent_line());

        String[] parts = current_line.split(" ");
        if (commandType() == CommandType.C_ARITHMETIC) {
            if(parts.length<1)
                throw new MissingFirstArgumentException(commandType().name(), getLineNumber(), getCurrent_line());
            return parts[0];
        }

        if (parts.length < 2)
            throw new MissingFirstArgumentException(commandType().name(), getLineNumber(), getCurrent_line());
        return parts[1];
    }


    public Integer arg2() throws SyntaxExceptions{
        if (commandType()==CommandType.C_NULL)
            throw new NuLLCommandFoundException(getLineNumber(), getCurrent_line());

        if (commandType() == CommandType.C_GOTO ||
                commandType() == CommandType.C_ARITHMETIC ||
                commandType() == CommandType.C_LABEL ||
                commandType() == CommandType.C_RETURN ||
                commandType() == CommandType.C_IF)
            throw new InvalidCommandException(commandType().name(),getLineNumber(),getCurrent_line());

        String[] parts = current_line.split(" ");
        if(parts.length<3)
            throw new MissingSecondArgumentException(commandType().name(),getLineNumber(),getCurrent_line());
        if(!Utils.isValidInteger(parts[2]))
            throw new InvalidIntegerException(commandType().name(), getLineNumber(),getCurrent_line());
        return Integer.parseInt(parts[2]);
    }


    public void close() throws IOException {
        reader.close();
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getCurrent_line() {
        return current_line;
    }

    public Context getContext() {
        return context;
    }
}
