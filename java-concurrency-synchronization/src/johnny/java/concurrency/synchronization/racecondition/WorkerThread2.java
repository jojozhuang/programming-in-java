package johnny.java.concurrency.synchronization.racecondition;

public class WorkerThread2 extends Thread {
    private Counter counter;
    public WorkerThread2(Counter counter) {
        this.counter = counter;
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            this.counter.increment();
        }
    }
}
