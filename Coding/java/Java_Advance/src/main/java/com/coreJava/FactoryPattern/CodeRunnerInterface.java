package com.coreJava.FactoryPattern;

public interface CodeRunnerInterface {
    void runCode();

    static void printSeparator(int questionNumber) {
        System.out.println("Question " + questionNumber + " " + "=".repeat(50));
    }
}