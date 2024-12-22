package MainPackage.MyCollections;

import java.util.PriorityQueue;
import java.util.Queue;

public class MyPriorityQueue {
    public static void main(String[] args) {
        // by default min heap is implemented
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(10);
        pq.offer(15);
        pq.offer(12);
        pq.offer(13);
    }
}
