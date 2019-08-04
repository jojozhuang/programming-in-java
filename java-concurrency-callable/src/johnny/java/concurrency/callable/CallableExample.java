package johnny.java.concurrency.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        // FutureTask is a concrete class that implements both Runnable and Future
        FutureTask[] tasks = new FutureTask[5];

        System.out.println("Creating tasks...");
        for (int i = 0; i < 5; i++) {
            Callable callable = new CallableWorker();

            // Create the FutureTask with Callable
            tasks[i] = new FutureTask(callable);

            // As it implements Runnable, create Thread with FutureTask
            Thread t = new Thread(tasks[i]);
            t.start();
        }

        System.out.println("Waiting results...");
        for (int i = 0; i < 5; i++) {
            // As it implements Future, we can call get()
            System.out.println(tasks[i].get());

            // This method blocks till the result is obtained
            // The get method can throw checked exceptions
            // like when it is interrupted. This is the reason
            // for adding the throws clause to main
        }
    }
}
