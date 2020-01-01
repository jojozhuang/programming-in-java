package johnny.java.concurrency.synchronization;

public class Sender2 {
    public void send(String msg) {
        synchronized(this)
        {
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
}
