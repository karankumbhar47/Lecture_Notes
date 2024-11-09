package com.vmTranslator.ProgramWritter;

import com.vmTranslator.utils.Context;
import com.vmTranslator.utils.Utils;
import com.vmTranslator.VMExceptions.SyntaxExceptions;

public class PushPopWriter {
    private static final int maxMemoryCount = 32767;

    public static String pushProgram(String segment, int index,String fileName, Context context) throws SyntaxExceptions {
        Utils.validateIndex(index, maxMemoryCount, context);

        StringBuilder sb = new StringBuilder();
        switch (segment) {
            case "constant" -> {
                sb.append("@").append(index).append("\n");
                sb.append("D=A\n");
            }
            case "temp" -> {
                Utils.validateIndex(index, 7, context);
                sb.append("@").append(5 + index).append("\n");
                sb.append("D=M\n");
            }
            case "pointer" -> {
                Utils.validateIndex(index, 1, context);
                sb.append("@").append((index == 0) ? "THIS" : "THAT").append("\n");
                sb.append("D=M\n");
            }
            case "static" -> {
                Utils.validateIndex(index, 239, context);
                sb.append("@").append(fileName).append(".").append(index).append("\n");
                sb.append("D=M\n");
            }
            case "local", "argument", "this", "that" -> {
                String segmentPointer = switch (segment) {
                    case "local" -> "LCL";
                    case "argument" -> "ARG";
                    case "this" -> "THIS";
                    case "that" -> "THAT";
                    default -> throw new SyntaxExceptions.UnExceptedSegmentException(segment, context.getLineNumber(), context.getCurrentLine());
                };
                sb.append("@").append(index).append("\n");
                sb.append("D=A\n");
                sb.append("@").append(segmentPointer).append("\n");
                sb.append("A=D+M\n");
                sb.append("D=M\n");
            }
            default -> throw new SyntaxExceptions.InvalidSegmentException
                    (segment, context.getLineNumber(), context.getCurrentLine());
        }

        sb.append("@SP\n");
        sb.append("A=M\n");
        sb.append("M=D\n");
        sb.append("@SP\n");
        sb.append("M=M+1\n");

        return sb.toString();
    }

    public static String popProgram(String segment, int index,String fileName, Context context) throws SyntaxExceptions {
        Utils.validateIndex(index, maxMemoryCount, context);

        StringBuilder sb = new StringBuilder();

        switch (segment) {
            case "temp" -> {
                Utils.validateIndex(index, 7, context);
                sb.append("@SP\n");
                sb.append("AM=M-1\n");
                sb.append("D=M\n");
                sb.append("@").append(5 + index).append("\n");
                sb.append("M=D\n");
            }
            case "pointer" -> {
                Utils.validateIndex(index, 1, context);
                sb.append("@SP\n");
                sb.append("AM=M-1\n");
                sb.append("D=M\n");
                sb.append("@").append((index == 0) ? "THIS" : "THAT").append("\n");
                sb.append("M=D\n");
            }
            case "static" -> {
                Utils.validateIndex(index, 239, context);
                sb.append("@SP\n");
                sb.append("AM=M-1\n");
                sb.append("D=M\n");
                sb.append("@").append(fileName).append(".").append(index).append("\n");
                sb.append("M=D\n");
            }
            case "local", "argument", "this", "that" -> {
                String segmentPointer = switch (segment) {
                    case "local" -> "LCL";
                    case "argument" -> "ARG";
                    case "this" -> "THIS";
                    case "that" -> "THAT";
                    default -> throw new SyntaxExceptions.UnExceptedSegmentException(segment, context.getLineNumber(), context.getCurrentLine());
                };
                sb.append("@").append(index).append("\n");
                sb.append("D=A\n");
                sb.append("@").append(segmentPointer).append("\n");
                sb.append("D=D+M\n");
                sb.append("@R13\n");
                sb.append("M=D\n");

                // Pop the value from the stack and store it at the calculated address
                sb.append("@SP\n");
                sb.append("AM=M-1\n");
                sb.append("D=M\n");
                sb.append("@R13\n");
                sb.append("A=M\n");
                sb.append("M=D\n");
            }
            default -> throw new SyntaxExceptions.InvalidSegmentException
                    (segment, context.getLineNumber(), context.getCurrentLine());
        }

        return sb.toString();
    }

}
