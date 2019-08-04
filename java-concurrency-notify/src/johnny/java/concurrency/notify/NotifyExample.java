package johnny.java.concurrency.notify;

public class NotifyExample {
    public static void main(String[] args) throws Exception {
        Message msg = new Message("process it");

        Consumer consumer1 = new Consumer(msg);
        new Thread(consumer1,"Consumer1").start();

        Consumer consumer2 = new Consumer(msg);
        new Thread(consumer2,"Consumer2").start();

        Producer producer = new Producer(msg);
        new Thread(producer, "Producer").start();

        Thread.sleep(1000);
        System.out.println("main: All the threads are started");
    }
}