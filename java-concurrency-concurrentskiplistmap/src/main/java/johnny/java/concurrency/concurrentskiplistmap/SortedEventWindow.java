package johnny.java.concurrency.concurrentskiplistmap;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class SortedEventWindow {
    private final ConcurrentSkipListMap<ZonedDateTime, String> events;

    public SortedEventWindow() {
        events = new ConcurrentSkipListMap<>(
                Comparator.comparingLong(value -> value.toInstant().toEpochMilli()));
    }

    public void acceptEvent(Event event) {
        events.put(event.getEventTime(), event.getContent());
    }

    public ConcurrentNavigableMap<ZonedDateTime, String> getAll() {
        return events;
    }

    public ConcurrentNavigableMap<ZonedDateTime, String> getLastOneMinute() {
        return events.tailMap(ZonedDateTime
                .now()
                .minusMinutes(1));
    }

    public ConcurrentNavigableMap<ZonedDateTime, String> getFirstOneMinute() {
        return events.headMap(ZonedDateTime
                .now()
                .minusMinutes(1));
    }
}
