package com.terzeron.grammar.lambda;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

public class ComparatorTest {
    @AllArgsConstructor
    @ToString
    @Getter
    private static class Person {
        private String firstName;
        private String lastName;
        private Date dateOfBirth;
        private String placeOfBirth;
    }

    private static List<Person> createPeople() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(1900, Calendar.JANUARY, 1, 12, 0);
        List<Person> people = new ArrayList<>();
        Person person = new Person("Raju", "Sarkar", calendar.getTime(), "Delhi");
        people.add(person);

        calendar.set(1950, Calendar.JUNE, 30, 12, 30);
        person = new Person("Anant", "Patil", calendar.getTime(), "Pune");
        people.add(person);

        calendar.set(1950, Calendar.DECEMBER, 30, 12, 30);
        person = new Person("Danny", "Great", calendar.getTime(), "London");
        people.add(person);

        return people;
    }

    public static void main(String[] args) {
        List<Person> people = createPeople();

        // comparator를 이용한 컬렉션 정렬
        /*Collections.sort(people, new Comparator<>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });*/
        // lambda를 이용한 컬렉션 정렬
        /*Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));*/
        // list 상태에서 바로 정렬
        /*people.sort((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));*/
        // Comparator.comparing이라는 static method를 사용하는 정렬 방법
        people.sort(Comparator.comparing(Person::getLastName));

        System.out.println("Sorted by last name");
        people.forEach(System.out::println);
    }
}
