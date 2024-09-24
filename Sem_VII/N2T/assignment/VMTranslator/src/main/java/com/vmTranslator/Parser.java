package com.vmTranslator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Parser {

    public enum CommandType {
        C_ARITHMETIC, C_PUSH, C_POP,
        C_LABEL, C_GOTO, C_IF, C_FUNCTION,
        C_RETURN, C_CALL, C_INVALID
    }


    private String current_line;
    private final BufferedReader reader;


    Parser(Path path) throws IOException {
        reader = Files.newBufferedReader(path);
        current_line = null;
    }


    public boolean hasMoreLines() throws IOException {
        return reader.ready();
    }


    public void advance() throws IOException {
        do {
            current_line = reader.readLine();
            if (current_line == null) break;
            current_line = Utils.cleanLine(current_line);
        } while (current_line.isEmpty());
    }


    public CommandType commandType() {
        if (current_line == null || current_line.isEmpty())
            return CommandType.C_INVALID;

        String[] parts = current_line.split(" ");
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
            default -> CommandType.C_INVALID;
        };
    }


    public String arg1() {
        if (commandType() == CommandType.C_ARITHMETIC) {
            String[] parts = current_line.split(" ");
            return parts[0];
        } else if (commandType() == CommandType.C_PUSH ||
                commandType() == CommandType.C_POP ||
                commandType() == CommandType.C_CALL ||
                commandType() == CommandType.C_FUNCTION) {
            String[] parts = current_line.split(" ");
            return parts[1];
        }
        return null;
    }


    public Integer arg2() {
        if (commandType() == CommandType.C_PUSH ||
                commandType() == CommandType.C_POP ||
                commandType() == CommandType.C_CALL ||
                commandType() == CommandType.C_FUNCTION) {
            String[] parts = current_line.split(" ");
            return Integer.parseInt(parts[2]);
        }
        return null;
    }


    public void close() throws IOException {
        reader.close();
    }
}
