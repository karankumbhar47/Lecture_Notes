package com.coreJava.RunnerClasses.Map;

import java.util.*;

import com.coreJava.FactoryPattern.CodeRunnerInterface;
import com.coreJava.models.Student;

class SomeClass{
    private int id;
    private String Name;

    public SomeClass(int id, String name) {
        this.id = id;
        Name = name;
    }

    @Override
    public String toString() {
        return "someClass{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

public class LinkedHashMapPractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        // unordered map 
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Hello", 1);
        hashMap.put("from", 2);
        hashMap.put("me", 3);
        hashMap.put("!!!", 4);
        System.out.println(hashMap);

        // ordered a map (slower as it maintains order) (also not thread safe)
        // used a double linked list as internal implementation
        // also we can mention load-factor and capacity
        // load factor > 1f is not good, this leads to many collisions;
        // access order parameter used for getting least recently used algorithm
        // take higher memory and time than excepted
        // also it is not a thread safe
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(4, 5f, true);
        linkedHashMap.put("Hello", 1);
        linkedHashMap.put("from", 2);
        linkedHashMap.put("me", 3);
        linkedHashMap.put("!!!", 4);
        System.out.println(linkedHashMap);
        linkedHashMap.get("!!!");
        linkedHashMap.get("me");
        linkedHashMap.get("from");
        linkedHashMap.get("me");
        linkedHashMap.get("!!!");
        linkedHashMap.get("Hello");
        linkedHashMap.get("!!!");
        linkedHashMap.get("Hello");
        linkedHashMap.put("Hello",0);
        System.out.println("Least recently used");
        System.out.println(linkedHashMap);


        LinkedHashMap<String,Integer> linkedHashMap2 = new LinkedHashMap<>(hashMap);
        System.out.println("linked hash map 2");
        System.out.println(linkedHashMap2);

        System.out.println("get of default");
        System.out.println(linkedHashMap.getOrDefault("me", -1));
        System.out.println(linkedHashMap.getOrDefault("nothing", -1));

        System.out.println("put if absent");
        System.out.println(linkedHashMap.putIfAbsent("me", 44));
        System.out.println(linkedHashMap.putIfAbsent("nothing", 39));
        System.out.println(linkedHashMap);

        // SomeClass
        System.out.println("Object Linked HashMap");
        LinkedHashMap<SomeClass,Integer> map3 = new LinkedHashMap<>();
        SomeClass someClass1 = new SomeClass(1,"Karan");
        SomeClass someClass2 = new SomeClass(2,"Alice");
        SomeClass someClass3 = new SomeClass(3,"Bob");
        SomeClass someClass4 = new SomeClass(4,"Oscar");
        SomeClass someClass5 = new SomeClass(1,"Karan");
        map3.put(someClass1,11);
        map3.put(someClass2,12);
        map3.put(someClass3,13);
        map3.put(someClass4,14);
        map3.putIfAbsent(someClass5,15);
        System.out.println(map3);

        System.out.println("Other methods");
        map3.forEach((a,b) -> System.out.println(a+" "+b));
        for(Map.Entry<SomeClass,Integer> entry: map3.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getKey());
        }

        System.out.println(map3.values());

        map3.putAll(new HashMap<>(){{
            put(someClass1,1);
            put(someClass2,2);
            put(someClass3,3);
        }});

    }

}
