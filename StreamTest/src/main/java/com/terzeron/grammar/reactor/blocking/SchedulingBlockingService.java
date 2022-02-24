package com.terzeron.grammar.reactor.blocking;

import reactor.core.publisher.Mono;

// https://egkatzioura.com/2021/10/11/executing-blocking-calls-on-a-reactor-based-application/
public class SchedulingBlockingService {
    public static void main(String[] args) {
        BlockingAsyncService blockingAsyncService = new BlockingAsyncService(new BlockingService());
        Mono.just("https://www.google.com/")
                .map(s -> blockingAsyncService.get(s))
                .flatMap(s -> s)
                .doOnNext(System.out::println)
                .block();
    }
}
