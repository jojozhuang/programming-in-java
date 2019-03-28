package johnny.java.thread;

public class ThreadExample {
    public static void main(String[] args)
    {
        // Thread class
        MyThread myThread = new MyThread();
        myThread.start();

        // Runnable interface
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
