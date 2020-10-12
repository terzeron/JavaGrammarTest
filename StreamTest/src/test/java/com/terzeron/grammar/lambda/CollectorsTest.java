package com.terzeron.grammar.lambda;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CollectorsTest {
    @Test
    public void testRunCollectors(String[] args) {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        List<String> result = givenList.stream().collect(toList());

        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
        Set<String> result1 = listWithDuplicates.stream().collect(toSet());
        assertEquals(result1.size(), 4);

        List<String> result2 = givenList.stream().collect(toCollection(LinkedList::new));

        Map<String, Integer> result3 = givenList.stream().collect(toMap(Function.identity(), String::length));
    }
}
