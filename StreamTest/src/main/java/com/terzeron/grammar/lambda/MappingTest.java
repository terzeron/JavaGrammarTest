package com.terzeron.grammar.lambda1.lambda;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.*;

@Slf4j
public class MappingTest {
    static Stream<String> streamOf(List<String> list) {
        return (list == null || list.isEmpty()) ? Stream.empty() : list.stream();
    }

    private static void printHorizontalDash() {
        System.out.println("--------------------------------------------------------");
    }

    private static long counter;

    private static void wasCalled() {
        counter++;
    }

    public static void main(String[] args) {
        // collection to stream
        Stream<String> streamEmpty = Stream.empty();
        streamEmpty.forEach(System.out::println);
        List<String> list1 = Arrays.asList("a", "b", "c");
        streamOf(list1);
        Stream<String> streamOfCollection = list1.stream();
        printHorizontalDash();
        streamOfCollection.forEach(System.out::println);

        // builder
        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
        printHorizontalDash();
        streamBuilder.forEach(System.out::println);

        // generate
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(3);
        printHorizontalDash();
        streamGenerated.forEach(System.out::println);

        // iterate
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(4);
        printHorizontalDash();
        streamIterated.forEach(System.out::println);

        // primitives
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);
        Random random = new Random();
        DoubleStream doubleStream = random.doubles(3);
        printHorizontalDash();
        intStream.forEach(System.out::println);
        printHorizontalDash();
        longStream.forEach(System.out::println);
        printHorizontalDash();
        doubleStream.forEach(System.out::println);

        // stream of string
        IntStream streamOfChars = "abc".chars();
        Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");
        printHorizontalDash();
        streamOfChars.forEach(System.out::println);
        printHorizontalDash();
        streamOfString.forEach(System.out::println);

        // stream of file
        Path path = Paths.get("file.txt");
        try {
            Stream<String> streamOfStrings = Files.lines(path);
            Stream<String> streamWithCharset = Files.lines(path, StandardCharsets.UTF_8);
            printHorizontalDash();
            streamOfStrings.forEach(System.out::println);
            printHorizontalDash();
            streamWithCharset.forEach(System.out::println);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        // referencing
        Stream<String> stream = Stream.of("ab", "b", "c", "b").filter(element -> element.contains("b"));
        Optional<String> anyElement = stream.findAny(); // no guarantee for the encounter order
        printHorizontalDash();
        anyElement.ifPresent(System.out::println);

        stream = Stream.of("a", "b", "c").filter(element -> element.contains("b") || element.contains("a"));
        Optional<String> firstElement = stream.findFirst(); // guarantee for the encounter order
        printHorizontalDash();
        firstElement.ifPresent(System.out::println);

        List<String> elements =
                Stream.of("a", "c", "b", "c").filter(element -> element.contains("c")).collect(Collectors.toList());
        Optional<String> anyElement1 = elements.stream().findAny();
        Optional<String> firstElement1 = elements.stream().findFirst();
        printHorizontalDash();
        anyElement1.ifPresent(System.out::println);
        printHorizontalDash();
        firstElement1.ifPresent(System.out::println);

        // pipeline
        Stream<String> onceModifiedStream = Stream.of("abcd", "bbcd", "cdcd").skip(1);
        printHorizontalDash();
        onceModifiedStream.forEach(System.out::println);
        onceModifiedStream = Stream.of("abcd", "bbcd", "cdcd").skip(1);
        Stream<String> twiceModifiedStream = onceModifiedStream.skip(1).map(element -> element.substring(0, 3));
        printHorizontalDash();
        twiceModifiedStream.forEach(System.out::println);

        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        long size = list.stream().skip(1).map(element -> element.substring(0, 3)).count();
        printHorizontalDash();
        System.out.println(size);

        // lazy invocation
        List<String> list2 = Arrays.asList("abc1", "abc2", "abc3");
        counter = 0;
        Stream<String> stream2 = list2.stream().filter(element -> {
            wasCalled();
            return element.contains("2");
        });
        printHorizontalDash();
        stream2.forEach(System.out::println);

        printHorizontalDash();
        Optional<String> stream3 = list.stream().filter(element -> {
            System.out.println("filter() was called");
            return element.contains("2");
        }).map(element -> {
            System.out.println("map() was called");
            return element.toUpperCase();
        }).findFirst();
        stream3.ifPresent(System.out::println);

        // order of execution
        counter = 0;
        List<String> list3 = Arrays.asList("abc1", "abc2", "abc3");
        long size3 = list3.stream().map(element -> {
            wasCalled();
            return element.substring(0, 3);
        }).skip(2).count();
        printHorizontalDash();
        System.out.println(size3);
        System.out.println(counter); // count of being called

        counter = 0;
        List<String> list4 = Arrays.asList("abc1", "abc2", "abc3");
        long size4 = list4.stream().skip(2).map(element -> {
            wasCalled();
            return element.substring(0, 3);
        }).count();
        printHorizontalDash();
        System.out.println(size4);
        System.out.println(counter); // count of being called

    }
}
