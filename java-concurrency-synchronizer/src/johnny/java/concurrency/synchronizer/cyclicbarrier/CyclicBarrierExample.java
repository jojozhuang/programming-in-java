package johnny.java.concurrency.synchronizer.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
    Calculate result of (2*3) + (10*20) = 206
 */
public class CyclicBarrierExample {
    public static void main(String[] args) {
        final CyclicBarrier barrier = new CyclicBarrier(3);
        System.out.println("Number of parties required to trip the barrier = " +
                barrier.getParties());
        System.out.println("Product of Computation1 = " + Computation1.product);
        System.out.println("Product of Computation2 = " + Computation2.product);

        Thread t1 = new Thread(new Computation1(barrier));
        Thread t2 = new Thread(new Computation2(barrier));
        t1.start();
        t2.start();

        try {
            barrier.await();
        }
        catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        // number of parties waiting at the barrier
        System.out.println("Number of parties waiting at the barrier "+
                "at this point = " + barrier.getNumberWaiting());
        // barrier breaks as the number of thread waiting for the barrier at this point = 0
        System.out.println("Product of Computation1 = " + Computation1.product);
        System.out.println("Product of Computation2 = " + Computation2.product);

        System.out.println("Final result = " + (Computation1.product + Computation2.product));

        // Resetting the newBarrier
        barrier.reset();
        System.out.println("Barrier reset successful");
    }
}
