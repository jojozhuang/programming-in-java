package johnny.java.concurrency.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixedThreadPoolExample {
    public static void main(String[] args)
    {
        //ExecutorService executor = Executors.newFixedThreadPool(2);
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++)
        {
            FixedTask task = new FixedTask("Task " + i);
            System.out.println("Created: " + task.getName());

            executor.execute(task);
        }
        executor.shutdown();
    }
}
