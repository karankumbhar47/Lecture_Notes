package com.core_java.runner_classes.collections;

import com.core_java.FactoryPattern.CodeRunnerInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Function;

public class IteratorPractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        /*
        * for each loop conversion to iterator after compilation
        * methods inside Iterator
        * */

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        for(int i: list) System.out.println(i);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int a = iterator.next();
            System.out.println(a);
            if(a==5) iterator.remove();
        }
        System.out.println(list);

        ListIterator<Integer> integerListIterator = list.listIterator();
        while (integerListIterator.hasNext()){
            int i = integerListIterator.next();
            System.out.println("1 " + i);
            if(i==4) integerListIterator.set(14);
        }

        System.out.println(list);

        while (integerListIterator.hasPrevious()){
            int i = integerListIterator.previous();
            System.out.println("2 " + i);
            if(i==14) integerListIterator.set(4);
        }

        System.out.println(list);
    }
}
