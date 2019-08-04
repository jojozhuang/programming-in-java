package johnny.java.concurrency.synchronization;

public class Sender {
    public synchronized void send1(String msg) {
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

    public void send2(String msg) {
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
