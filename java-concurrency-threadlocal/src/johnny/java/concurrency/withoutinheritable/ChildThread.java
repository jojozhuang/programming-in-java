package johnny.java.concurrency.withoutinheritable;

public class ChildThread extends Thread {
    public void run(){
        // returns  the ThreadLocal value associated with current thread
        System.out.println("Child Thread Value: " + ParentThread.tl_p.get());
        /* null (parent thread variable
        thread local value is not available to child thread ) */
    }
}
