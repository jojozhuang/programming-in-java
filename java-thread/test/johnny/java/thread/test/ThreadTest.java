package johnny.java.thread.test;

import johnny.java.thread.MyRunnable;
import johnny.java.thread.MyThread;
import org.junit.Test;

import org.junit.Assert;

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
