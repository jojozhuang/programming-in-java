package johnny.java.concurrency.notify;

import java.time.LocalDateTime;

public class Producer implements Runnable {

    private Message msg;

    public Producer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": started");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setMsg("hello world!");
                System.out.println(name+": message is updated at: " + LocalDateTime.now().toString());

                //msg.notify();
                msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
