package com.terzeron.grammar.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// 컬렉터는 스트림의 형 변환, 컬렉션 타입 변환에 적합함
public class CollectionTest {
    private static void printHorizontalDash() {
        System.out.println("--------------------------------------------------------");
    }

    public static void main(String[] args) {
        printHorizontalDash();
        List<Product> productList = Arrays.asList(new Product(23, "potatoes"), new Product(14, "orange"), new Product(13
                , "lemon"), new Product(23, "bread"), new Product(13, "sugar"));
        List<String> collectorCollection = productList.stream().map(Product::getName).collect(Collectors.toList());
        collectorCollection.forEach(System.out::println);
        String listToString = productList.stream().map(Product::getName).collect(Collectors.joining(", ", "[", "]"));
        System.out.println(listToString);

        printHorizontalDash();
        double averagePrice = productList.stream()
                .collect(Collectors.averagingLong(Product::getPrice));
        /*long summingPrice = productList.stream()
                .collect(Collectors.summingLong(Product::getPrice));*/
        // collect(summingLong()) -> mapToLong().sum()
        long summingPrice = productList.stream()
                .mapToLong(Product::getPrice).sum();
        LongSummaryStatistics stat = productList.stream()
                .collect(Collectors.summarizingLong(Product::getPrice));
        System.out.println("average: " + averagePrice);
        System.out.println("sum: " + summingPrice);
        System.out.println(stat);

        printHorizontalDash();
        // price 값으로 그룹핑
        Map<Long, List<Product>> collectorMapOfLists = productList.stream()
                .collect(Collectors.groupingBy(Product::getPrice));
        // price 값이 15가 넘는지의 여부를 기준으로 true/false 그룹으로 분류
        Map<Boolean, List<Product>> mapPartitioned = productList.stream()
                .collect(Collectors.partitioningBy(element -> element.getPrice() > 15));
        // set으로 변환
        Set<Product> unmodifiableSet = productList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
        // custom collector (linkedlist로 변환하는 컬렉터)
        Collector<Product, ?, LinkedList<Product>> toLinkedList = Collector.of(LinkedList::new, LinkedList::add,
                (first, second) -> {
                    first.addAll(second);
                    return first;
                });
        LinkedList<Product> linkedListOfPersons = productList.stream().collect(toLinkedList);
        System.out.println(collectorMapOfLists);
        System.out.println(mapPartitioned);
        System.out.println(unmodifiableSet);
        System.out.println(linkedListOfPersons);
    }

    @AllArgsConstructor
    @Getter
    private static class Product {
        long price;
        String name;
    }
}
