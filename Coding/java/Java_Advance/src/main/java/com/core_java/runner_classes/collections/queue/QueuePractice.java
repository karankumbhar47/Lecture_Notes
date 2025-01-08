package com.core_java.runner_classes.collections.queue;

import com.core_java.FactoryPattern.CodeRunnerInterface;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class QueuePractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        /*
        * linked list can act as stack and queue
        * */
        // as stack
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addLast(1); // push
        stack.addLast(2);
        stack.addLast(3);
        stack.addLast(3);

        stack.removeLast(); // pop
        stack.getLast(); // peek
        stack.isEmpty();// empty

        // as queue
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(1); // push (enqueue)
        queue.addLast(2);
        queue.addLast(3);
        queue.addLast(5);

        queue.removeFirst(); // pop (dequeue)
        queue.getFirst();  //  peek

        /*
         But we have a separate class for queue which will remove extra methods which are not needed.
         Queue is an interface, so we need implemented classes to instantiate this
         Class implemented Queue are LinkedList, Priority Queue ...
         */

        Queue<Integer> mainQueue = new ArrayDeque<>();

        methods();
    }

    private void methods(){
        /*
        * work on FIFO principal
        * enqueue --> add (throw exception)
        *             offer (return null if element not added)
        * dequeue --> remove (throws exception if element not exist)
        *             poll (return null if no element removed)
        *  peek   --> peek (throw exception if no element at peek)
        *             element (return null if no element at peek)
        * */

        System.out.println("\nQueue Methods");
        Queue<Integer> queue = new ArrayBlockingQueue<>(2);
        queue.add(1);

        // remove vs poll
        queue.remove();
        System.out.println(queue.poll()); // null
        //System.out.println(queue.remove()); // noElementException

        // peek
        System.out.println(queue.peek()); // null
        //System.out.println(queue.element()); // noSuchElement

        // here wil return null but add will throw exception as we can't add more than
        // 2 elements in the queue
        queue.add(1);
        queue.add(2);
        System.out.println(queue.offer(3)); // false
        System.out.println(queue.add(4)); // exception (queue full)
    }
}
