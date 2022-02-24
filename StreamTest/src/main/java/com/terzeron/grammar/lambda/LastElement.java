package com.terzeron.grammar.lambda1.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LastElement {
    public static void main(String[] args) {
        List<String> valueList = new ArrayList<>();
        valueList.add("Joe");
        valueList.add("John");
        valueList.add("Sean");

        Stream<String> stream = valueList.stream();
        String last = stream.reduce((first, second) -> second)
                .orElse(null);
        System.out.println(last);

        long count = valueList.stream().count();
        Stream<String> stream2 = valueList.stream();
        String last2 = stream2.skip(count - 1).findFirst().orElse("");
        System.out.println(last2);

        // infinite -> will not terminate
        Stream<Integer> stream3 = Stream.iterate(0, i -> i + 1);
        Integer last3 = stream3.reduce((first, second) -> second).orElse(null);
        System.out.println(last3);
    }
}
