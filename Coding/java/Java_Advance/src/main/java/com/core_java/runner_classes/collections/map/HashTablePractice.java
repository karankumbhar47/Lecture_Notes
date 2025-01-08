package com.core_java.runner_classes.collections.map;

import com.core_java.FactoryPattern.CodeRunnerInterface;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

public class HashTablePractice implements CodeRunnerInterface{

    @Override
    public void runCode() {
        // HashTable (legacy class) replaced by concurrentHashMap
        // thread safe(synchronized)
        // no key or value as null allowed
        // slower than HashMap

        Hashtable<Integer,String> hashtable = new Hashtable<>();
        hashtable.put(1,"Some");
        hashtable.put(0,"Some1");
        hashtable.put(5,"Some2");
        hashtable.put(2,"Some3");
        System.out.println(hashtable);

        // not allowed
        // hashtable.put(null,"null");
        // hashtable.put(8,null);

        // we can iterate through elements using iterator and enumeration
        Enumeration<Integer> enumeration = hashtable.keys();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }

        threadSafe();
    }

    private void threadSafe(){
        HashMap<Integer,String> hashMap = new HashMap<>();
        Hashtable<Integer,String> hashTable = new Hashtable<>();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<1000;i++){
                    hashMap.put(i,"Thread1");
                    hashTable.put(i,"Thread1");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1000; i<2000;i++){
                    hashMap.put(i,"Thread2");
                    hashTable.put(i,"Thread2");
                }
            }
        });

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch (Exception ignored){}

        System.out.println("hashMap size "+hashMap.size());
        System.out.println("hashTable size "+hashTable.size());
    }
    
}
