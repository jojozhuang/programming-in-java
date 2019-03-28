package johnny.java.threadpool;

public class MyThreadPoolExample {
    public static void main(String[] args)
    {
        MyThreadPool threadPool = new MyThreadPool(2);

        for (int i = 1; i <= 5; i++)
        {
            Task task = new Task("Task " + i);
            System.out.println("Created : " + task.getName());
            try {
                threadPool.execute(task);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
    }
}
