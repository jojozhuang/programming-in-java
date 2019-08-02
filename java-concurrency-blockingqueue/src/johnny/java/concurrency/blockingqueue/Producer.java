package johnny.java.concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Message> bq;

    public Producer(BlockingQueue<Message> bq){
        this.bq = bq;
    }

    @Override
    public void run() {
        //produce messages
        for (int i = 0; i < 20; i++){
            Message msg = new Message("Message-" + i);
            try {
                Thread.sleep(i);
                bq.put(msg);
                System.out.println("Produced " + msg.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //adding exit message
        Message msg = new Message("exit");
        try {
            bq.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
