package johnny.java.concurrency.deadlock.detection;

import java.lang.management.ThreadInfo;
import java.time.LocalDateTime;
import java.util.Map;

public class DetectionHandlerImp implements DetectionHandler {

    @Override
    public void handleDeadlock(final ThreadInfo[] deadlockedThreads) {
        if (deadlockedThreads != null) {
            System.err.println(LocalDateTime.now() + ": Deadlock detected!");

            Map<Thread, StackTraceElement[]> stackTraceMap = Thread.getAllStackTraces();
            for (ThreadInfo threadInfo : deadlockedThreads) {
                if (threadInfo != null) {
                    for (Thread thread : stackTraceMap.keySet()) {
                        if (thread.getId() == threadInfo.getThreadId()) {
                            System.err.println(threadInfo.toString().trim());

                            for (StackTraceElement ste : thread.getStackTrace()) {
                                System.err.println("\t" + ste.toString().trim());
                            }
                        }
                    }
                }
            }
        }
    }
}
