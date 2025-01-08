package com.core_java;

import com.core_java.FactoryPattern.CodeRunnerFactory;
import com.core_java.FactoryPattern.CodeRunnerInterface;
import com.core_java.FactoryPattern.CodeRunnerRegistry;
import com.core_java.FactoryPattern.CodeRunnerType;
import com.core_java.runner_classes.collections.map.HashTablePractice;
import com.core_java.runner_classes.collections.map.LRUCache;
import com.core_java.runner_classes.collections.map.LinkedHashMapPractice;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Program ...\n");

        CodeRunnerRegistry.register(CodeRunnerType.MAP_HASH_TABLE,HashTablePractice.class);
        CodeRunnerRegistry.register(CodeRunnerType.MAP_LINKED_HASHMAP,LinkedHashMapPractice.class);
        CodeRunnerRegistry.register(CodeRunnerType.MAP_LRU_CACHE,LRUCache.class);

        // CodeRunnerInterface runner = CodeRunnerRegistry.createInstance(CodeRunnerType.MAP_LRU_CACHE);
        CodeRunnerInterface runner = CodeRunnerFactory.createCodeRunner(CodeRunnerType.JAVA8_STREAM);
        runner.runCode();
    }
}