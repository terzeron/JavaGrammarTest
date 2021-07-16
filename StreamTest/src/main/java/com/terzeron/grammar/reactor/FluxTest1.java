package com.terzeron.grammar.reactor;

import reactor.core.publisher.Flux;

public class FluxTest1 {
    public static void main(String[] args) {
        Flux<String> flux = Flux.just("foo", "MusicBox");
        flux = flux.map(secret -> secret.replaceAll("[A-Z]", "*"));
        flux.subscribe(next -> System.out.println("Received: " + next));
    }
}
