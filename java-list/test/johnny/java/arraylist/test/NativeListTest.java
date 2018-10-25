package johnny.java.arraylist.test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class NativeListTest {
    
    @Test
    public void testStack() {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        assertEquals(true, stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(false, stack.isEmpty());
        assertEquals(3, (int)stack.pop());
        assertEquals(2, (int)stack.pop());
        assertEquals(false, stack.isEmpty());
        assertEquals(1, (int)stack.peek());
        assertEquals(1, (int)stack.peek());
        assertEquals(false, stack.isEmpty());
        stack.push(4);
        assertEquals(4, (int)stack.pop());
        assertEquals(false, stack.isEmpty());
        assertEquals(1, (int)stack.pop());
        assertEquals(true, stack.isEmpty());
    }
    
    @Test
    public void testQueue() {
        Queue<Integer> queue = new LinkedList<Integer>();
        assertEquals(true, queue.isEmpty());
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        
        assertEquals(false, queue.isEmpty());
        assertEquals(1, (int)queue.poll());
        assertEquals(2, (int)queue.poll());
        assertEquals(false, queue.isEmpty());
        assertEquals(3, (int)queue.peek());
        assertEquals(3, (int)queue.peek());
        assertEquals(false, queue.isEmpty());
        queue.offer(4);
        assertEquals(3, (int)queue.poll());
        assertEquals(false, queue.isEmpty());
        assertEquals(4, (int)queue.poll());
        assertEquals(true, queue.isEmpty());
    }
    
    @Test
    public void testDeque() {
        Deque<Integer> deque = new LinkedList<Integer>();
        assertEquals(true, deque.isEmpty());
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        
        assertEquals(false, deque.isEmpty());
        assertEquals(1, (int)deque.pollFirst());
        assertEquals(3, (int)deque.pollLast());
        assertEquals(false, deque.isEmpty());
        assertEquals(2, (int)deque.peekFirst());
        assertEquals(2, (int)deque.peekLast());
        assertEquals(false, deque.isEmpty());
        deque.offerFirst(4);
        assertEquals(4, (int)deque.peekFirst());
        assertEquals(2, (int)deque.peekLast());
        assertEquals(2,(int) deque.pollLast());
        assertEquals(false, deque.isEmpty());
        assertEquals(4, (int)deque.pollLast());
        assertEquals(true, deque.isEmpty());
    }
}
