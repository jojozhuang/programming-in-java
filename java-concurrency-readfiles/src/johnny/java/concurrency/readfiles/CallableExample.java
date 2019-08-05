package johnny.java.concurrency.readfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        // create tasks
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tasks.add(new CallableTask("test" + (i + 1) + ".txt"));
        }

        // create threads for each task
        ExecutorService exec = Executors.newFixedThreadPool(2);
        List<Future<String>> results = exec.invokeAll(tasks);
        exec.shutdown();

        // collect results
        System.out.println("Result:");
        String content = "";
        try {
            for (Future<String> future : results) {
                content += future.get() + System.lineSeparator();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(content);
    }

    public static void main2(String[] args) {
        List<Future<String>> list = new ArrayList<Future<String>>();

        // create threads for each task
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            CallableTask task = new CallableTask("test" + i + ".txt");

            Future<String> future = executor.submit(task);
            list.add(future);
        }
        executor.shutdown();

        // collect results
        System.out.println("Result:");
        String content = "";
        try {
            for (Future<String> future : list) {
                content += future.get() + System.lineSeparator();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(content);
    }
}
