package johnny.java.concurrency.synchronization;

public class SynchronizeBlockExample {
    public static void main(String[] args) {
        Sender1 sender1 = new Sender1();
        sender1.send("synchronize method");

        Sender2 sender2 = new Sender2();
        sender2.send("synchronize block");
    }
}
