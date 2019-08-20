package com.terzeron.grammar.lambda;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ParallelStreamTest1 {
    private static void printHorizontalDash() {
        System.out.println("--------------------------------------------------------");
    }

    public static void main(String[] args) {
        // reduction
        printHorizontalDash();
        /*OptionalInt reduced = IntStream.range(1, 4).reduce((a, b) -> a + b);*/
        OptionalInt reduced = IntStream.range(1, 4).reduce(Integer::sum);
        reduced.ifPresent(System.out::println); // 1 + 2 + 3
        printHorizontalDash();
        int reducedTwoParams = IntStream.range(1, 4).reduce(20, (a, b) -> {
            System.out.println("reduce: a=" + a + ",b=" + b);
            return a + b;
        });
        System.out.println(reducedTwoParams); // (((20 + 1) + 2) + 3)

        printHorizontalDash();
        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream().reduce(10,
                /* accumulator */ (a, b) -> {
                    System.out.println("parallelStream().accumulator: a=" + a + ",b=" + b);
                    return a + b;
                },
                /* combiner  */ (a, b) -> {
                    System.out.println("parallelStream().combiner: a=" + a + ",b=" + b);
                    return a + b;
                });
        System.out.println(reducedParallel);
        // 10 + 1 -> 11
        // 10 + 2 -> 12
        // 10 + 3 -> 13 ... 12 + 13 -> 25 ... 25 + 11 -> 36
    }
}


