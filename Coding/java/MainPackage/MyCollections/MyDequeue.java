package MainPackage.MyCollections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class MyDequeue {
    public static void main(String[] args) {
        // only albe to call dequeue methods
        // Deque<Integer> deque = new ArrayDeque<>();
        // deque.addFirst(12);
        // deque.addLast(12);

        // //Array dequeue  
        // ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        // arrayDeque.push(12);
        // System.out.println(arrayDeque);

        // form the queue implementation
        // offer at last(add at last)    
        // arrayDeque.offer(13);
        // System.out.println(arrayDeque);
        // arrayDeque.offerFirst(13);
        // System.out.println(arrayDeque);
        // arrayDeque.addFirst(14);
        // System.out.println(arrayDeque);
        // arrayDeque.addLast(15);
        // System.out.println(arrayDeque);
        // arrayDeque.removeFirst();
        // System.out.println(arrayDeque);
        // arrayDeque.poll();
        // System.out.println(arrayDeque);
        // arrayDeque.pollLast();

        // addFirst, offerFirst
        // addLast, offerLast

        // removeFirst, pollFirst
        // removeLast, pollLast

        // getFirst, peekFirst
        // getLast, peekLast

        // it is preferable that use Stack from 
        // ArrayDeque as Stack operation are sync(as
        // implements vector)

        // Dequeue --> implemented by Queue, LinkedList

        // ArrayDeque used to make Stack and Queue
        // pushed at front
        // ArrayDeque<Integer> stack = new ArrayDeque<>();
        // stack.push(12);
        // System.out.println(stack);
        // stack.push(13);
        // System.out.println(stack);
        // stack.push(14);
        // System.out.println(stack);
        // System.out.println(stack.peek());

        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());


        // We also can create queue using ArrayDequeue
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(10);
        System.out.println(queue);
        queue.offer(11);
        System.out.println(queue);
        queue.offer(12);
        System.out.println(queue);



        System.out.println(queue);
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue);
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue);
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue);



        /*
         * AddFirst   -->                        <-- Offer()
         * push       -->   |  |  |  |  |  |  |  <-- Add() 
         * offerFirst -->                        <-- AddLast()
         */
        
        /* poll          --> 
         * removeFirst   -->                        <-- removeLast()
         * pop           -->   |  |  |  |  |  |  |  
         * pollFirst     -->                        <-- pollLast()
         */
        
    }
}