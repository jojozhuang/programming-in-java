package johnny.java.concurrency.withoutinheritable;

public class InheritanceExample {
    public static void main(String[] args) {
        ParentThread thread_p = new ParentThread();
        thread_p.start();
    }
}
