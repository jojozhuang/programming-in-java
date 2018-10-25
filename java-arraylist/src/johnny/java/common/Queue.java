package johnny.java.common;

public interface Queue<E> {
    boolean offer(E e);
    E poll();
    E peek();
    int size();
}
