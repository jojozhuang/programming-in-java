package johnny.java.concurrency.concurrentskiplistmap;

import java.time.ZonedDateTime;
import java.util.stream.IntStream;

public class Task implements Runnable {
    private String name;
    private boolean odd;
    private SortedEventWindow sew;

    public Task(String name, boolean odd, SortedEventWindow sew) {
        this.name = name;
        this.odd = odd;
        this.sew = sew;
    }

    public void run() {
        if (this.odd) {
            IntStream
                .rangeClosed(1, 100)
                .filter(i->i % 2 == 1)
                .forEach(index -> sew.acceptEvent(new Event(ZonedDateTime
                        .now()
                        .minusSeconds(index), name)));
        } else {
            IntStream
                .rangeClosed(1, 100)
                .filter(i->i % 2 == 0)
                .forEach(index -> sew.acceptEvent(new Event(ZonedDateTime
                        .now()
                        .minusSeconds(index), name)));
        }
    }
}
