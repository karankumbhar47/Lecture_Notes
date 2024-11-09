package com.vmTranslator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.*;

class VMTranslatorTest {
    private static final Path VM_FILES_DIR = Paths.get("src/main/resources/VMFiles");
    private static final Path FUNC_FILES_DIR = Paths.get("src/main/resources/FunctionFiles");
    private static final Path BRANCH_FILES_DIR = Paths.get("src/main/resources/BranchingFiles");
    private static final Path CURR_DIR = Paths.get("");

    private Path outputAsmFilePath;
    private Path actualOutputFilePath;

    @BeforeEach
    void setup() {
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(outputAsmFilePath);
        Files.deleteIfExists(actualOutputFilePath);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "BasicTest.vm",
            "PointerTest.vm",
            "SimpleAdd.vm",
            "StackTest.vm",
            "StaticTest.vm",
    })
    void testHackAssembler(String fileName) throws IOException, InterruptedException {
        Path inputFilePath = VM_FILES_DIR.resolve(fileName);

        VMTranslator.main(new String[]{inputFilePath.toString()});

        actualOutputFilePath = CURR_DIR.resolve(fileName.replace(".vm", ".asm"));
        Path outputTstFilePath = VM_FILES_DIR.resolve(fileName.replace(".vm", ".tst"));
        outputAsmFilePath = VM_FILES_DIR.resolve(fileName.replace(".vm", ".asm"));

        Files.copy(actualOutputFilePath,outputAsmFilePath,StandardCopyOption.REPLACE_EXISTING);

        if(Files.exists(outputAsmFilePath)){
            runAndCheck(outputTstFilePath.toString());
        }
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "SimpleFunction",
            "NestedCall",
            "FibonacciElement",
            "StaticsTest"
    })
    void testFunction(String folderName) throws IOException, InterruptedException{
        Path sourceFolder = FUNC_FILES_DIR.resolve(folderName);

        VMTranslator.main(new String[]{sourceFolder.toString()});

        actualOutputFilePath = CURR_DIR.resolve(folderName+".asm");
        outputAsmFilePath = sourceFolder.resolve(folderName+".asm");
        Path outputTstFilePath = sourceFolder.resolve(folderName+".tst");
        Files.copy(actualOutputFilePath,outputAsmFilePath,StandardCopyOption.REPLACE_EXISTING);

        if(Files.exists(outputAsmFilePath)){
            runAndCheck(outputTstFilePath.toString());
        }
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "BasicLoop.vm",
            "FibonacciSeries.vm",
    })
    void testBranching(String fileName) throws IOException, InterruptedException{
        Path inputFileDir = BRANCH_FILES_DIR.resolve(fileName.replace(".vm",""));
        Path intputFilePath = inputFileDir.resolve(fileName);

        VMTranslator.main(new String[]{intputFilePath.toString()});

        actualOutputFilePath = CURR_DIR.resolve(fileName.replace(".vm",".asm"));
        outputAsmFilePath = inputFileDir.resolve(fileName.replace(".vm",".asm"));
        Path outputTstFilePath = inputFileDir.resolve(fileName.replace(".vm",".tst"));

        Files.copy(actualOutputFilePath,outputAsmFilePath,StandardCopyOption.REPLACE_EXISTING);

        if(Files.exists(outputAsmFilePath)){
            runAndCheck(outputTstFilePath.toString());
        }
    }

    void runAndCheck(String pathToTestScript) throws InterruptedException, IOException {
        System.out.println("Test script path: "+pathToTestScript);
        ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", "CPUEmulator.sh "+pathToTestScript);
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null)
            output.append(line).append("\n");
        int exitCode = process.waitFor();

        System.out.println("output : "+ output);
        String successMessage = "End of script - Comparison ended successfully";
        assertTrue(output.toString().contains(successMessage), "Test failed, success message not found in output : " + output);
        assertEquals(0, exitCode, "Process exited with non-zero exit code: " + exitCode);
    }


}