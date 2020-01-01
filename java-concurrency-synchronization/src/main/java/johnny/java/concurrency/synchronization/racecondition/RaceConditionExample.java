package johnny.java.concurrency.synchronization.racecondition;

public class RaceConditionExample {
    public static void main(String[] args) {
        Counter counter = new Counter();
        WorkerThread1 t1 = new WorkerThread1(counter);
        WorkerThread2 t2 = new WorkerThread2(counter);
        t1.start();
        t2.start();
    }
}


