package com.terzeron.grammar.rxjava;

import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class WordTest {
    public static void main(String[] args) {
        Observable.just("Howdy!");
        Observable<String> hello = Observable.just("Hello!");
        hello.subscribe(System.out::println);

        Observable.just("Hello", "World").subscribe(System.out::println);

        // from과 just의 차이
        List<String> words = Arrays.asList(
                "the",
                "quick",
                "brown",
                "fox",
                "jumped",
                "over",
                "the",
                "lazy",
                "dog");
        Observable.just(words).subscribe(word -> System.out.println(word));
        Observable.from(words).subscribe(word -> System.out.println(word));

        // zipWith
        Observable.from(words)
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d.%s", count, string))
                .subscribe(System.out::println);
        Observable
                .from(words)
                .flatMap(word -> Observable.from(word.split("")))
                .distinct()
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d.%s", count, string))
                .subscribe(System.out::println);
    }
}
