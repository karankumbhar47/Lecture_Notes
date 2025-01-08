package com.core_java.FactoryPattern;

public interface CodeRunnerInterface {
    void runCode();

    static void printSeparator(int questionNumber) {
        System.out.println("Question " + questionNumber + " " + "=".repeat(50));
    }
}