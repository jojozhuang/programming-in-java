package johnny.java.concurrency.callable;

import java.util.Random;

public class RunnableWorker implements Runnable {
    // Shared object to store result
    private Object result = null;

    public void run() {
        Random random = new Random();
        Integer randomNumber = random.nextInt(5);

        // As run cannot throw any Exception
        try {
            Thread.sleep(randomNumber * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Store the return value in result when done
        result = randomNumber;

        // Wake up threads blocked on the get() method
        synchronized(this) {
            notifyAll();
        }
    }

    public synchronized Object get() throws InterruptedException {
        while (result == null) {
            wait();
        }
        return result;
    }
}
