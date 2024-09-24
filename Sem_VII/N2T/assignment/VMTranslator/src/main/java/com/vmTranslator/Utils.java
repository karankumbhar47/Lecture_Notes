package com.vmTranslator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static String cleanLine(String line) {
        Pattern pattern = Pattern.compile("(^\\s+)|(//.*)|(\\s+$)|((\\r)?\\n)|(\\s{2,})");
        Matcher matcher = pattern.matcher(line);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            if (matcher.group(1) != null || matcher.group(2) != null || matcher.group(3) != null
                    || matcher.group(4) != null) {
                matcher.appendReplacement(result, "");
            } else if (matcher.group(6) != null) {
                matcher.appendReplacement(result, " ");
            }
        }
        matcher.appendTail(result);
        return result.toString().trim();
    }


    public static String pushAddProgram(String segment, int index) {
        StringBuilder sb = new StringBuilder();
        sb.append("@").append(index).append("\n");
        sb.append("D=A\n");
        switch (segment) {
            case "local" -> sb.append("@LCL\n");
            case "argument" -> sb.append("@ARG\n");
            case "this" -> sb.append("@THIS\n");
            case "that" -> sb.append("@THAT\n");
            default -> throw new IllegalArgumentException("No pointer related to " + segment);
        }
        sb.append("A=D+M\n");
        sb.append("D=M\n");
        sb.append("@SP\n");
        sb.append("A=M\n");
        sb.append("M=D\n");
        sb.append("@SP\n");
        sb.append("M=M+1\n");
        return sb.toString();
    }
    

    public static String pushProgram(String segment, int index) {
        StringBuilder sb = new StringBuilder();
        switch (segment) {
            case "temp" -> sb.append("@").append(String.valueOf(5 + index)).append("\n");
            case "static" -> sb.append("@Static.").append(index).append("\n");
            case "pointer" -> sb.append("@").append((index == 0) ? "THIS" : "THAT").append("\n");
            default -> throw new IllegalArgumentException("No pointer related to " + segment);
        }

        sb.append("D=M\n");
        sb.append("@SP\n");
        sb.append("A=M\n");
        sb.append("M=D\n");
        sb.append("@SP\n");
        sb.append("M=M+1\n");
        return sb.toString();
    }


    public static String pushConstProgram(String segment, int index) {
        StringBuilder sb = new StringBuilder();
        sb.append("@").append(index).append("\n");
        sb.append("D=A\n");
        sb.append("@SP\n");
        sb.append("A=M\n");
        sb.append("M=D\n");
        sb.append("@SP\n");
        sb.append("M=M+1\n");
        return sb.toString();
    }


    public static String popProgram(String segment, int index) {
        StringBuilder sb = new StringBuilder();

        sb.append("@SP\n");
        sb.append("AM=M-1\n");
        sb.append("D=M\n");
        switch (segment) {
            case "temp" -> sb.append("@").append(String.valueOf(5 + index)).append("\n");
            case "pointer" -> sb.append("@").append((index == 0) ? "THIS" : "THAT").append("\n");
            case "static" -> sb.append("@Static.").append(index).append("\n");
            default -> throw new IllegalArgumentException("Not valid segment : " + segment);
        }
        sb.append("M=D\n");
        return sb.toString();
    }


    public static String popAddProgram(String segment, int index) {
        StringBuilder sb = new StringBuilder();

        String segSymbol = switch (segment) {
            case "local" -> "LCL";
            case "argument" -> "ARG";
            case "this" -> "THIS";
            case "that" -> "THAT";
            default -> throw new IllegalArgumentException("Invalid segment: " + segment);
        };

        sb.append("@").append(index).append("\n");
        sb.append("D=A\n");
        sb.append("@").append(segSymbol).append("\n");
        sb.append("D=D+M\n");
        sb.append("@R13\n");
        sb.append("M=D\n");
        sb.append("@SP\n");
        sb.append("AM=M-1\n");
        sb.append("D=M\n");
        sb.append("@R13\n");
        sb.append("A=M\n");
        sb.append("M=D\n");

        return sb.toString();
    }


    public static String binaryOprProgram(int opCode) {
        StringBuilder sb = new StringBuilder();

        sb.append("@SP\n");
        sb.append("AM=M-1\n");
        sb.append("D=M\n");

        sb.append("@SP\n");
        sb.append("AM=M-1\n");

        switch (opCode) {
            case 0:
                sb.append("M=D+M\n");
                break;
            case 1:
                sb.append("M=M-D\n");
                break;
            case 2:
                sb.append("M=D&M\n");
                break;
            case 3:
                sb.append("M=D|M\n");
                break;
        }

        sb.append("@SP\n");
        sb.append("M=M+1\n");
        return sb.toString();
    }


    /**
     * @param opCode  use to distinguish operation
     *                0 ==> gt
     *                1 ==> lt
     *                2 ==> eq
     * @param labelId use to distinguish label
     */
    public static String compOpProgram(int opCode, int labelId) {
        StringBuilder sb = new StringBuilder();
        sb.append("@SP\n");
        sb.append("AM=M-1\n");
        sb.append("D=M\n");
        sb.append("@SP\n");
        sb.append("AM=M-1\n");
        sb.append("D=D-M\n");

        sb.append("@IS_TRUE_").append(labelId).append("\n");
        switch (opCode) {
            case 0:
                sb.append("D;JLT\n");
                break;
            case 1:
                sb.append("D;JGT\n");
                break;
            case 2:
                sb.append("D;JEQ\n");
                break;
        }

        sb.append("@SP\n");
        sb.append("A=M\n");
        sb.append("M=0\n");
        sb.append("@END_").append(labelId).append("\n");
        sb.append("0;JMP\n");

        sb.append("(IS_TRUE_").append(labelId).append(")\n");
        sb.append("@SP\n");
        sb.append("A=M\n");
        sb.append("M=-1\n");
        sb.append("@END_").append(labelId).append("\n");
        sb.append("0;JMP\n");

        sb.append("(END_").append(labelId).append(")\n");
        sb.append("@SP\n");
        sb.append("M=M+1\n");

        return sb.toString();
    }


    public static String unaryOprProgram(int opCode) {
        StringBuilder sb = new StringBuilder();

        sb.append("@SP\n");
        sb.append("AM=M-1\n");
        if (opCode == 0)
            sb.append("M=-M\n");
        if (opCode == 1)
            sb.append("M=!M\n");
        sb.append("@SP\n");
        sb.append("M=M+1\n");

        return sb.toString();
    }
}
