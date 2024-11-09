package com.vmTranslator.ProgramWritter;

import com.vmTranslator.utils.Context;
import com.vmTranslator.VMExceptions.SyntaxExceptions;

public class ArithmeticWriter {
    public static String binaryOprProgram(String operation, Context context) throws SyntaxExceptions {
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
                throw new SyntaxExceptions.InvalidBinaryOperationException(operation,context.getLineNumber(),context.getCurrentLine());
        }

        sb.append("@SP\n");
        sb.append("M=M+1\n");
        return sb.toString();
    }

    public static String compOpProgram(String operation, int labelId, Context context) throws SyntaxExceptions {
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
            default ->  throw new SyntaxExceptions.InvalidCompOperationException(operation,context.getLineNumber(),context.getCurrentLine());
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

    public static String unaryOprProgram(String operation, Context context) throws SyntaxExceptions{
        StringBuilder sb = new StringBuilder();

        sb.append("@SP\n");
        sb.append("AM=M-1\n");
        switch (operation){
            case "neg" -> sb.append("M=-M\n");
            case "not" -> sb.append("M=!M\n");
            default -> throw new SyntaxExceptions.InvalidUnaryOperationException(operation, context.getLineNumber(),context.getCurrentLine());
        }
        sb.append("@SP\n");
        sb.append("M=M+1\n");

        return sb.toString();
    }
}
