package johnny.java.core.queuestack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        //Deque<Integer> deque = new ArrayDeque<>();

        // add
        deque.add(1); // add last
        deque.add(2);
        deque.add(3);
        deque.add(4);
        System.out.println(deque); // [1, 2, 3, 4]

        deque.addLast(5);
        System.out.println(deque); // [1, 2, 3, 4, 5]
        deque.addFirst(6);
        System.out.println(deque); // [6, 1, 2, 3, 4, 5]

        // peek
        System.out.println(deque.peekFirst()); // 6
        System.out.println(deque.peekLast());  // 5

        // remove
        deque.remove(); // remove first
        System.out.println(deque); // [1, 2, 3, 4, 5]
        deque.removeFirst();
        System.out.println(deque); // [2, 3, 4, 5]
        deque.removeLast();
        System.out.println(deque); // [2, 3, 4]
    }
}
