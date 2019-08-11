package johnny.java.concurrency.withoutinheritable;

public class ParentThread extends Thread {
    public static ThreadLocal<String> tl_p = new ThreadLocal();
    public void run() {
        // setting the new value
        tl_p.set("parent data");

        // returns the ThreadLocal value associated with current thread
        System.out.println("Parent Thread Value: " + tl_p.get());

        ChildThread thread_c = new ChildThread();
        thread_c.start();
    }
}