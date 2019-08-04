package johnny.java.concurrency.synchronizer.semaphore;

import java.util.concurrent.Semaphore;

public class Worker extends Thread {
    private String name;
    private Semaphore semaphore;
    public Worker(String name, Semaphore semaphore) {
        super(name);
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name + "...");
        try {
            System.out.println(name + ": acquiring a permit, available Semaphore permits: "
                    + semaphore.availablePermits());

            // Acquiring the permit
            semaphore.acquire();

            System.out.println(name + " gets a permit.");

            for (int i=0; i < 3; i++) {
                System.out.println(name + ": is performing operation " + (i + 1)
                        + ", available Semaphore permits: "
                        + semaphore.availablePermits());
                Thread.sleep( (long) (Math.random() * 2000));
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        // Release the permit
        semaphore.release();
        System.out.println(name + " releases the permit, available Semaphore permits: "
                + semaphore.availablePermits());
    }
}