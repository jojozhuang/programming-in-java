package johnny.java.concurrency.synchronizer.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String args[]) throws InterruptedException {
        // Create task that is going to wait for four threads before it starts
        CountDownLatch latch = new CountDownLatch(4);

        // Create four worker threads and start them
        Worker first = new Worker("Worker1", 1000, latch);
        Worker second = new Worker("Worker2", 2000, latch);
        Worker third = new Worker("Worker3", 3000, latch);
        Worker fourth = new Worker("Worker4", 4000, latch);
        first.start();
        second.start();
        third.start();
        fourth.start();

        // The main task waits for four threads
        latch.await();

        // Main thread has started
        System.out.println(Thread.currentThread().getName() + " has finished");
    }
}
