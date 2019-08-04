package johnny.java.concurrency.callable;

public class RunnableExample {
    public static void main(String[] args) throws Exception {
        RunnableWorker[] tasks = new RunnableWorker[5];

        System.out.println("Creating tasks...");
        for (int i = 0; i < 5; i++) {
            tasks[i] = new RunnableWorker();
            Thread t = new Thread(tasks[i]);
            t.start();
        }

        System.out.println("Waiting results...");
        for (int i = 0; i < 5; i++) {
            System.out.println(tasks[i].get());
        }
    }
}
