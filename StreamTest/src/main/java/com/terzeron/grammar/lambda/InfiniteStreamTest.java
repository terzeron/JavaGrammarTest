package com.terzeron.grammar.lambda1.lambda;

import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InfiniteStreamTest {
    private static void iterationTest() {
        // infinite stream by iterate()
        Stream<Integer> stream1 = Stream.iterate(0, i -> i + 2);
        List<Integer> list1 = stream1
                .limit(10)
                .collect(Collectors.toList());
        for (Integer i : list1) {
            System.out.println(i);
        }
    }

    private static void customTypeInfiniteStreamTest() {
        Supplier<UUID> randomUUIDSupplier = UUID::randomUUID;
        Stream<UUID> infiniteStreamOfRandomUUID = Stream.generate(randomUUIDSupplier);
        List<UUID> randomIDs = infiniteStreamOfRandomUUID
                .skip(10)
                .limit(10)
                .collect(Collectors.toList());
        for (UUID id : randomIDs) {
            System.out.println(id);
        }
    }

    public static void main(String[] args) {
        System.out.println("---- iterationTest ----");
        iterationTest();
        System.out.println("---- customTypeInfiniteStream ----");
        customTypeInfiniteStreamTest();
    }
}
