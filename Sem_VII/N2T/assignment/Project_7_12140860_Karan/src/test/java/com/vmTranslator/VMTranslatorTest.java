package com.vmTranslator;

import com.vmTranslator.VMExceptions.SyntaxExceptions;
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

    private Path outputAsmFilePath;

    @BeforeEach
    void setup() {
        CodeWriter.isTesting = true;
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(outputAsmFilePath);
        CodeWriter.isTesting = false;
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "BasicTest.vm",
            "PointerTest.vm",
            "SimpleAdd.vm",
            "StackTest.vm",
            "StaticTest.vm",
    })
    void testHackAssembler(String fileName) throws IOException, InterruptedException, SyntaxExceptions {
        Path inputFilePath = VM_FILES_DIR.resolve(fileName);

        VMTranslator.main(new String[]{inputFilePath.toString()});

        outputAsmFilePath = VM_FILES_DIR.resolve(fileName.replace(".vm", ".asm"));
        Path outputTstFilePath = VM_FILES_DIR.resolve(fileName.replace(".vm", ".tst"));

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