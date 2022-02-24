package com.terzeron.grammar.lambda;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamTest4 {
    public static void main(String[] args) {
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        listOfNumbers.stream().forEach(number -> System.out.println(number + " " + Thread.currentThread().getName()));
        
        List<Integer> listOfNumbersParallel = Arrays.asList(1, 2, 3, 4);
        listOfNumbersParallel.parallelStream().forEach(number -> System.out.println(number + " "  + Thread.currentThread().getName()));
    }
}
