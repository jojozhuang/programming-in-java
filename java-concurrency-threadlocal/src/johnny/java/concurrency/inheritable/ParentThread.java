package johnny.java.concurrency.inheritable;

public class ParentThread extends Thread {
    public static InheritableThreadLocal itl_p = new InheritableThreadLocal() {
        @Override
        public Object childValue(Object parentValue) {
            return "child data";
        }
    };

    public void run() {
        // setting the new value
        itl_p.set("parent data");

        // returns the ThreadLocal value associated with current thread
        System.out.println("Parent Thread Value: " + itl_p.get());

        ChildThread thread_c = new ChildThread();
        thread_c.start();
    }
}