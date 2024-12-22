package MainPackage.MyCollections;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;


public class MyQueue {
    public static void main(String[] args) {

        // java queue interface method
        // not thorows exception 
        // offer
        // poll
        // peek
        // throws exception if not handled correctly
        // add
        // remove 
        // element

        Queue<Integer> queue = new LinkedList<>(); 
        // here you are not able to call linked list as 
        // you are creating object of type Queue 
        // so only able to call methods from Queue
        // queue.linkFirst(2);
        queue.add(12);
        queue.offer(13);
        queue.add(14);
        queue.offer(15);
        queue.offer(16);
        queue.add(17);
        queue.offer(18);

        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.element());
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue.parallelStream().count());

        while (!queue.isEmpty()) {
            System.out.println(queue.poll()); 
        }
        System.out.println(queue.poll());
        System.out.println(queue.remove());

    }
}
