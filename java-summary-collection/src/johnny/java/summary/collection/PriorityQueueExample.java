package johnny.java.summary.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        testMinHeap();
        testMaxHeap();
        testOrder();
    }

    public static void testMinHeap() {
        Queue<String> pq = new PriorityQueue<>(); // min heap
        pq.offer("a");
        pq.offer("b");
        pq.offer("c");
        pq.peek();     // a
        pq.remove();   // return a, pq = [b, c]
        pq.peek();     // b
        pq.offer("d"); // [b, c, d]
        pq.offer("z"); // [b, c, d, z]

        pq.poll();     // b
        pq.poll();     // c
        pq.poll();     // d
        pq.poll();     // z
        // pq.remove(); NoSuchElementException
        pq.poll();     // null
    }

    public static void testMaxHeap() {
        Queue<String> pq = new PriorityQueue<>(Comparator.reverseOrder()); // max heap
        pq.offer("a");
        pq.offer("b");
        pq.offer("c");
        pq.peek();     // c
        pq.remove();   // return c, pq = [b, a]
        pq.peek();     // b
        pq.offer("d"); // [d, b, a]
        pq.offer("z"); // [z, d, b, a]

        pq.poll();     // z
        pq.poll();     // d
        pq.poll();     // b
        pq.poll();     // a
        // pq.remove(); NoSuchElementException
        pq.poll();     // null
    }

    public static void testOrder() {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        //PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);

        System.out.println(pq);        // [3, 1, 2]

        Iterator<Integer> iterator = pq.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(pq.poll()); // 3
        System.out.println(pq.poll()); // 2
        System.out.println(pq.poll()); // 1
    }
}
