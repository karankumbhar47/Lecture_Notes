package com.coreJava;

import com.coreJava.FactoryPattern.CodeRunnerFactory;
import com.coreJava.FactoryPattern.CodeRunnerInterface;

public class Main{
    public static void main(String[] args) {
        System.out.println("Hello Gradle");

        CodeRunnerInterface runner = CodeRunnerFactory.createCodeRunner("list");
        // CodeRunnerInterface runner = CodeRunnerFactory.createCodeRunner("comp");
        runner.runCode();
    }
}