package johnny.java.core.nio.test;

import johnny.java.core.nio.EchoClient;
import johnny.java.core.nio.EchoServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class EchoTest {

    Process server;
    EchoClient client;

    @Before
    public void setup() throws IOException, InterruptedException {
        server = EchoServer.start();
        Thread.sleep(2000); // sleep to make sure server is up.
        client = EchoClient.start();
    }

    @Test
    public void givenServerClient_whenServerEchosMessage_thenCorrect() {
        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("world");
        String disconnect = client.sendMessage("POISON_PILL");
        //String error = client.sendMessage("welcome"); // will fail as connection is closed

        assertEquals("hello", resp1);
        assertEquals("world", resp2);
        assertEquals("POISON_PILL", disconnect);
    }

    @After
    public void teardown() throws IOException {
        server.destroy();
        EchoClient.stop();
    }
}