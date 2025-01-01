package com.coreJava.RunnerClasses.Map;

import java.util.LinkedHashMap;

import com.coreJava.FactoryPattern.CodeRunnerInterface;

public class LRUCache<K, V> extends LinkedHashMap<K, V> implements CodeRunnerInterface {
    // our aim to create a map that will only contain 3 elements at max
    // at a time also this will use LRU algorithm to remove extra elements
    private int capacity;

    public LRUCache(Integer capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        return this.size() > capacity;
    }

    @Override
    public void runCode() {
        LRUCache<String, Integer> studentMarks = new LRUCache<>(3);
        studentMarks.put("student 1", 12);
        System.out.println(studentMarks);
        studentMarks.put("student 2", 8);
        System.out.println(studentMarks);
        studentMarks.put("student 3", 17);
        System.out.println(studentMarks);
        studentMarks.put("student 1", 13);
        System.out.println(studentMarks);

        // remove student 2
        studentMarks.put("student 4", 12);
        System.out.println(studentMarks);
        System.out.println(studentMarks.get("student 2")); //null 

        studentMarks.put("student 6", 15);
        System.out.println(studentMarks);
        studentMarks.put("student 4", 12);
        System.out.println(studentMarks);

    }

}
