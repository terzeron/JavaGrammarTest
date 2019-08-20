package com.terzeron.grammar.lambda;

import java.util.*;

public class LambdaBasicDemo {
    public static void main(String[] args) {
        List<Person> people = createPeople();
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        });
        System.out.println("Firstname com.terzeron.grammar.sort: " + people);

        // labmda style com.terzeron.grammar.sort
        people.sort((o1, o2) -> {
            return o1.lastName.compareTo(o2.lastName);
        });
        System.out.println("Lastname com.terzeron.grammar.sort: " + people);
    }

    static List<Person> createPeople() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1900, Calendar.JANUARY, 01, 12, 00);
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
}
