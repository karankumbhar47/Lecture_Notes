package com.vmTranslator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    private static Stream<Map.Entry<String, String>> provideTestCases() {
        Map<String, String> testCases = new HashMap<>();
        testCases.put("     ", ""); 
        testCases.put("\t\t\t", ""); 
        testCases.put("     \n", ""); 
        testCases.put("     \r\n", ""); 
        testCases.put("\n", ""); 
        testCases.put("\r\n", ""); 
        testCases.put("push constant 17 // this is a comment\n", "push constant 17");
        testCases.put("push constant 17 // this is a comment\r\n", "push constant 17");
        testCases.put("// this is a comment", "");
        testCases.put("push constant 17 // comment here  ", "push constant 17");
        testCases.put("push constant 17", "push constant 17");
        testCases.put("  push constant 17    ", "push constant 17");
        testCases.put("push constant 17\n", "push constant 17");
        testCases.put("push constant 17\r\n", "push constant 17");
        testCases.put("push constant 17\n", "push constant 17");
        testCases.put("push constant 17\r\n", "push constant 17");
        testCases.put("push constant 17 // comment\n", "push constant 17");
        testCases.put("push constant 17 // comment\r\n", "push constant 17");
        testCases.put("push constant 17 // comment \r\n", "push constant 17");
        testCases.put("push   constant   17   // comment\n", "push constant 17");
        testCases.put("", "");
        testCases.put("push constant 10 // first command\r\n", "push constant 10");
        testCases.put("// comment only\n", "");
        return testCases.entrySet().stream();
    }


    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testCleanLine(Map.Entry<String, String> testCase) {
        String input = testCase.getKey();
        String expected = testCase.getValue();
        assertEquals(expected,Utils.cleanLine(input), "Failed for input: " + input);
    }
}