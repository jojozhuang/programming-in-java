package johnny.java.concurrency.thread.test;

import johnny.java.concurrency.thread.MyRunnable;
import johnny.java.concurrency.thread.MyThread;
import org.junit.Test;

public class ThreadTest {

    @Test
    public void test() {
        // Thread class
        MyThread myThread = new MyThread();
        myThread.start();

        // Runnable interface
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
