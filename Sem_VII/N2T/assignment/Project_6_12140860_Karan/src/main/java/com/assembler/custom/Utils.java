package com.assembler.custom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.List;

public class Utils {
    public static boolean isNumeric(String s) {
        ParsePosition pos = new ParsePosition(0);
        NumberFormat.getInstance().parse(s, pos);
        return s.length() == pos.getIndex();
    }

    public static String toBinaryString(int number, int length) {
        String binary = Integer.toBinaryString(number);

        StringBuilder paddedBinary = new StringBuilder(binary);
        while (paddedBinary.length() < length) {
            paddedBinary.insert(0, '0');
        }

        if (paddedBinary.length() > length) {
            paddedBinary.setLength(length);
        }
        return paddedBinary.toString();
    }

    public static void writeBinInstruction(String fileName, List<String> instructionSet) throws IOException{
        Path currentDir = Paths.get("").toAbsolutePath();
        Path filePath = currentDir.resolve("result.hack");

        File file = filePath.toFile();
        boolean newFile = file.createNewFile();

        FileWriter writer = new FileWriter(file);
        for (String instruction: instructionSet){
            writer.write(instruction+"\n");
        }
        writer.close();
    }
}