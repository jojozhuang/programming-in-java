package johnny.java.concurrency.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

        ScheduledTask task = new ScheduledTask("Scheduled Task");

        ses.scheduleAtFixedRate(task, 0, 3, TimeUnit.SECONDS);
    }
}
