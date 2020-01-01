package johnny.java.concurrency.threadlocal;

import java.util.Map;
import java.util.WeakHashMap;

public class CustomThreadLocalExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new WeakHashMap<>();
        NumberGenerator generator = new NumberGenerator();
        Task task = new Task(map, generator);

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }

    public static class Task implements Runnable {
        Map<String, Integer> map;
        private NumberGenerator generator;

        public Task(Map<String, Integer> map, NumberGenerator generator) {
            this.map = map;
            this.generator = generator;
        }

        @Override
        public void run() {
            String threadId = Thread.currentThread().toString();
            map.put(threadId, generator.random(100));
            System.out.println(threadId + ":"+ map.get(threadId));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println(threadId + ":"+ map.get(threadId));
        }
    }
}
