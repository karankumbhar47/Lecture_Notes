package com.vmTranslator.ProgramWritter;

import com.vmTranslator.VMExceptions.SyntaxExceptions;

public class FunctionWriter {
    public static String writeFunctionCode(String functionName, int nVars,String fileName) throws SyntaxExceptions {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(functionName).append(")\n");
        for (int index = 0; index < nVars; index++) {
            sb.append(PushPopWriter.pushProgram("constant",0,null,null));
//            sb.append("@").append(index).append("\n");
//            sb.append("D=A\n");
//            sb.append("@LCL\n");
//            sb.append("A=D+M\n");
//            sb.append("M=0\n");
        }
        return sb.toString();
    }

    public static String writeCallCode(String prevFunction, String functionName, int nArgs, int retIndex){
        //TODO: here function name should be like filename.functionName
        String returnLabel = prevFunction+"$ret."+retIndex;
        return saveReturnAddress(returnLabel) +
                saveSegment("LCL") +
                saveSegment("ARG") +
                saveSegment("THIS") +
                saveSegment("THAT") +
                repositionARG(nArgs) +
                repositionLCL() +
                "@" + functionName+ "\n" +
                "0;JMP\n" +
                "(" + returnLabel + ")\n";
    }

    public static String writeReturnCode(){
        return storeRetAddr() +
                storeRetValue() +
                repositionArg() +
                restoreSegment("THAT", 1) +
                restoreSegment("THIS", 2) +
                restoreSegment("ARG", 3) +
                restoreSegment("LCL", 4) +

                "@R14\n" +
                "A=M\n" +
                "0;JMP\n";
    }

    private static String saveReturnAddress(String returnLabel){
        return "@" + returnLabel + "\n" +
                "D=A\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1\n";
    }

    private static String saveSegment(String segment){
        return "@"+segment+"\n" +
               "D=M\n" +
               "@SP\n" +
               "A=M\n" +
               "M=D\n" +
               "@SP\n" +
               "M=M+1\n";
    }

    private static String repositionARG(int nArgs) {
        return "@SP\n" +
               "D=M\n" +
               "@5\n" +
               "D=D-A\n" +
               "@"+nArgs+"\n" +
               "D=D-A\n" +
               "@ARG\n" +
               "M=D\n";
    }

    private static String repositionLCL() {
        return "@SP\n"+
               "D=M\n"+
               "@LCL\n"+
               "M=D\n";
    }

    private static String storeRetAddr() {
        return "@LCL\n" +
                "D=M\n" +
                "@R13\n" +
                "M=D\n" +
                "@5\n" +
                "A=D-A\n" +
                "D=M\n" +
                "@R14\n" +
                "M=D\n";
    }

    private static String storeRetValue() {
        return "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@ARG\n" +
                "A=M\n" +
                "M=D\n";
    }

    private static String repositionArg(){
        return "@ARG\n"+
        "D=M+1\n"+
        "@SP\n"+
        "M=D\n";
    }

    private static String restoreSegment(String segment, int padding) {
        return "@" + padding + "\n" +
                "D=A\n" +
                "@R13\n" +
                "A=M-D\n" +
                "D=M\n" +
                "@" + segment + "\n" +
                "M=D\n";
    }
}
