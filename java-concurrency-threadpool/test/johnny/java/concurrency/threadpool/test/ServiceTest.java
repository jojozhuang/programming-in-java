package johnny.java.concurrency.threadpool.test;

import johnny.java.concurrency.threadpool.Service;
import org.junit.Test;

public class ServiceTest {

    @Test
    public void test() {
        Service service = new Service();
        service.execute();
    }
}
