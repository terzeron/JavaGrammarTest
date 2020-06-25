package com.terzeron.grammar.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import one.util.streamex.StreamEx;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.utility.ListIterate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DistinctByTest {
    static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class Person {
        private int age;
        private String name;
        private String email;
    }

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person(10, "Mike", "mike@email.com"),
                new Person(20, "Jack", "jack@theripper.com"),
                new Person(30, "Smith", "smith@gmail.com"),
                new Person(25, "Jack", "jack@yahoo.com"));
        // first method
        List<Person> personListFiltered = personList.stream()
                .filter(distinctByKey(p -> p.getName()))
                .collect(Collectors.toList());
        personListFiltered.forEach(p -> System.out.println(p.getName()));

        // second method
        List<Person> personListFiltered2 = ListIterate.distinct(personList, HashingStrategies.fromFunction(Person::getName));
        personListFiltered2.forEach(p -> System.out.println(p.getName()));

        // third method
        List<Person> personListFiltered3 = StreamEx.of(personList).distinct(Person::getName).toList();
    }
}
