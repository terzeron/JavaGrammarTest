package com.terzeron.grammar.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

// https://www.infoq.com/articles/reactor-by-example/
public class FluxTest2 {
    private static List<String> words = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog");

    public static void simpleCreation() {
        Flux<String> fewWords = Flux.just("Hello", "world");
        Flux<String> manyWords = Flux.fromIterable(words);

        fewWords.subscribe(System.out::println);
        manyWords.subscribe(System.out::println);
    }

    public static void findMissingLetter() {
        Flux<String> manyLetters = Flux.fromIterable(words)
                .flatMap(word -> Flux.fromArray(word.split("")))
                .distinct()
                .sort()
                .zipWith(Flux.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d.%s", count, string));
        manyLetters.subscribe(System.out::println);
    }

    public static void restoreMissingLetter() {
        Mono<String> missing = Mono.just("s");
        Flux<String> allLetters = Flux.fromIterable(words)
                .flatMap(word -> Flux.fromArray(word.split("")))
                .concatWith(missing)
                .distinct()
                .sort()
                .zipWith(Flux.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d.%s", count, string));
        allLetters.subscribe(System.out::println);
    }

    public static void shortCircuit() {
        Flux<String> helloPauseWorld = Mono.just("Hello")
                .concatWith(Mono.just("World").delaySubscription(Duration.ofMillis(500)));
        helloPauseWorld.subscribe(System.out::println);
    }

    public static void block() {
        Flux<String> helloPauseWorld = Mono.just("Hello")
                .concatWith(Mono.just("world").delaySubscription(Duration.ofMillis(500)));
        // blocking mode
        helloPauseWorld.toStream().forEach(System.out::println);
    }

    public static void firstEmitting() {
        Mono<String> a = Mono.just("oops, I'm late")
                .delaySubscription(Duration.ofMillis(450));
        Flux<String> b = Flux.just("let's get", "the party", "started")
                .delaySubscription(Duration.ofMillis(400));

        // firstEmitting: amb of RxJava
        Flux.firstEmitting(a, b)
                .toIterable()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        simpleCreation();
        findMissingLetter();
        restoreMissingLetter();
        shortCircuit();
        block();
        firstEmitting();
    }
}
