package com.coreJava.FactoryPattern;

import java.util.HashMap;
import java.util.Map;

import com.coreJava.RunnerClasses.Advance.StreamPractice;
import com.coreJava.RunnerClasses.List.ListPractice;
import com.coreJava.RunnerClasses.Map.HashMapPractice;

public class CodeRunnerRegistry {
    private static final Map<CodeRunnerType, Class<? extends CodeRunnerInterface>> registry = new HashMap<>();

    static {
        register(CodeRunnerType.STREAM, StreamPractice.class);
        register(CodeRunnerType.LIST, ListPractice.class);
        register(CodeRunnerType.MAP_HASHMAP, HashMapPractice.class);
    }

    public static void register(CodeRunnerType type, Class<? extends CodeRunnerInterface> clazz) {
        registry.put(type, clazz);
    }

    // Method to create an instance based on the key
    public static CodeRunnerInterface createInstance(CodeRunnerType key) {
        Class<? extends CodeRunnerInterface> clazz = registry.get(key);
        if (clazz == null)
            throw new IllegalArgumentException("No runner registered for key: " + key);

        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate CodeRunner for key: " + key, e);
        }
    }
}
