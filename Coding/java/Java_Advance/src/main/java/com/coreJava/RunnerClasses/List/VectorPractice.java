package com.coreJava.RunnerClasses.List;

import com.coreJava.FactoryPattern.CodeRunnerInterface;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class VectorPractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        VectorPractice.main(null);
    }

    public static void main(String[] args) {
        // vector(synchronize)
        // arraylist and linked list are not synchronized
        // thread safe(lock and unlock) with cost of performance
        // single thread --> arraylist
        // legacy method (previous method)
        // can be parametrized with capacity and increase factor(default 2)

        System.out.println("Vector " + "=".repeat(50));
        Vector<Integer> vec = new Vector<>();
        vec.add(1);
        vec.add(2);
        // add at end
        vec.add(3);
        // return some boolean value
        // add at specified index
        vec.add(0, 4);
        vec.addAll(Arrays.asList(1, 2, 3, 4));
        vec = new Vector<>(Arrays.asList(1, 2, 3, 3, 3, 3));
        vec = new Vector<>(List.of(1,2,2,3,3,3));

        // capacity and #incremented number
        vec = new Vector<>(10,10);
        System.out.println(vec.capacity());
        vec.addAll(List.of(1,1,2,2,2,2,2,2,2,2));
        System.out.println(vec.capacity());
        vec.add(10);
        System.out.println(vec.capacity());


        // not return anything
        vec.addElement(2); // always add element at the end
        System.out.println(vec);


        Vector<Integer> newVec = new Vector<>(2000);
        LinkedList<Integer> newLinkList = new LinkedList<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    newVec.add(i);
                    newLinkList.add(i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1000; i < 2000; i++) {
                    newVec.add(i);
                    newLinkList.add(i);
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(newVec.size());
        System.out.println(newLinkList.size());
    }
}
