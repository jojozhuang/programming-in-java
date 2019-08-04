package johnny.java.concurrency.synchronization;

public class SynchronizeBlockExample {
    public static void main(String[] args)
    {
        Sender sender = new Sender();
        sender.send1("method block");
        sender.send2("code block");
    }
}
