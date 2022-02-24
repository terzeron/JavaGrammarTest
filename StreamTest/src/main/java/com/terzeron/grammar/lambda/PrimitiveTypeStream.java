package com.terzeron.grammar.lambda1.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimitiveTypeStream {
    public static void main(String[] args) {
        System.out.println("---- intStreamTest ----");
        intStreamTest();
        System.out.println("---- streamRangeTest ----");
        streamRangeTest();
        System.out.println("---- boxingTest ----");
        boxingTest();
    }

    private static void intStreamTest() {
        int[] integers = new int[]{20, 98, 12, 7, 35};
        int min = Arrays.stream(integers)
                .min()
                .getAsInt();
        System.out.println(min);

        int max = IntStream.of(20, 98, 12, 7, 35)
                .max()
                .getAsInt();
        System.out.println(max);

        int sum = IntStream.of(20, 98, 12, 7, 35)
                .sum();
        System.out.println(sum);

        double avg = IntStream.of(20, 98, 12, 7, 35)
                .average()
                .getAsDouble();
        System.out.println(avg);
    }

    public static void streamRangeTest() {
        int sum = IntStream.range(1, 10)
                .sum();
        System.out.println(sum);

        int sum2 = IntStream.rangeClosed(1, 10)
                .sum();
        System.out.println(sum2);

        IntStream.range(1, 5)
                .forEach(System.out::println);
        IntStream.rangeClosed(1, 5)
                .parallel()
                .forEach(System.out::println);
    }

    public static void boxingTest() {
        List<Integer> evenInts = IntStream.rangeClosed(1, 10)
                .filter(i -> i % 2 == 0)
                .boxed() // primitive type to object type
                .collect(Collectors.toList());
        for (Integer i : evenInts) {
            System.out.println(i);
        }

        int sum = Arrays.stream(new Integer[]{33, 45})
                .mapToInt(i -> i)
                .sum();
        System.out.println(sum);
    }
}
