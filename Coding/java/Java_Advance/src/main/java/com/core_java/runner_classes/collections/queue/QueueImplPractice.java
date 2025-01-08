package com.core_java.runner_classes.collections.queue;

import com.core_java.FactoryPattern.CodeRunnerInterface;

import java.util.*;
import java.util.concurrent.*;

public class QueueImplPractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        priorityQueue();
        deque();
        blockingQueue();
    }

    private void deque(){
        /*
        *  Insertion and deletion at both end
        *  addFirst /offerFirst
        *  addLast /offerLast
        *  removeFirst/ pollFirst
        *  removeLast/ pollLast
        *
        * Stack method
        * push / pop
        *
        * Array deque has array resizing structure internally. Like it has an array with head and tail pointer.
        * Deque best impl is ArrayDeque (as continuous allocation/ faster iteration/ low memory/ no null allowed)
        * circular array (two pointer) --> no need to shift an element
        * if you want to insert/delete at a middle then use a linked list
        *
        * */

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(1);
        // just shift pointer
        deque.removeFirst();
        // need to shift elements (so use a linked list)
        deque.remove(3);
        System.out.println(deque);

        // insertion and deletion at a middle
        Deque<Integer> deque1 = new LinkedList<>();
        deque1.add(1);
        deque1.add(2);
        deque1.add(3);
        deque1.add(4);
        deque1.add(5);
        deque1.remove(3);
    }

    private void priorityQueue(){
        /*
         * queue with natural ordering, we can pass custom comparator
         * doesn't allow a null element
         *  at head highest priority (no order with internal elements)
         *
         * Time complexity
         * remove, insert -->O(log(n))
         * peek --> O(1)
         * default implementation as min heap
         *  */
        PriorityQueue<Integer> pq = new PriorityQueue<>(4,(a,b) -> b-a);
        pq.add(11);
        pq.add(2);
        pq.add(-20);
        pq.add(7);
        // not print as per the order
        System.out.println(pq);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }

    private void blockingQueue(){
        /*
        * Thread-safe queue (all previous implementations are not thread safe.
        * Wait for space to empty to fill (producer waiting for space to fill).
        * Wait for the queue to be non-empty (consumer will not consume until there is something in the queue).
        * Simply concurrency like producer-consumer
        *
        * Standard queue --> immediately
        *  if queue is empty and if we try to remove -> then it will immediately try to remove an element from the queues
        *  or if queue is full if we try to add some element -> will try to add immediately (no waiting)
        *
        * Blocking queue
        * put --> blocks if the queue is full, until some space will be available,
        * take --> blocks if queue is empty, until some element will be available,
        * offer --> wait for some space to become available, until some specified timeout
        * */

        //bounding queue, backed by a circular array (better communication b/w two threads)
        // low memory head
        // single lock for all operations --> dequeue and enqueue operation
        // so better for fewer number threads
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Thread thread1 = new Thread(new Producer(queue));
        Thread thread2 = new Thread(new Consumer(queue));
        //thread1.start();
        //thread2.start();

        // optionally bounded, backed by linked list (if unbounded out of memory exception)
        // uses two separate locks for the enqueue and dequeue(higher concurrency)
        BlockingQueue<Integer> queue1 = new LinkedBlockingQueue<>();

        // binary heap as an array, and grow dynamically
        // head ordered as per natural ordering (or custom order)
        // no lock on put as it is unbounded
        BlockingQueue<Integer> queue2  = new PriorityBlockingQueue<>();

        // each insert operation must wait for the corresponding remove operation, and vice versa
        // int can store at most 1 element
        BlockingQueue<Integer> queue3 = new SynchronousQueue<>();
        thread1 = new Thread(new Producer(queue3));
        thread2 = new Thread(new Consumer(queue3));
        //thread1.start();
        //thread2.start();

        // delay queue
        BlockingQueue<DummyClass> delayQueue = new DelayQueue<>();
        delayQueue.add(new DummyClass("Task1",7, TimeUnit.SECONDS));
        delayQueue.add(new DummyClass("Task2",10, TimeUnit.SECONDS));
        delayQueue.add(new DummyClass("Task3",3, TimeUnit.SECONDS));
        delayQueue.add(new DummyClass("Task4",1, TimeUnit.SECONDS));
        delayQueue.add(new DummyClass("Task5",5, TimeUnit.SECONDS));

        try {
            while (!delayQueue.isEmpty()) {
                DummyClass dummyClass = delayQueue.take();
                System.out.println(dummyClass.getTaskName());
            }
        } catch (Exception ignored) {}

    }
}

class DummyClass implements Delayed{
    private String taskName;
    private long startTime;

    public DummyClass(String taskName, long delay, TimeUnit unit){
        this.taskName = taskName;
        startTime = System.currentTimeMillis() + unit.toMillis(delay);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long remainingTime = startTime - System.currentTimeMillis();
        return unit.convert(remainingTime,TimeUnit.MICROSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        long diff = this.getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS);
        if(diff<0) return -1;
        if(diff==0) return 0;
        return 1;
    }

    public String getTaskName() {
        return taskName;
    }
}

class Producer implements Runnable{
    private final BlockingQueue<Integer> queue;
    private int value;

    public Producer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true){
            try{
                System.out.println("Producer wating to put ...");
                queue.put(value++);
                Thread.sleep(500);
            }catch (Exception e){
                Thread.currentThread().interrupt();
                System.out.println("producer interrupt "+e.getMessage());
            }
        }
    }
}

class Consumer implements Runnable{
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true){
            try{
                System.out.println("Consumer waiting...");
                Integer value = queue.take();
                System.out.println("Consumer Consumed : "+value);
                Thread.sleep(3000);
            }catch (Exception e){
                Thread.currentThread().interrupt();
                System.out.println("consumer interrupt "+e.getMessage());
            }
        }
    }
}
