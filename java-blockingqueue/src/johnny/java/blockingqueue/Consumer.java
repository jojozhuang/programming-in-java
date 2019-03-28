package johnny.java.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Message> bq;

    public Consumer(BlockingQueue<Message> bq){
        this.bq = bq;
    }

    @Override
    public void run() {
        try {
            Message msg;
            //consuming messages until exit message is received
            while ((!(msg = bq.take()).getMessage().equals("exit"))) {
                Thread.sleep(100);
                System.out.println("Consumed " + msg.getMessage());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
