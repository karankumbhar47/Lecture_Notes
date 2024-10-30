package com.vmTranslator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vmTranslator.VMExceptions.SyntaxExceptions;
import com.vmTranslator.VMExceptions.SyntaxExceptions.*;

public class Utils {
    private static final int maxMemoryCount = 32767;

    private static void validateIndex(int index, int max,Context context) throws SyntaxExceptions {
        if(index<0)
            throw  new NegativeIndexException(context.getLineNumber(),context.getCurrentLine());
        if (index > max)
            throw new IndexOutOfBondException(index, 0, max,context.getLineNumber(),context.getCurrentLine());
    }

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


    public static String pushAddProgram(String segment, int index,Context context) throws SyntaxExceptions {
        validateIndex(index, maxMemoryCount,context);
        StringBuilder sb = new StringBuilder();
        sb.append("@").append(index).append("\n");
        sb.append("D=A\n");
        switch (segment) {
            case "local" -> sb.append("@LCL\n");
            case "argument" -> sb.append("@ARG\n");
            case "this" -> sb.append("@THIS\n");
            case "that" -> sb.append("@THAT\n");
            default -> throw new InvalidPushPopAddSegmentException
                    (segment,context.getLineNumber(), context.getCurrentLine());
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
    

    public static String pushProgram(String segment, int index, Context context) throws  SyntaxExceptions{
        validateIndex(index, maxMemoryCount,context);
        StringBuilder sb = new StringBuilder();
        switch (segment) {
            case "temp" -> {
                validateIndex(index, 7,context);
                sb.append("@").append(5 + index).append("\n");
            }
            case "static" -> {
                validateIndex(index, 239,context);
                sb.append("@Static.").append(index).append("\n");
            }
            case "pointer" -> {
                validateIndex(index, 1,context);
                sb.append("@").append((index == 0) ? "THIS" : "THAT").append("\n");
            }
            default -> throw new InvalidPushPopSegmentException(segment,context.getLineNumber(),context.getCurrentLine());
        }

        sb.append("D=M\n");
        sb.append("@SP\n");
        sb.append("A=M\n");
        sb.append("M=D\n");
        sb.append("@SP\n");
        sb.append("M=M+1\n");
        return sb.toString();
    }


    public static String pushConstProgram(int index,Context context) throws  SyntaxExceptions{
        validateIndex(index, maxMemoryCount,context);
        return "@" + index + "\n" +
                "D=A\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1\n";
    }


    public static String popProgram(String segment, int index,Context context) throws SyntaxExceptions{
        validateIndex(index, maxMemoryCount,context);
        StringBuilder sb = new StringBuilder();
        sb.append("@SP\n");
        sb.append("AM=M-1\n");
        sb.append("D=M\n");
        switch (segment) {
            case "temp" -> {
                validateIndex(index, 7,context);
                sb.append("@").append(5 + index).append("\n");
            }
            case "pointer" -> {
                validateIndex(index, 1,context);
                sb.append("@").append((index == 0) ? "THIS" : "THAT").append("\n");
            }
            case "static" -> {
                validateIndex(index, 239,context);
                sb.append("@Static.").append(index).append("\n");
            }
            default -> throw new InvalidPushPopSegmentException(segment, context.getLineNumber(), context.getCurrentLine());
        }
        sb.append("M=D\n");
        return sb.toString();
    }


    public static String popAddProgram(String segment, int index,Context context) throws SyntaxExceptions{
        validateIndex(index, maxMemoryCount,context);
        String segSymbol = switch (segment) {
            case "local" -> "LCL";
            case "argument" -> "ARG";
            case "this" -> "THIS";
            case "that" -> "THAT";
            default -> throw new InvalidPushPopAddSegmentException(segment,context.getLineNumber(),context.getCurrentLine());
        };

        return "@" + index + "\n" +
                "D=A\n" +
                "@" + segSymbol + "\n" +
                "D=D+M\n" +
                "@R13\n" +
                "M=D\n" +
                "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@R13\n" +
                "A=M\n" +
                "M=D\n";
    }


    public static String binaryOprProgram(String operation,Context context) throws SyntaxExceptions{
        StringBuilder sb = new StringBuilder();

        sb.append("@SP\n");
        sb.append("AM=M-1\n");
        sb.append("D=M\n");

        sb.append("@SP\n");
        sb.append("AM=M-1\n");

        switch (operation) {
            case "add":
                sb.append("M=D+M\n");
                break;
            case "sub" :
                sb.append("M=M-D\n");
                break;
            case "and":
                sb.append("M=D&M\n");
                break;
            case "or":
                sb.append("M=D|M\n");
                break;
            default:
                throw new InvalidBinaryOperationException(operation,context.getLineNumber(),context.getCurrentLine());
        }

        sb.append("@SP\n");
        sb.append("M=M+1\n");
        return sb.toString();
    }


    /**
     * @param operation use to distinguish operation
     * @param labelId use to distinguish label
     */
    public static String compOpProgram(String operation, int labelId,Context context) throws SyntaxExceptions {
        StringBuilder sb = new StringBuilder();
        sb.append("@SP\n");
        sb.append("AM=M-1\n");
        sb.append("D=M\n");
        sb.append("@SP\n");
        sb.append("AM=M-1\n");
        sb.append("D=D-M\n");

        sb.append("@IS_TRUE_").append(labelId).append("\n");
        switch (operation) {
            case "gt" -> sb.append("D;JLT\n");
            case "lt" -> sb.append("D;JGT\n");
            case "eq" -> sb.append("D;JEQ\n");
            default ->  throw new InvalidCompOperationException(operation,context.getLineNumber(),context.getCurrentLine());
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


    public static String unaryOprProgram(String operation,Context context) throws SyntaxExceptions{
        StringBuilder sb = new StringBuilder();

        sb.append("@SP\n");
        sb.append("AM=M-1\n");
        switch (operation){
            case "neg" -> sb.append("M=-M\n");
            case "not" -> sb.append("M=!M\n");
            default -> throw new InvalidUnaryOperationException(operation, context.getLineNumber(),context.getCurrentLine());
        }
        sb.append("@SP\n");
        sb.append("M=M+1\n");

        return sb.toString();
    }
}
