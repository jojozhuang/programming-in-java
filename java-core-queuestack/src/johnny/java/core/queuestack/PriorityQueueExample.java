package johnny.java.core.queuestack;

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

    public static void testMinHeap(){
        System.out.println("Testing min heap:");
        // create a min heap
        Queue<String> pq = new PriorityQueue<>();
        pq.add("a");
        pq.add("b");
        pq.add("c");
        System.out.println("size:" + pq.size()); // 3
        System.out.println(pq.peek());           // a
        System.out.println(pq.remove());         // a
        System.out.println(pq.peek());           // b

        System.out.println(pq);                  // [b, c]

        pq.offer("d");
        pq.offer("z");
        System.out.println("size:" + pq.size());   // 4
        System.out.println(pq);                    // [b, c, d, z]

        System.out.println(pq.poll());   // b
        System.out.println(pq.poll());   // c
        System.out.println(pq.poll());   // d
        System.out.println(pq.poll());   // g
        //System.out.println(pq.remove()); // NoSuchElementException
        System.out.println(pq.poll());   // null
    }

    public static void testMaxHeap(){
        System.out.println("Testing max heap:");
        // create a max heap
        Queue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add("a");
        pq.add("b");
        pq.add("c");
        System.out.println("size:" + pq.size()); // 3
        System.out.println(pq.peek());           // c
        System.out.println(pq.remove());         // c
        System.out.println(pq.peek());           // b

        System.out.println(pq);                  // [b, a]

        pq.offer("d");
        pq.offer("z");
        System.out.println("size:" + pq.size());   // 4
        System.out.println(pq);                    // [z, d, b, a]

        System.out.println(pq.poll());   // z
        System.out.println(pq.poll());   // d
        System.out.println(pq.poll());   // b
        System.out.println(pq.poll());   // a
        //System.out.println(pq.remove()); // NoSuchElementException
        System.out.println(pq.poll());   // null
    }

    public static void testOrder() {
        System.out.println("Testing order of heap:");
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
