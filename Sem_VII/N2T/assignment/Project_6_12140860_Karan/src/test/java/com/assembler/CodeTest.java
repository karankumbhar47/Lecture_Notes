package com.assembler;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodeTest {
    private Code code;

    @BeforeEach
    void setUp() {
        code = new Code();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void dest() {
        assertEquals("000", code.dest(null));
        assertEquals("001", code.dest("M"));
        assertEquals("010", code.dest("D"));
//        assertEquals("011", code.dest("DM"));
        assertEquals("011", code.dest("MD"));
        assertEquals("100", code.dest("A"));
        assertEquals("101", code.dest("AM"));
        assertEquals("110", code.dest("AD"));
        assertEquals("111", code.dest("ADM"));
    }

    @Test
    void comp() {
        // Test for all possible comp values
        assertEquals("0101010", code.comp("0"));
        assertEquals("0111111", code.comp("1"));
        assertEquals("0111010", code.comp("-1"));
        assertEquals("0001100", code.comp("D"));
        assertEquals("0110000", code.comp("A"));
        assertEquals("1110000", code.comp("M"));
        assertEquals("0001101", code.comp("!D"));
        assertEquals("0110001", code.comp("!A"));
        assertEquals("1110001", code.comp("!M"));
        assertEquals("0001111", code.comp("-D"));
        assertEquals("0110011", code.comp("-A"));
        assertEquals("1110011", code.comp("-M"));
        assertEquals("0011111", code.comp("D+1"));
        assertEquals("0110111", code.comp("A+1"));
        assertEquals("1110111", code.comp("M+1"));
        assertEquals("0001110", code.comp("D-1"));
        assertEquals("0110010", code.comp("A-1"));
        assertEquals("1110010", code.comp("M-1"));
        assertEquals("0000010", code.comp("D+A"));
        assertEquals("1000010", code.comp("D+M"));
        assertEquals("0010011", code.comp("D-A"));
        assertEquals("1010011", code.comp("D-M"));
        assertEquals("0000111", code.comp("A-D"));
        assertEquals("1000111", code.comp("M-D"));
        assertEquals("0000000", code.comp("D&A"));
        assertEquals("1000000", code.comp("D&M"));
        assertEquals("0010101", code.comp("D|A"));
        assertEquals("1010101", code.comp("D|M"));
    }


    @Test
    void jump() {
        assertEquals("000", code.jump(null));
        assertEquals("001", code.jump("JGT"));
        assertEquals("010", code.jump("JEQ"));
        assertEquals("011", code.jump("JGE"));
        assertEquals("100", code.jump("JLT"));
        assertEquals("101", code.jump("JNE"));
        assertEquals("110", code.jump("JLE"));
        assertEquals("111", code.jump("JMP"));
    }
}