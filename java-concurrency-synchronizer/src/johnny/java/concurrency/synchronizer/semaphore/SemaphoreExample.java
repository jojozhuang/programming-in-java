package johnny.java.concurrency.synchronizer.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String args[]) throws InterruptedException
    {
        // Create a Semaphore object with number of permits 2
        Semaphore semaphore = new Semaphore(2);

        // Create 4 worker threads
        Worker worker1 = new Worker("Work1", semaphore);
        Worker worker2 = new Worker("Work2", semaphore);
        Worker worker3 = new Worker("Work3", semaphore);
        Worker worker4 = new Worker("Work4", semaphore);
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        // Wait until all workers are completed
        worker1.join();
        worker2.join();
        worker3.join();
        worker4.join();

        // Check the final permits
        System.out.println("All tasks are completed. Available Semaphore permits: "
                + semaphore.availablePermits());
    }
}
