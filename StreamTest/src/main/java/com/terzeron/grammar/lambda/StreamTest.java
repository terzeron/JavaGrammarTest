package com.terzeron.grammar.lambda;

import lombok.Data;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    private static void creationTest() {
        // from array
        String[] arr1 = new String[]{"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(arr1);
        stream1.forEach(System.out::println);

        Stream<String> stream2 = Stream.of("a", "b", "c");
        stream2.forEach(System.out::println);

        // from list
        List<String> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("b");
        list3.add("c");
        Stream<String> stream3 = list3.stream();
        stream3.forEach(System.out::println);
    }

    private static void parallelStreamTest() {
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("22");
        list.add("33");
        list.parallelStream().forEach(System.out::println);
    }

    private static void operationTest() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("22");
        list.add("33");
        list.add("11");
        long count = list.stream().distinct().count();
        System.out.println(count);

        boolean isExist = list.stream().anyMatch(element -> element.contains("2"));
        System.out.println(isExist);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("One");
        list2.add("OneAndOnly");
        list2.add("Derek");
        list2.add("Change");
        list2.add("factory");
        list2.add("justBefore");
        list2.add("Italy");
        list2.add("Italy");
        list2.add("Thursday");
        list2.add("");
        list2.add("");
        Stream<String> stream2 = list2.stream().filter(element -> element.contains("d"));
        stream2.forEach(System.out::println);

        List<String> uris = new ArrayList<>();
        uris.add("StreamTest/src/main/java/com/terzeron/grammar/lambda/StreamTest.java");
        Stream<Path> stream3 = uris.stream().map(uri -> Paths.get(uri));

        @Data
        class Detail {
            int no;
            String description;
            List<String> parts;

            public Detail(int no, String description, String[] parts) {
                this.no = no;
                this.description = description;
                this.parts = new ArrayList<>();
                for (String part : parts) {
                    this.parts.add(part);
                }
            }
        }
        List<Detail> details = new ArrayList<>();
        details.add(new Detail(1, "gear", new String[]{"p1", "p2", "p3"}));
        Stream<String> stream4 = details.stream().flatMap(detail -> detail.getParts().stream());
        stream4.forEach(System.out::println);

        boolean isValidAnyMatch = list2.stream().anyMatch(element -> element.contains("y"));
        System.out.println(isValidAnyMatch);
        boolean isValidAllMatch = list2.stream().allMatch(element -> element.contains("y"));
        System.out.println(isValidAllMatch);
        boolean isValidNoneMatch = list2.stream().noneMatch(element -> element.contains("y"));
        System.out.println(isValidNoneMatch);

        List<String> resultList = list.stream().map(element -> element.toUpperCase()).collect(Collectors.toList());
        System.out.println(resultList);
    }

    private static void takeWhileTest() {
        Stream<String> stream = Stream.iterate("", s -> s + "s")
                .takeWhile(s -> s.length() < 10);
        stream.forEach(System.out::println);

        Stream<String> stream2 = Stream.iterate("", s -> s + "s")
                .dropWhile(s -> !s.contains("sssss"))
                .takeWhile(s -> s.length() < 10);
        stream2.forEach(System.out::println);
    }

    private static void ofNullableTest() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        Map<String, Integer> map = new HashMap<>();
        map.put("hello", 1);
        map.put("java", 3);
        List<Integer> list2 = list.stream()
                .flatMap(s -> Stream.ofNullable(map.get(s))) // null도 존재할 수 있지만 무시함
                .collect(Collectors.toList());
        for (Integer i : list2) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("---- creationTest ----");
        creationTest();

        System.out.println("---- parallelStreamTest ----");
        parallelStreamTest();

        System.out.println("---- operationTest ----");
        operationTest();

        System.out.println("---- takeWhileTest ----");
        takeWhileTest();

        System.out.println("---- ofNullableTest ----");
        ofNullableTest();
    }
}

