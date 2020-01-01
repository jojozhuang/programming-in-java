package johnny.java.concurrency.deadlock;

public class DeadlockExample {
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    public static void main(String args[]) {
        WorkerThread1 t1 = new WorkerThread1();
        WorkerThread2 t2 = new WorkerThread2();
        t1.start();
        t2.start();
    }

    private static class WorkerThread1 extends Thread {
        public void run() {
            synchronized (Lock1) {
                System.out.println("Thread 1: Holding lock 1...");

                try {
                    Thread.sleep(10);
                }
                catch (InterruptedException e) {
                    System.out.println(e.getStackTrace());
                }
                System.out.println("Thread 1: Waiting for lock 2...");

                synchronized (Lock2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }

    private static class WorkerThread2 extends Thread {
        public void run() {
            synchronized (Lock2) {
                System.out.println("Thread 2: Holding lock 2...");

                try {
                    Thread.sleep(10);
                }
                catch (InterruptedException e) {
                    System.out.println(e.getStackTrace());
                }
                System.out.println("Thread 2: Waiting for lock 1...");

                synchronized (Lock1) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
}
