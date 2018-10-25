package johnny.java.common;

public class ListNode<E> {
    public E item;
    public ListNode<E> previous;
    public ListNode<E> next;
    public ListNode(E item) {
        this.item = item;
        this.previous = null;
        this.next = null;
    }
}
