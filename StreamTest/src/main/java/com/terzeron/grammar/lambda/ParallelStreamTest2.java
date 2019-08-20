package com.terzeron.grammar.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreamTest2 {
    private static void printHorizontalDash() {
        System.out.println("--------------------------------------------------------");
    }

    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(new Product(23, "potatoes"), new Product(14, "orange"), new Product(13
                , "lemon"), new Product(23, "bread"), new Product(13, "sugar"));
        Stream<Product> streamOfCollection = productList.parallelStream();
        boolean isParallel = streamOfCollection.isParallel(); // 스트림이 병렬스트림인지 확인
        printHorizontalDash();
        System.out.println(isParallel);

        boolean bigPrice = streamOfCollection
                .map(product -> product.getPrice() * 12)
                .anyMatch(price -> price > 200);
        printHorizontalDash();
        System.out.println(bigPrice); // 가격을 12배 한 다음 200을 초과하는 아이템이 있는지 확인

        IntStream intStreamParallel = IntStream.range(1, 150).parallel();
        isParallel = intStreamParallel.isParallel(); // true
        printHorizontalDash();
        System.out.println(isParallel);
        IntStream intStreamSequential = intStreamParallel.sequential();
        isParallel = intStreamSequential.isParallel(); // false
        printHorizontalDash();
        System.out.println(isParallel);
    }

    @AllArgsConstructor
    @Getter
    private static class Product {
        long price;
        String name;
    }

}
