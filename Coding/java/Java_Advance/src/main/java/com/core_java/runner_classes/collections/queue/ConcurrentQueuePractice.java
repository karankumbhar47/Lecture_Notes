package com.core_java.runner_classes.collections.queue;

import com.core_java.FactoryPattern.CodeRunnerInterface;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueuePractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        concurrentQueueDemo();
        concurrentDequeDemo();
    }

    private void concurrentQueueDemo(){
        /*
         * while adding an element, there is no need to add lock on taking out elements
         * lock free, thread safe (compare and swap technique)
         * */

        ConcurrentLinkedQueue<String> taskQueue = new ConcurrentLinkedQueue<>();
        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("Adding task");
                    taskQueue.add("Adding Task " + System.currentTimeMillis());
                    Thread.sleep(500);
                }catch (Exception ignored){}
            }
        });

        Thread consumer = new Thread(() ->{
            while (true) {
                try {
                    System.out.println("Consuming task " + taskQueue.poll());
                    Thread.sleep(600);
                }
                catch (Exception ignored){}
            }
        });

        producer.start();
        consumer.start();
    }

    private void concurrentDequeDemo(){
        /*
        * concurrent version of deque
        * non blocking , thread safe , double-ended queue (compare and swap)
        * */

        ConcurrentLinkedDeque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.add(1);
        deque.add(0);
        deque.add(2);
        System.out.println(deque);

        int start = deque.getFirst();
        int end = deque.getLast();
        System.out.println(start+" "+end);
    }
}
