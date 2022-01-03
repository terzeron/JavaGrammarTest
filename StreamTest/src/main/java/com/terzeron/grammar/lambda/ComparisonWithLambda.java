package com.terzeron.grammar.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparisonWithLambda {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Sarah", 10));
        humans.add(new Human("Jack", 12));
        humans.add(new Human("Mike", 30));

        sortWithoutLambda(humans);
        sortWithLambda(humans);
        sortWithLambdaComparing(humans);
        sortWithLambdaStreamSorted(humans);
    }

    private static void sortWithoutLambda(List<Human> humans) {
        Collections.sort(humans, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Human) o1).getName().compareTo(((Human) o2).getName());
            }
        });
        for (Human h : humans) {
            System.out.println(h);
        }
    }

    private static void sortWithLambda(List<Human> humans) {
        humans.sort((Human h1, Human h2) -> h1.getName().compareTo(h2.getName()));
        for (Human h : humans) {
            System.out.println(h);
        }
    }

    private static void sortWithLambdaComparing(List<Human> humans) {
        humans.sort(Comparator.comparing(Human::getName));
    }

    private static void sortWithLambdaStreamSorted(List<Human> humans) {
        List<Human> newHumans = humans
                .stream()
                .sorted(Comparator.comparing(Human::getName, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        for (Human h : newHumans) {
            System.out.println(h);
        }
    }

    @AllArgsConstructor
    @Data
    static class Human {
        private String name;
        private int age;
    }
}
