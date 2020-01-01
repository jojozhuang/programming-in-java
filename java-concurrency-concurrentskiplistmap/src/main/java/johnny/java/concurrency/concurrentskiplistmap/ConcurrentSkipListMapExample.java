package johnny.java.concurrency.concurrentskiplistmap;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentSkipListMapExample {
    public static void main(String[] args) throws Exception {
        // Create thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        SortedEventWindow sew = new SortedEventWindow();

        executorService.execute(new Task("task1", true, sew));
        executorService.execute(new Task("task2", false, sew));

        Thread.sleep(500);

        // get all events
        System.out.println("All events:");
        Set<Map.Entry<ZonedDateTime, String>> eventSet = sew.getAll().entrySet();
        eventSet.forEach((m)->System.out.println("key=" + m.getKey()
                + " value=" + m.getValue()));

        // get latest one minute events
        ConcurrentNavigableMap<ZonedDateTime, String> events = sew.getLastOneMinute();

        System.out.println("Latest one minute events:");
        eventSet = events.entrySet();
        eventSet.forEach((m)->System.out.println("key=" + m.getKey()
                + " value=" + m.getValue()));

        long eventsLatestOneMinute = events
                .entrySet()
                .stream()
                .filter(e -> e
                        .getKey()
                        .isAfter(ZonedDateTime
                                .now()
                                .minusMinutes(1)))
                .count();
        System.out.println("Count=" + eventsLatestOneMinute);

        // get first one minute events
        events = sew.getFirstOneMinute();

        System.out.println("First one minute events:");
        eventSet = events.entrySet();
        eventSet.forEach((m)->System.out.println("key=" + m.getKey()
                + " value=" + m.getValue()));

        long eventsFirstOneMinute = events
                .entrySet()
                .stream()
                .filter(e -> e
                        .getKey()
                        .isBefore(ZonedDateTime
                                .now()
                                .minusMinutes(1)))
                .count();
        System.out.println("Count=" + eventsFirstOneMinute);

        executorService.awaitTermination(1, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}
