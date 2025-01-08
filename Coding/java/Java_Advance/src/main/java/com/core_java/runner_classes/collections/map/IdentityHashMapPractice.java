package com.core_java.runner_classes.collections.map;

import com.core_java.FactoryPattern.CodeRunnerInterface;

import java.util.IdentityHashMap;

public class IdentityHashMapPractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        identityHashCode();

        System.out.println("\nIdentity Hash Map");
        String k1 = new String("key1");
        String k2 = new String("key1");
        IdentityHashMap<String,Integer> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(k1,1);
        identityHashMap.put(k2,2);
        System.out.println(identityHashMap);

        System.out.println("\n Identity Hash map with string literals");
        String k3 = "key1";
        String k4 = "key1";
        // taken from string pool
        System.out.println(System.identityHashCode(k3));
        IdentityHashMap<String,Integer> identityHashMap1 = new IdentityHashMap<>();
        identityHashMap1.put(k3,1);
        identityHashMap1.put(k4,2);
        System.out.println(identityHashMap1);


    }

    private void identityHashCode(){
        System.out.println("\nString object");
        String k1 = new String("key1");
        String k2 = new String("key1");

        // hash of their reference
        System.out.println(System.identityHashCode(k1));
        System.out.println(System.identityHashCode(k2));

        // hash of their values
        System.out.println(k1.hashCode());
        System.out.println(k2.hashCode());

        System.out.println("\nString pool");
        String k3 =  "key1";
        String k4 =  "key1";

        // hash of their reference
        System.out.println(System.identityHashCode(k3));
        System.out.println(System.identityHashCode(k4));

        // hash of their values
        System.out.println(k3.hashCode());
        System.out.println(k4.hashCode());
    }
}
