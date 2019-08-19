package com.terzeron.grammar.compress.pattern.socket;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SocketTest {
    static class ServerThread extends Thread {
        @Override
        public void run() {
            GreetServer server = new GreetServer();
            server.start(6666);
        }
    }

    private static ServerThread t;

    @BeforeAll
    static void startServer() {
        t = new ServerThread();
        t.start();
    }

    @Test
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() {
        GreetClient client = new GreetClient();
        client.startConnection("127.0.0.1", 6666);

        String response = client.sendMessage("hello server");
        assertEquals("hello client", response);

        response = client.sendMessage("hello there");
        assertEquals("unrecognized greeting", response);
    }
}
