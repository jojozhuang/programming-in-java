package johnny.java.concurrency.threadlocalrandom;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomExample {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        Task task1 = new Task("Task one");
        Task task2 = new Task("Task two");
        pool.invoke(task1);
        pool.invoke(task2);
    }

    public static class Task extends ForkJoinTask<String> {
        private String taskName;

        public Task(String name){
            this.taskName = name;
        }

        @Override
        protected boolean exec() {
            int i = ThreadLocalRandom.current().nextInt(1, 10);
            System.out.println("ThreadLocalRandom for " + taskName + ": " + i);
            return true;
        }

        @Override
        public String getRawResult() {
            return null;
        }

        @Override
        protected void setRawResult(String value) {
        }
    }
}
