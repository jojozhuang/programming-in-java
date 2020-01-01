package johnny.java.concurrency.notify;

import java.time.LocalDateTime;

public class Consumer implements Runnable{

    private Message msg;

    public Consumer(Message msg){
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try{
                System.out.println(name+": waiting to get notified at: " + LocalDateTime.now().toString());
                msg.wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name+": got notified at: " + LocalDateTime.now().toString());
            //process the message now
            System.out.println(name+": message[" + msg.getMsg() + "] is processed.");
        }
    }
}