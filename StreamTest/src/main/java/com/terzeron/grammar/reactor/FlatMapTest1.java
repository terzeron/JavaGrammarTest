package com.terzeron.grammar.reactor;

import reactor.core.publisher.Flux;

public class FlatMapTest1 {
    public static void main(String[] args) {
        FlatMapTest1 flatMapTest1 = new FlatMapTest1();
        flatMapTest1.fetch().subscribe(System.out::println);
    }

    public Flux<Integer> fetch() {
        return Flux.just(-1, 0, 1)
                .flatMap(id -> func1(id)
                        .flatMap(v1 -> func2()
                                .flatMap(v2 -> func3(v1))
                                .flatMap(v3 -> func4(v1)))
                );
    }

    public Flux<Integer> func1(int id) {
        return Flux.just(id);
    }

    public Flux<Integer> func2() {
        return Flux.just(1);
    }

    public Flux<Integer> func3(int v) {
        return Flux.just(v * 2);
    }

    public Flux<Integer> func4(int v) {
        return Flux.just(v * 10);
    }
}
