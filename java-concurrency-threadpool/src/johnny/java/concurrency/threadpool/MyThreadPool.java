package johnny.java.concurrency.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {
    private BlockingQueue bq ;
    private List<WorkerThread> threads;
    private boolean isStopped;
    private int capacity;

    public MyThreadPool(int numOfThreads){
        isStopped = false;
        capacity = 100;
        bq = new ArrayBlockingQueue(capacity);
        threads = new ArrayList<>();
        for (int i = 0; i < numOfThreads; i++){
            threads.add(new WorkerThread(bq));
        }
        for (WorkerThread thread : threads) {
            thread.start();
        }
    }

    public synchronized void execute(Runnable task) throws Exception{
        if (this.isStopped) {
            throw new IllegalStateException("ThreadPool is stopped");
        }

        this.bq.put(task);
    }

    public synchronized void shutdown(){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.isStopped = true;
        for (WorkerThread thread : threads) {
            thread.doStop();
        }
    }

    class WorkerThread extends Thread {

        private BlockingQueue<Runnable> bq;
        private boolean isStopped;

        public WorkerThread(BlockingQueue bq){
            this.bq = bq;
            this.isStopped = false;
        }

        public void run(){
            while(!isStopped()){
                try {
                    Runnable runnable = bq.take();
                    runnable.run();
                } catch(Exception e){
                    //log or otherwise report exception,
                    //but keep worker thread alive.
                }
            }
        }

        public synchronized void doStop(){
            if (!this.isInterrupted()) {
                try {
                    this.interrupt(); //break worker thread
                } catch (SecurityException ignore) {
                } finally {
                }
            }
            isStopped = true;
        }

        public synchronized boolean isStopped(){
            return isStopped;
        }
    }
}
