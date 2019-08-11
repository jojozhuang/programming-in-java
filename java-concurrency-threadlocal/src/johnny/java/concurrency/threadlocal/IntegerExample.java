package johnny.java.concurrency.threadlocal;

public class IntegerExample {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        Task task = new Task(generator);

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }

    public static class Task implements Runnable {
        private Integer count = new Integer(0);
        private NumberGenerator generator;

        public Task(NumberGenerator generator) {
            this.generator = generator;
        }

        @Override
        public void run() {
            count = generator.random(100);
            System.out.println(count);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println(count);
        }
    }

}
