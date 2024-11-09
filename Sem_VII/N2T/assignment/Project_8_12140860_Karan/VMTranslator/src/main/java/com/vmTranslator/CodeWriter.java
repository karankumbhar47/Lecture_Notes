package com.vmTranslator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.vmTranslator.Parser.CommandType;
import com.vmTranslator.ProgramWritter.ArithmeticWriter;
import com.vmTranslator.ProgramWritter.BranchingWriter;
import com.vmTranslator.ProgramWritter.FunctionWriter;
import com.vmTranslator.ProgramWritter.PushPopWriter;
import com.vmTranslator.utils.Context;
import com.vmTranslator.utils.Utils;
import com.vmTranslator.VMExceptions.SyntaxExceptions;
import com.vmTranslator.VMExceptions.SyntaxExceptions.*;

public class CodeWriter {
    private String inputFileName;
    private int labelID = 0;
    private String functionName;
    private final BufferedWriter writer;

    CodeWriter(String outputFileName) throws IOException {
        Path outputFilePath = Paths.get("").resolve(outputFileName);
        writer = new BufferedWriter(new FileWriter(outputFilePath.toFile()));
        System.out.println("Output File Will be generated at location : \n"+ outputFilePath.toAbsolutePath());
    }

    public void setInputFileName(String inputFileName){
        this.inputFileName = inputFileName;
    }

    public void writeArithmetic(String command, Context context) throws IOException, SyntaxExceptions {
        String program = switch (command) {
            case "add","sub","and","or" -> ArithmeticWriter.binaryOprProgram(command,context);
            case "neg","not" -> ArithmeticWriter.unaryOprProgram(command,context);
            case "gt","lt","eq" -> ArithmeticWriter.compOpProgram(command, labelID++,context);
            default -> throw new InvalidArithmeticCommandException(command,context.getLineNumber(),context.getCurrentLine());
        };
        if (!program.isEmpty()) {
            writer.write(program);
            writer.flush();
        }
    }

    public void writeInit(int retIndex) throws IOException {
        String program = "@256\n" +
                "D=A\n" +
                "@SP\n" +
                "M=D\n"+
                FunctionWriter.writeCallCode("BootStrap", "Sys.init", 0,retIndex);

        writer.write(program);
        writer.flush();
    }

    public void writePushPop(CommandType commandType, String segment, int index, Context context) throws IOException, SyntaxExceptions {
        if (Utils.segmentList.contains(segment)) {
            String program;
            if (commandType == CommandType.C_PUSH)
                program = PushPopWriter.pushProgram(segment, index, inputFileName,context);
            else if (commandType == CommandType.C_POP)
                program = PushPopWriter.popProgram(segment, index, inputFileName,context);
            else
                throw new InvalidCommandException(commandType.name(), context.getLineNumber(), context.getCurrentLine());

            writer.write(program);
            writer.flush();
        }
        else throw new InvalidSegmentException(segment, context.getLineNumber(), context.getCurrentLine());
    }

    public void writeLabel(String label) throws IOException{
        writer.write(BranchingWriter.writeLabelCode(label,functionName, inputFileName));
        writer.flush();
    }

    public void writeGoTo(String label) throws IOException{
        writer.write(BranchingWriter.writeGotoCode(label));
        writer.flush();
    }

    public void writeIf(String label) throws IOException{
        writer.write(BranchingWriter.writeIfGotoCode(label));
        writer.flush();
    }

    public void writeFunction(String functionName, int nVars) throws IOException, SyntaxExceptions{
        writer.write(FunctionWriter.writeFunctionCode(functionName,nVars, inputFileName));
        writer.flush();
        this.functionName = functionName;
    }

    public void writeCall(String functionName, int nArgs,int retIndex) throws IOException{
        writer.write(FunctionWriter.writeCallCode(this.functionName,functionName,nArgs,retIndex));
        writer.flush();
    }

    public void writeReturn() throws IOException{
        writer.write(FunctionWriter.writeReturnCode());
        writer.flush();
    }

    public void close() throws IOException {
        if (writer != null) {
            writer.flush();
            writer.close();
        }
    }
}
