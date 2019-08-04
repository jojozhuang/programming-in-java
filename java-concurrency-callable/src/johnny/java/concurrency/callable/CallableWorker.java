package johnny.java.concurrency.callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableWorker implements Callable {
    public Object call() throws Exception {
        Random random = new Random();
        Integer randomNumber = random.nextInt(5);

        Thread.sleep(randomNumber * 1000);

        return randomNumber;
    }
}