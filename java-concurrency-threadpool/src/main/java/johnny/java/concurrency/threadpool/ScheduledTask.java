package johnny.java.concurrency.threadpool;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class ScheduledTask implements Runnable {
    private String name;

    public ScheduledTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        System.out.println("Executing: " + name + " at " + LocalDateTime.now().toString());
    }
}