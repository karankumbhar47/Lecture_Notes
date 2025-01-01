package com.coreJava.RunnerClasses.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.coreJava.FactoryPattern.CodeRunnerInterface;
import com.coreJava.models.StudentObject;

public class HashMapPractice implements CodeRunnerInterface {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(18, 0.7f);
        map.put(11, "Karan");
        map.put(12, "Rohan");
        System.out.println(map);

        String name = map.get(11);
        System.out.println(name);

        String name1 = map.get(12);
        System.out.println(name1); // null

        System.out.println(map.containsKey(11));
        System.out.println(map.containsValue("Karan"));

        Set<Integer> keys = map.keySet();
        for (int key : keys) {
            System.out.println(map.get(key));
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            entry.setValue(entry.getValue().toUpperCase());
        }
        System.out.println(map);

        System.out.println(map.remove(21));
        System.out.println(map.remove(11, "Nothing"));

        // constant time (get, set, remove)

        /*
         * key -> hasCode -> index -> store (key+value)
         * index = hashCode % arrSize
         * multiple (key-value) s at one index
         * internal one array(data structure ->Node)
         * Node<K,V>{
         * final int hash; // hash of key
         * final K key
         * V value;
         * Node<K,V> next; // pointer to next node
         * }
         * hashFunction -> deterministic/ may have possible collision(use linked list to
         * store
         * multiple values at the same location)
         * 
         * 
         * Treefication ->
         * when linked list size grows more than 8 then linked list(BigO(n)) converted
         * to
         * a Binary Search tree (BigO(logN) (Red-Black tree) -> self balanced binary
         * search tree
         * 
         * HashMap resizing
         * when map size gets bigger than (loadFactor * capacity) then map will resize
         * itself
         * called as hashmap resizing
         * Default size = 16;
         * load Factor = 0.75;
         * (array size will be doubled, all values will be rehashed)
         */

        // basically both s1 and s2 are same student but by equals method
        // they are not equal as their references are different
        // so better to override the equals method and hashCode method (to preserve
        // contract)
        StudentObject s1 = new StudentObject("Karan", 1);
        StudentObject s2 = new StudentObject("Karan", 1);
        StudentObject s3 = new StudentObject("Pratik", 2);

        HashMap<StudentObject, Integer> studentMarks = new HashMap<>();
        // if we override equals method of student object then s1 and s3 are
        // logically same objects to hashmap will have only size 2. If
        // we don't , then size will be 3.
        studentMarks.put(s1, 10);
        studentMarks.put(s2, 20);
        studentMarks.put(s3, 30);
        System.out.println(studentMarks);

    }

    @Override
    public void runCode() {
        HashMapPractice.main(null);
    }

}