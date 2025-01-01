package com.coreJava.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.coreJava.FactoryPattern.CodeRunnerInterface;

public class NonThreadSafeDemo implements CodeRunnerInterface {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();

        // Create two threads to add elements to the list
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                list.add(i);
                System.out.println("Thread 1 - " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 100; i < 200; i++) {
                list.add(i);
                System.out.println("Thread 2 - " + i);
            }
        });

        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // The size of the list should be 2000, but due to race conditions, it may be
        // less
        System.out.println("List size: " + list.size());

        // deadlock
        // Thread[] threads = new Thread[2];

        // threads[0] = new Thread(() -> {
        // System.out.println("Thread 1 started.");
        // try {
        // threads[1].join(); // Wait for thread t4
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // System.out.println("Thread 1 finished.");
        // });

        // threads[1] = new Thread(() -> {
        // System.out.println("Thread 2 started.");
        // try {
        // threads[0].join(); // Wait for thread t3
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // System.out.println("Thread 2 finished.");
        // });

        // threads[0].start();
        // threads[1].start();

        // List<Integer> list1 = Collections.synchronizedList(new ArrayList<>());

        // Thread t3 = new Thread(() -> {
        //     for (int i = 0; i < 1000; i++) {
        //         list1.add(i);
        //     }
        // });

        // Thread t4 = new Thread(() -> {
        //     for (int i = 1000; i < 2000; i++) {
        //         list1.add(i);
        //     }
        // });

        // t3.start();
        // t4.start();

        // t3.join();
        // t4.join();

        // System.out.println("List size: " + list1.size()); // Output will always be 2000


        List<Integer> list2 = new CopyOnWriteArrayList<Integer>();

        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list2.add(i);
            }
        });

        Thread t6 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                list2.add(i);
            }
        });

        t5.start();
        t6.start();

        t5.join();
        t6.join();

        System.out.println("List size: " + list2.size()); // Output will always be 2000
    }

    @Override
    public void runCode() {
        try {
            NonThreadSafeDemo.main(null);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
