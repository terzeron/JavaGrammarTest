package com.terzeron.grammar.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@Slf4j
public class GreetClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public String sendMessage(String msg) {
        if (out != null) {
            out.println(msg);
        }
        String resp = null;
        try {
            if (in != null) {
                resp = in.readLine();
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return resp;
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
