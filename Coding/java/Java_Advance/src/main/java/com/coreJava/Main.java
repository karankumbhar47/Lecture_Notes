package com.coreJava;

import com.coreJava.FactoryPattern.CodeRunnerFactory;
import com.coreJava.FactoryPattern.CodeRunnerInterface;
import com.coreJava.FactoryPattern.CodeRunnerRegistry;
import com.coreJava.FactoryPattern.CodeRunnerType;
import com.coreJava.RunnerClasses.Map.HashTablePractice;
import com.coreJava.RunnerClasses.Map.LRUCache;
import com.coreJava.RunnerClasses.Map.LinkedHashMapPractice;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Program ...\n");

        CodeRunnerRegistry.register(CodeRunnerType.MAP_HASH_TABLE,HashTablePractice.class);
        CodeRunnerRegistry.register(CodeRunnerType.MAP_LINKED_HASHMAP,LinkedHashMapPractice.class);
        CodeRunnerRegistry.register(CodeRunnerType.MAP_LRU_CACHE,LRUCache.class);

        // CodeRunnerInterface runner = CodeRunnerRegistry.createInstance(CodeRunnerType.MAP_LRU_CACHE);
        CodeRunnerInterface runner = CodeRunnerFactory.createCodeRunner(CodeRunnerType.BASIC_REF);
        runner.runCode();
    }
}