package net.terzeron.test.socket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SocketTest {
    class ServerThread extends Thread {
        public void run() {
            GreetServer server = new GreetServer();
            server.start(6666);
        }
    }

    @BeforeEach
    public void startServer() {
        ServerThread t = new ServerThread();
        t.start();
    }

    @Test
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        GreetClient client = new GreetClient();
        client.startConnection("127.0.0.1", 6666);

        String response = client.sendMessage("hello server");
        assertEquals("hello client", response);

        response = client.sendMessage("hello there");
        assertEquals("unrecognized greeting", response);
    }
}
