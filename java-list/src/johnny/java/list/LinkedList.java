package johnny.java.list;

import johnny.java.common.IQueue;
import johnny.java.common.IStack;
import johnny.java.common.IDeque;
import johnny.java.common.ListNode;

public class LinkedList<E> implements IStack<E>, IQueue<E>, IDeque<E> {
    private int size = 0;
    
    private ListNode<E> head; // the first node
    private ListNode<E> tail; // the last node

    public LinkedList() {
        head = null;
        tail = null;
    }

    // Add item to the head of the list
    public boolean offerFirst(E item) {
        if (head == null) {
            head = new ListNode(item);
            tail = head;
        } else {
            head.previous = new ListNode(item);
            head.previous.next = head;
            head = head.previous;
        }
        size++;
        return true;
    }

    // Remove the head from the list and return its value
    public E pollFirst() {
        if (head == null) {
            return null;
        }
        E item = head.item;
        head = head.next;
        if (head != null) {
            head.previous = null;
        } else {
            tail = null;
        }
        size--;
        return item;
    }

    // Get the value of the head
    public E peekFirst() {
        if (head == null) {
            return null;
        }
        return head.item;
    }

    // Add item to the tail of the list
    public boolean offerLast(E item) {
        if (tail == null) {
            tail = new ListNode(item);
            head = tail;
        } else {
            tail.next = new ListNode(item);
            tail.next.previous = tail;
            tail = tail.next;
        }
        size++;
        return true;
    }

    // Remove the tail from the list and return its value
    public E pollLast() {
        if (tail == null) {
            return null;
        }
        E item = tail.item;
        tail = tail.previous;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return item;
    }

    // Get the value of the tail
    public E peekLast() {
        if (tail == null) {
            return null;
        }
        return tail.item;
    }

    // Return whether the deque is empty
    public boolean isEmpty() {
        return head == null || tail == null;
    }
    
    // Queue methods 
    public boolean offer(E e) {
        return offerLast(e);
    }
    public E poll() {
        return pollFirst();
    }
    public E peek() {
        return peekFirst();
    }
    
    // Stack methods
    public void push(E e) {
        offerLast(e);
    }
    public E pop() {
        return pollLast();
    }
    
    public int size() {
        return size;
    }
}
