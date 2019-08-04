package johnny.java.concurrency.threadpool;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class FixedTask implements Runnable {
    private String name;

    public FixedTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Executing: " + name + " at " + LocalDateTime.now().toString());
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}