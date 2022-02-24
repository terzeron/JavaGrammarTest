package com.terzeron.grammar.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ExceptionInLambda {
    private static void test1() {
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 6, 10, 20);
        try {
            integers.forEach(i -> System.out.println(50 / i));
        } catch (ArithmeticException e) {
            System.out.println("arithmetic exception occurred: " + e.getMessage());
        }
    }

    static Consumer<Integer> lambdaWrapper(IntConsumer consumer) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (ArithmeticException e) {
                System.out.println("arithmetic exception occurred: " + e.getMessage());
            }
        };
    }

    private static void test2() {
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.forEach(lambdaWrapper(i -> System.out.println(50 / i)));
    }

    static <T, E extends Exception> Consumer<T> consumerWrapper(Consumer<T> consumer, Class<E> clazz) {
        return i ->  {
            try {
                consumer.accept(i);
            } catch (Exception ex) {
                try {
                    E exCast = clazz.cast(ex);
                    System.out.println("exception occurred: " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw ex;
                }
            }
        };
    }

    private static void test3() {
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.forEach(consumerWrapper(i -> System.out.println(50 / i), ArithmeticException.class));
    }

    public static void main(String[] args) {
        test1();
        System.out.println("----------");
        test2();
        System.out.println("----------");
        test3();
    }
}
