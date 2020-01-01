package johnny.java.concurrency.synchronizer.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Worker extends Thread {
    private int delay;
    private CountDownLatch latch;

    public Worker(String name, int delay, CountDownLatch latch) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            latch.countDown();

            System.out.println(Thread.currentThread().getName() +
                    " finished, remaining count = " + latch.getCount());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
