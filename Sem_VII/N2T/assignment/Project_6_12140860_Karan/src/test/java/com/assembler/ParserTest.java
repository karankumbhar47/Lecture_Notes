package com.assembler;

import com.assembler.custom.InstructionType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    private Parser parser;
    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file with mock data for testing
        tempFile = Files.createTempFile("hack", ".asm");
        FileWriter writer = new FileWriter(tempFile.toFile());
        writer.write("""
                // This is a comment
                @isFilled
                M=0

                (setup)
                @SCREEN
                D=A
                """);
        writer.close();
        parser = new Parser(tempFile);
    }

    @AfterEach
    void tearDown() throws IOException {
        parser.close();
        Files.deleteIfExists(tempFile);
    }

    @Test
    void testHasMoreLines() throws IOException {
        assertTrue(parser.hasMoreLines());
        parser.advance();
        assertTrue(parser.hasMoreLines());
    }

    @Test
    void testAdvanceAndInstructionType() throws IOException {
        parser.advance(); // Skips the comment and advances to @isFilled
        assertEquals(InstructionType.A_INSTRUCTION, parser.instructionType());

        parser.advance(); // Advances to M=0
        assertEquals(InstructionType.C_INSTRUCTION, parser.instructionType());

        parser.advance(); // Advances to (setup)
        assertEquals(InstructionType.L_INSTRUCTION, parser.instructionType());
    }

    @Test
    void testSymbol() throws IOException {
        parser.advance(); // @isFilled
        assertEquals("isFilled", parser.symbol());

        parser.advance(); // M=0
        assertNull(parser.symbol());

        parser.advance(); // (setup)
        assertEquals("setup", parser.symbol());
    }

    @Test
    void testDest() throws IOException {
        parser.advance(); // @isFilled
        assertNull(parser.dest()); // A-instruction has no dest

        parser.advance(); // M=0
        assertEquals("M", parser.dest()); // dest for C-instruction

    }

    @Test
    void testComp() throws IOException {
        parser.advance(); // @isFilled
        assertNull(parser.comp()); // A-instruction has no comp

        parser.advance(); // M=0
        assertEquals("0", parser.comp()); // comp for C-instruction

        parser.advance(); // (setup)
        assertNull(parser.comp()); // L-instruction has no comp
    }

    @Test
    void testJump() throws IOException {
        parser.advance(); // @isFilled
        assertNull(parser.jump()); // A-instruction has no jump

        parser.advance(); // M=0
        assertNull(parser.jump()); // C-instruction with no jump

        // Now testing an instruction with a jump
        Files.writeString(tempFile, "D;JGT\n");
        parser = new Parser(tempFile);

        parser.advance();
        assertEquals("JGT",parser.jump());
    }

    @Test
    void testEdgeCases() throws IOException {
        Files.writeString(tempFile,"// comment\n\n@2");
        parser = new Parser(tempFile);

        parser.advance();
        assertEquals(InstructionType.A_INSTRUCTION, parser.instructionType());
        assertEquals("2", parser.symbol());
    }
}