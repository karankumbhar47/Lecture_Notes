package com.coreJava.RunnerClasses.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.LinkedList;
import java.util.List;

import com.coreJava.FactoryPattern.CodeRunnerInterface;

public class LinkedListPractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(2, 3, 4, 5, 6, 7);
        list.add(1);
        list.addAll(list1);
        list.addFirst(0);
        list.addLast(8);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list);
        System.out.println(list1);
        System.out.println(list.containsAll(list1));
        System.out.println(list.indexOf(7));
        System.out.println(list.contains(8));
        list.removeLast();
        list.removeFirst();
        list.removeAll(list1);
        list.isEmpty();
        System.out.println(list);

        // linked list (as a list,queue,stack (powerful))
        LinkedList<Integer> linkList = new LinkedList<>();
        linkList.add(1);
        linkList.add(2);
        linkList.add(3);
        linkList.add(4);
        System.out.println(linkList.get(2));
        linkList.addFirst(0);
        linkList.addLast(5);
        linkList.removeIf(x -> x % 2 == 0);
        linkList.removeAll(linkList);


    }
}