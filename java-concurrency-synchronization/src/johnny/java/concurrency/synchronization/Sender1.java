package johnny.java.concurrency.synchronization;

public class Sender1 {
    public synchronized void send(String msg) {
        System.out.println("Sending: " + msg);
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Thread interrupted.");
        }
        System.out.println(msg + " is sent.");
    }
}
