package com.core_java.runner_classes.collections.map;

import com.core_java.FactoryPattern.CodeRunnerInterface;
import com.core_java.models.Student;

import java.util.*;

public class TreeMapPractice implements CodeRunnerInterface {

    @Override
    public void runCode() {
        // Map(I) -> SortedMap(I) ->  navigableMap(I) -> TreeMap(Class)
        /*
        sortedMap will sort the map based on key(so class need to comparable or custom
        comparator needed in constructor

        SortedMap is an interface (which have firstKey, lastKey, headMap, tailMap, subMap)

        TreeMap is based on a red-black tree, which means self-balancing tree
        which takes log(n) time to insert element(or sort the whole tree)
        */
        SortedMap<Integer,String> map = new TreeMap<>();
        map.put(11,"karan");
        map.put(-11,"karan1");
        map.put(13,"karan2");
        System.out.println(map);

        //Map<Student, Integer> sortedMap = new TreeMap<>(Comparator.comparing(Student::getName));
        SortedMap<Student, Integer> sortedMap = new TreeMap<>(
                Comparator.comparing(Student::getName));
        sortedMap.put(new Student("karan1", 12, 99), 1);
        sortedMap.put(new Student("karan5", 16, 47), 13);
        sortedMap.put(new Student("karan2", 13, 100), -1);
        sortedMap.put(new Student("karan4", 15, 7), 4);
        sortedMap.put(new Student("karan3", 14, 77), 3);
        sortedMap.forEach((a,b) -> System.out.println(a +" ==> "+b));

        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());

        // from first key to a mentioned key (excluding a mentioned key)
        System.out.println(sortedMap.headMap(new Student("karan4.4",15)));
        System.out.println();

        //from mentioned key to last key (including a given key);
        System.out.println(sortedMap.tailMap(new Student("karan4.4",15)));
        System.out.println();

        //sub map (include first key and exclude last key)
        sortedMap.subMap(new Student("karan2",12),new Student("karan4.5",2))
                .forEach((a,b) -> System.out.println(a+" --> "+b));
        System.out.println();

        sortedMap.subMap(new Student("karan2.3",12),new Student("karan4",2))
                .forEach((a,b) -> System.out.println(a+" --> "+b));

        System.out.println(sortedMap.firstEntry());
        System.out.println(sortedMap.lastEntry());

        System.out.println();
        System.out.println(sortedMap.pollFirstEntry());
        System.out.println(sortedMap.pollLastEntry());
        System.out.println(sortedMap);

        System.out.println();
        sortedMap.replace(new Student("karan3",140, 770),1039);
        System.out.println(sortedMap);

        // complexity of operation are lon(n)
        System.out.println();
        System.out.println(map.get(11));
        System.out.println(map.put(11,"hello"));
        System.out.println(map.containsKey(-11));
        System.out.println(map.containsValue("hello"));

        navigableMap();
    }

    private void navigableMap(){
        System.out.println("\nNavigable map");
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        navigableMap.put(12,"karan");
        navigableMap.put(8,"karan1");
        navigableMap.put(9,"karan0");
        navigableMap.put(13,"karan2");
        System.out.println(navigableMap);

        // extra methods
        System.out.println(navigableMap.lowerKey(10));
        System.out.println(navigableMap.ceilingKey(10));
        System.out.println(navigableMap.higherKey(11));
        System.out.println(navigableMap);
        System.out.println(navigableMap.descendingMap());
        System.out.println(navigableMap.reversed());
        System.out.println(navigableMap.navigableKeySet());
        System.out.println(navigableMap.descendingKeySet());
    }
}
