package johnny.java.common;

public interface IDeque<E> {
    // Deque methods 
    boolean offerFirst(E e);
    boolean offerLast(E e);
    E pollFirst();
    E pollLast();
    E peekFirst();
    E peekLast();
    
    // Queue methods 
    boolean offer(E e);
    E poll();
    E peek();
    
    // Stack methods
    void push(E e);
    E pop();
    
    int size();
    boolean isEmpty();
}
