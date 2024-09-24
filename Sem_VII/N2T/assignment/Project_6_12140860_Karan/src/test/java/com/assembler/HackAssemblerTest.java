package com.assembler;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HackAssemblerTest {

    private static final Path ASM_FILES_DIR = Paths.get("src/main/resources/AsmFiles");
    private static final Path HACK_FILES_DIR = Paths.get("src/main/resources/HackFiles");
    private static final Path OUTPUT_DIR = Paths.get("");
    private String outputFileName;

    @BeforeEach
    void setup() {
        HackAssembler.setLoggingLevel(Level.OFF);
    }

    @AfterEach
    void tearDown() throws IOException{
        Path outputFilePath = OUTPUT_DIR.resolve(outputFileName).toAbsolutePath();
        Files.deleteIfExists(outputFilePath);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Add.asm",
            "Max.asm",
            "MaxL.asm",
            "Pong.asm",
            "PongL.asm",
            "q0.asm",
            "q1.asm",
            "q2.asm",
            "q3.asm",
            "q4.asm",
            "q5.asm",
            "q6.asm",
            "q7_mult.asm",
            "q8_fill.asm",
            "Rect.asm",
            "RectL.asm",
    })
    void testHackAssembler(String fileName) throws IOException {
        outputFileName = fileName.replace(".asm", ".hack");
        Path expectedFilePath = HACK_FILES_DIR.resolve(outputFileName);
        Path outputFilePath = OUTPUT_DIR.resolve("result.hack");
        Path inputFilePath = ASM_FILES_DIR.resolve(fileName);

        HackAssembler.main(new String[]{inputFilePath.toString()});
        String outputContent = new String(Files.readAllBytes(outputFilePath.toAbsolutePath()));
        String expectedContent = new String(Files.readAllBytes(expectedFilePath));

        assertEquals(expectedContent, outputContent,
                "The content of the output file does not match the expected content for " + fileName);
    }
}
