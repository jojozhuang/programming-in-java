package johnny.java.threadpool.test;

import johnny.java.threadpool.Service;
import org.junit.Test;

import org.junit.Assert;

public class ServiceTest {

    @Test
    public void test() {
        Service service = new Service();
        service.execute();
    }
}
