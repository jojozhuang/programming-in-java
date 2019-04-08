package johnny.java.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueExample {
    public static void main(String[] args) {

        constructList();

        insert();
        delete();
        examine();
    }

    private static void constructList() {
        Queue<String> queue = new LinkedList<>();
        queue.add("one");
        queue.add("two");
        queue.add("three");
        queue.add("four");
        System.out.println(queue);

        queue.remove("three");
        System.out.println(queue);
        System.out.println("Queue Size: " + queue.size());
        System.out.println("Queue Contains element 'two' or not? : " + queue.contains("two"));

        // To empty the queue
        queue.clear();

        //Array to Queue
        String[] nums = {"one","two","three","four","five"};
        Queue<String> queue2 = new LinkedList<>();
        Collections.addAll(queue2, nums);
        System.out.println(queue2);

        // Queue to Array
        String strArray[] = queue2.toArray(new String[queue2.size()]);
        System.out.println(Arrays.toString(strArray));
    }

    // insert
    private static void insert() {
        System.out.println("Queue - insert");
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

    // delete
    private static void delete() {
        System.out.println("Queue - delete");
        // remove
        Queue<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.offer("two");
        System.out.println(queue);           // [one, two]
        System.out.println(queue.remove());  // one
        System.out.println(queue.remove());  // two
        //System.out.println(queue.remove()); // java.util.NoSuchElementException

        // poll
        Queue<String> queue2 = new LinkedList<>();
        queue2.offer("one");
        queue2.offer("two");
        System.out.println(queue2);         // [one, two]
        System.out.println(queue2.poll());  // one
        System.out.println(queue2.poll());  // two
        System.out.println(queue2.poll());  // return null
    }

    // examine
    private static void examine() {
        System.out.println("Queue - examine");
        // element
        Queue<String> queue = new LinkedList<>();
        queue.add("one");

        System.out.println(queue.element());  // one
        System.out.println(queue);            // [one]
        queue.clear();
        //System.out.println(queue.element()); // java.util.NoSuchElementException

        // peek
        Queue<String> queue2 = new LinkedList<>();
        queue2.add("one");

        System.out.println(queue2.peek());  // one
        System.out.println(queue2);         // [one]
        queue2.clear();
        System.out.println(queue2.peek());  // return null
    }
}
