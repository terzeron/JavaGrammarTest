package stream;


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

    public static void main(String[] args) {
        List<Person> people = createPeople();

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        System.out.println("Sorted by last name");
        people.stream().forEach(System.out::println);
    }
}
