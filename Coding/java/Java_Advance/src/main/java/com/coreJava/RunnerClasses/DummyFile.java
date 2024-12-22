package com.coreJava.RunnerClasses;

public class DummyFile {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {

            public void run() {
                System.out.println("Child Thread");
            }
        });

        t.start();

        System.out.println("Main Thread");
    }
}
