package com.assembler;

import com.assembler.custom.InstructionType;
import org.w3c.dom.xpath.XPathResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Parser {

    private final BufferedReader reader;
    private String currentLine;

    public Parser(Path filePath) throws IOException {
        reader = Files.newBufferedReader(filePath);
        currentLine = null;
    }

    public boolean hasMoreLines() throws IOException{
        return reader.ready();
    }

    public void advance() throws IOException{
        do{
            currentLine = reader.readLine();
            if(currentLine!=null)
                currentLine = currentLine.trim();
        }while (currentLine!=null && (currentLine.isEmpty() || currentLine.startsWith("//")));
    }

    public InstructionType instructionType(){
        if (currentLine.contains("@"))
            return InstructionType.A_INSTRUCTION;
        else if (currentLine.startsWith("(") && currentLine.endsWith(")"))
            return InstructionType.L_INSTRUCTION;
        else
            return InstructionType.C_INSTRUCTION;
    }

    public String symbol(){
        if(instructionType()==InstructionType.A_INSTRUCTION)
            return currentLine.substring(1);
        else if(instructionType()==InstructionType.L_INSTRUCTION)
            return currentLine.substring(1,currentLine.length()-1);
        else
            return null;
    }

    public String dest(){
        if(instructionType()==InstructionType.C_INSTRUCTION){
            int equalIndex = currentLine.indexOf("=");
            if(equalIndex!=-1){
                return currentLine.substring(0,equalIndex);
            }
        }
        return null;
    }

    public String comp(){
        if(instructionType()==InstructionType.C_INSTRUCTION){
            int indexSemiColon = currentLine.indexOf(";");
            int indexEqual = currentLine.indexOf("=");

            if(indexEqual!=-1 && indexSemiColon!=-1)
                return currentLine.substring(indexEqual+1,indexSemiColon);
            else if(indexEqual!=-1)
                return currentLine.substring(indexEqual+1);
            else if(indexSemiColon!=-1)
                return currentLine.substring(0,indexSemiColon);
            else
                return currentLine;
        }
        return null;
    }

    public String jump(){
        if(instructionType()==InstructionType.C_INSTRUCTION){
            int semiColonIndex = currentLine.indexOf(";");
            if(semiColonIndex!=-1){
                return currentLine.substring(semiColonIndex+1);
            }
        }
        return null;
    }

    public void close() throws IOException {
        reader.close();
    }
}
