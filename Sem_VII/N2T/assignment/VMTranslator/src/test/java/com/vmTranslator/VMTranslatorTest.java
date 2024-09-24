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
    private static final Path CURR_DIR = Paths.get("");

    private Path outputVmFilePath;
    private Path outputTstFilePath;
    private Path actualOutputFilePath;

    @BeforeEach
    void setup() {
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(outputVmFilePath);
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
        System.out.println("Input file path: " + inputFilePath.toAbsolutePath());

        VMTranslator.main(new String[]{inputFilePath.toString()});

        outputVmFilePath = VM_FILES_DIR.resolve(fileName.replace(".vm", ".asm"));
        outputTstFilePath = VM_FILES_DIR.resolve(fileName.replace(".vm", ".tst"));
        actualOutputFilePath = CURR_DIR.resolve("result.asm");


        System.out.println("Output VM file path: " + outputVmFilePath.toAbsolutePath());
        System.out.println("Actual output file path: " + actualOutputFilePath.toAbsolutePath());
        Files.copy(actualOutputFilePath, outputVmFilePath, StandardCopyOption.REPLACE_EXISTING);
        if(Files.exists(outputVmFilePath)){
            System.out.println("success "+outputTstFilePath.toAbsolutePath());
            runAndCheck(outputTstFilePath.toString());
        }
    }

    void runAndCheck(String pathToTestScript) throws InterruptedException, IOException {
        System.out.println(pathToTestScript);
        ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", "CPUEmulator.sh "+pathToTestScript);
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null)
            output.append(line).append("\n");
        int exitCode = process.waitFor();

        System.out.println("output : "+output.toString());
        String successMessage = "End of script - Comparison ended successfully";
        assertTrue(output.toString().contains(successMessage), "Test failed, success message not found in output : " + output);
        assertEquals(0, exitCode, "Process exited with non-zero exit code: " + exitCode);
    }
}