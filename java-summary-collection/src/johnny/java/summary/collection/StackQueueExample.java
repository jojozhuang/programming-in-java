package johnny.java.summary.collection;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class StackQueueExample {
    public static void main(String[] args) {
        // Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.pop(); // 2

        // Queue
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.poll(); // 1

        // Deque
        Deque<Integer> deque = new LinkedList<>();
        //Deque<String> deque = new ArrayDeque<>();
        deque.add(1);        // [1]
        deque.addFirst(2);   // [2, 1]
        deque.addLast(3);    // [2, 1, 3]
        deque.peekFirst();   // 2
        deque.peekLast();    // 3
        deque.remove();      // [1, 3]
        deque.removeFirst(); // [3]
        deque.removeLast();  // []

        // Blocking queue
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(2); // capacity
        bq.add("one");
        bq.add("two");
        bq.add("three"); // java.lang.IllegalStateException: Queue full

        BlockingQueue<String> bq2 = new ArrayBlockingQueue<>(2); // capacity
        bq2.offer("one");
        bq2.offer("two");
        bq2.offer("three"); // return false, no exception
    }

    public static void testDeque() {
        // Stack
        Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        Deque<Integer> stack3 = new LinkedList<>();
        // Queue
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> queue2 = new LinkedList<>();
        // Deque
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> deque2 = new LinkedList<>();
    }
}
