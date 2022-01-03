package com.terzeron.grammar.lambda;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamSupplierTest {
    public static void main(String[] args) {
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("A", "B", "C");

        Optional<String> result1 = streamSupplier.get().findAny();
        System.out.println(result1.orElse(""));
        Optional<String> result2 = streamSupplier.get().findFirst();
        System.out.println(result2.orElse(""));
    }
}
