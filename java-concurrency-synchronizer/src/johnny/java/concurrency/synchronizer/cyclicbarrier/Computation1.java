package johnny.java.concurrency.synchronizer.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Computation1 implements Runnable {
    public static int product = 0;
    private final CyclicBarrier cyclicBarrier;

    public Computation1(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        product = 2 * 3;
        try {
            Thread.sleep(1000);
            // number of parties waiting at the barrier
            System.out.println("Number of parties waiting at the barrier "+
                    "at this point = " + cyclicBarrier.getNumberWaiting());
            cyclicBarrier.await();
        }
        catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}