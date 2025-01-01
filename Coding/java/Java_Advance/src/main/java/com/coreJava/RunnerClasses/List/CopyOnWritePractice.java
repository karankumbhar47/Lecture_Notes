package com.coreJava.RunnerClasses.List;

import com.coreJava.FactoryPattern.CodeRunnerInterface;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.Thread.sleep;

public class CopyOnWritePractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
       CopyOnWritePractice.main(null);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(1,2,2,1,1,1,2,1));
        CopyOnWriteArrayList<Integer> syncArr = new CopyOnWriteArrayList<Integer>(arr);
        /*
         here on each write operation(add,remove) new list will be created,
         and reference will be changed to a new list, another thread reading
         an existing list that is not modified
         (read operation -> fast, direct)
         user only when operation is read intensive
        */

        // throw a concurrent modification exception
        try {
            for (Integer a : arr) {
                if (a == 2) arr.add(3);
                System.out.println(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        for(Integer a: syncArr){
            // these values will be added in a new list
            if (a == 2) syncArr.add(3);
            // these values will be read from
            // an old list
            System.out.println(a);
        }

        // new-list (reference only
        // modified after read operation completed)
        System.out.println(syncArr);

        // Thread env
        Thread t1 = new Thread(() -> {
            try {
                while (true) {
                    for (int a : syncArr) {
                        System.out.println("thread 1 : " + a);
                    }
                    Thread.sleep(100);
                    System.out.println("break");
                }
            } catch (Exception e) {
                System.out.println("error while reading in thread 1 - " + e.getMessage());
            }

        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(500);
                syncArr.add(1,66);
                System.out.println("thread 2 : added 3");
                Thread.sleep(400);
                syncArr.add(4,44);
                System.out.println("thread 2 : added 4");
            } catch (Exception e) {
                System.out.println("error while reading in thread 1 - " + e.getMessage());
            }

        });

        t1.start();
        t2.start();
    }
}
