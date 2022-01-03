package com.terzeron.grammar.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Stream.generate(() -> Math.random());
        Stream.generate(Math::random);

        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> objs = list.stream();
        for (String obj: list) {
        }
        objs.forEach(obj -> {});
    }
}
