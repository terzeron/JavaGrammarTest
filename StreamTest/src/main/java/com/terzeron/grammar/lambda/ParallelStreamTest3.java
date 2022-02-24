package com.terzeron.grammar.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreamTest3 {
    public static void main(String[] args) throws Exception {
        List<Long> aList = new ArrayList<>();
        Stream<Long> parallelStream = aList.parallelStream();
        System.out.println(parallelStream.isParallel());

        // custom thread pool
        long firstNum = 1;
        long lastNum = 1_000_000;
        List<Long> aList2 = LongStream
                .rangeClosed(firstNum, lastNum)
                .boxed()
                .collect(Collectors.toList());
        ForkJoinPool customThreadPool = new ForkJoinPool(4);
        long actualTotal = customThreadPool
                .submit(() -> aList2.parallelStream().reduce(0L, Long::sum))
                .get();
        System.out.println(actualTotal);
    }
}
