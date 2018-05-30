package net.terzeron.test.socket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SocketTest {
    private ServerThread t;

    class ServerThread extends Thread {
        public void run() {
            GreetServer server = new GreetServer();
            server.start(6666);
        }
    }

    void startServer() {
        t = new ServerThread();
        t.start();
    }

    @Test
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() {
        startServer();

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
