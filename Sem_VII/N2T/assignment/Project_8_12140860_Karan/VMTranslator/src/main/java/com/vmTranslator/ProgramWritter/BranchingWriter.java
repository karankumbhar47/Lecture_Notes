package com.vmTranslator.ProgramWritter;

public class BranchingWriter {
    public static String writeLabelCode(String label,String functionName,String fileName){
        System.out.println(functionName);
//        if(functionName==null)
//            return "("+fileName+".$"+label+")\n";
//        return "("+fileName+"."+functionName+"$"+label+")\n";
        return "("+label+")\n";
    }

    public static String writeGotoCode(String label){
        return "@"+label+"\n"+
               "0;JMP\n";
    }

    public static String writeIfGotoCode(String label){
        System.out.println("writing if goto code for label "+label);
        return "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@" + label + "\n" +
                "D;JNE\n";
    }
}
