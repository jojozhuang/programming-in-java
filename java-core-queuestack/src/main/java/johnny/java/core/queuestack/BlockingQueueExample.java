package johnny.java.core.queuestack;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        System.out.println("Test BlockingQueue");
        // add
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
        System.out.println(queue.add("one"));   // true
        System.out.println(queue.add("two"));   // true
        System.out.println(queue);              // [one, two]
        //System.out.println(queue.add("three")); // java.lang.IllegalStateException: Queue full
        System.out.println(queue);

        // offer
        BlockingQueue<String> queue2 = new ArrayBlockingQueue<>(2);
        System.out.println(queue2.offer("one"));   // true
        System.out.println(queue2.offer("two"));   // true
        System.out.println(queue2);                   // [one, two]
        System.out.println(queue2.offer("three")); // false
        System.out.println(queue2);                   // [one, two]
    }
}
