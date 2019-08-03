package johnny.java.core.queuestack;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<String> tasks = new PriorityQueue<>();
        tasks.add("task1");
        tasks.add("task4");
        tasks.add("task3");
        tasks.add("task2");
        tasks.add("task5");
        System.out.println(tasks);


        PriorityQueue reverseTasks = new PriorityQueue(Comparator.reverseOrder());
        reverseTasks.add("task1");
        reverseTasks.add("task4");
        reverseTasks.add("task3");
        reverseTasks.add("task2");
        reverseTasks.add("task5");
        System.out.println(reverseTasks);
    }
}
