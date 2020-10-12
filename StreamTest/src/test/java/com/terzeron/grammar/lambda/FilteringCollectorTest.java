package com.terzeron.grammar.lambda;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilteringCollectorTest {
    @Test
    public void givenList_whenSatisfyPredicate_thenMapValueWithOccurrences() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 4, 5, 4);

        // filter() & counting & groupingBy()
        Map<Integer, Long> result = numbers.stream()
                .filter(val -> val > 3)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(result);
        assertEquals(2, result.size());

        // filtering collector
        result = numbers.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.filtering(val -> val > 3, Collectors.counting())));
        System.out.println(result);
        assertEquals(5, result.size());
    }
}
