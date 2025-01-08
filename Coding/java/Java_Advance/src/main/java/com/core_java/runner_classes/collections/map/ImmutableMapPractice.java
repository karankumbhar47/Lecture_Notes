package com.core_java.runner_classes.collections.map;

import com.core_java.FactoryPattern.CodeRunnerInterface;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImmutableMapPractice implements CodeRunnerInterface {

    @Override
    public void runCode() {
        /*
        * the list of a map which is created by the of method is immutable we cant add or remove or
        * replace the element from the map.
        * */

        /* ==> case 1 <==
         * needs to create two instances which is not a good
         */
        //mutable map --> map1
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(1,"nothing");
        map1.put(2,"some random value");
        map1.put(3,"random things");
        System.out.println(map1);

        // immutable map --> map2
        Map<Integer,String> map2 = Collections.unmodifiableMap(map1);
        System.out.println(map2);
        // throws an exception unSupportedOperation
        //map2.put(1,"some changes");

        /* ==> case 2 <== */

        // immutable list (java 9 introduce)
        List<Integer> list = List.of(1,1,2,3,3,4,2,3,4,1);
        System.out.println(list);

        // immutable map
        // only 10 members are possible
        Map<Integer, String> map = Map.of(1, "Karan", 2, "Sunil", 3, "Kumar", 4, "some Value",
                5, "five", 6, "six", 7, "seven", 8, "eight", 9, "nine", 10, "ten");
        System.out.println(map);

        // to add more entries, we use the following method
        Map<Integer,Integer> greaterMap = Map.ofEntries(Map.entry(1,1),Map.entry(2,2),Map.entry(3,3)
                ,Map.entry(4,4),Map.entry(5,4),Map.entry(6,4),Map.entry(8,4),Map.entry(9,4)
                ,Map.entry(10,4),Map.entry(11,4),Map.entry(12,4),Map.entry(13,4),Map.entry(14,4));
        System.out.println(greaterMap);


    }
}
