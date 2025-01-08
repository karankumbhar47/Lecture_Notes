package com.core_java.runner_classes.collections.map;

import com.core_java.FactoryPattern.CodeRunnerInterface;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapPractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        /*
        * If all keys are from the same enum, then we can use EnumMap
        * one advantage of this that map will know all keys in advance
        *
        * Faster and memory efficient than a hashmap.
        * Array with the same size of enum(with no hashing)
        * */

        Map<Day,String> dayStringMap = new EnumMap<>(Day.class);
        dayStringMap.put(Day.FRIDAY,"Sleep");
        dayStringMap.put(Day.MONDAY,"morning");

        // order the same as enum declaration
        System.out.println(dayStringMap);

        //the following value is used of hashing (ordinal is used for index of map)
        System.out.println(Day.FRIDAY.ordinal());
    }
}

enum Day{
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
}
