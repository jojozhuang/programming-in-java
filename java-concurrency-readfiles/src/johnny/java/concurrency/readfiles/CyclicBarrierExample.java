package johnny.java.concurrency.readfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(6);
        System.out.println("Number of parties required to trip the barrier = " +
                barrier.getParties());

        // create tasks
        List<CyclicBarrierTask> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CyclicBarrierTask task = new CyclicBarrierTask("test" + (i + 1) + ".txt", barrier);
            Thread t = new Thread(task);
            t.start();
            tasks.add(task);
        }

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

        // collect results
        String content = "";
        for (int i = 0; i< 5; i++) {
            content += tasks.get(i).getContent() + System.lineSeparator();
        }

        System.out.println("Result:");
        System.out.println(content);
    }
}
