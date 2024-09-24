package com.assembler.custom;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public final class DataMap {
    public static final Logger logger = Logger.getLogger("com.assembler.HackAssembler");
    public static final Path ASM_FILES_DIR = Paths.get("src/main/resources/AsmFiles");
    public static final Path HACK_FILES_DIR = Paths.get("src/main/resources/HackFiles");
    public static final Path OUTPUT_DIR = Paths.get("src/main/resources/out");


    public static final Map<String, Integer> jumpMap = new HashMap<>();

    static {
        jumpMap.put(null, 0);
        jumpMap.put("JGT", 1);
        jumpMap.put("JEQ", 2);
        jumpMap.put("JGE", 3);
        jumpMap.put("JLT", 4);
        jumpMap.put("JNE", 5);
        jumpMap.put("JLE", 6);
        jumpMap.put("JMP", 7);
    }

    public static final Map<String, Integer> compMap = new HashMap<>();

    static {
        compMap.put("0", 42);
        compMap.put("1", 63);
        compMap.put("-1", 58);
        compMap.put("D", 12);
        compMap.put("A", 48);
        compMap.put("M", 112);
        compMap.put("!D", 13);
        compMap.put("!A", 49);
        compMap.put("!M", 113);
        compMap.put("-D", 15);
        compMap.put("-A", 51);
        compMap.put("-M", 115);
        compMap.put("D+1", 31);
        compMap.put("A+1", 55);
        compMap.put("M+1", 119);
        compMap.put("D-1", 14);
        compMap.put("A-1", 50);
        compMap.put("M-1", 114);
        compMap.put("D+A", 2);
        compMap.put("D+M", 66);
        compMap.put("D-A", 19);
        compMap.put("D-M", 83);
        compMap.put("A-D", 7);
        compMap.put("M-D", 71);
        compMap.put("D&A", 0);
        compMap.put("D&M", 64);
        compMap.put("D|A", 21);
        compMap.put("D|M", 85);
    }

    public static final Map<String,Integer> destMap = new HashMap<>();

    static {
        destMap.put(null ,0);
        destMap.put("M"  ,1);
        destMap.put("D"  ,2);
        destMap.put("MD" ,3);
        destMap.put("DM" ,3);
        destMap.put("A"  ,4);
        destMap.put("AM" ,5);
        destMap.put("AD" ,6);
        destMap.put("ADM",7);
        destMap.put("AMD",7);
    }


    private DataMap() {
    }

}
