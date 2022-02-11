package com.terzeron.grammar;

public class SimpleFluxTest {
    public static void main(String[] args) {
        PoliteServer server = new PoliteServer(new KitchenService());
        server.doingMyJob().subscribe();
    }
}
