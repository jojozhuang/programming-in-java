package johnny.java.concurrency.readfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String args[]) throws InterruptedException {
        // Create task that is going to wait for five threads before it starts
        CountDownLatch latch = new CountDownLatch(5);

        // create tasks
        List<CountDownLatchTask> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CountDownLatchTask task = new CountDownLatchTask("test" + (i + 1) + ".txt", latch);
            Thread t = new Thread(task);
            t.start();
            tasks.add(task);
        }

        // The main task waits for four threads
        latch.await();

        // collect results
        String content = "";
        for (int i = 0; i< 5; i++) {
            content += tasks.get(i).getContent() + System.lineSeparator();
        }

        System.out.println("Result:");
        System.out.println(content);
    }
}
