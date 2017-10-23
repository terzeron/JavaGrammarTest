package net.terzeron.test.comparator;

import java.util.Comparator;

/**
 * Created by terzeron on 2016. 2. 24..
 */
public class Person {
    private int index;
    private String name;

    Person(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public String toString() {
        return "Name :: " + this.name + " Index :: " + this.index;
    }

    static class IntComparator implements Comparator<Person> {
        public int compare(Person o1, Person o2) {
            return (o1.index - o2.index);
        }
    }


    static class StringComparator implements Comparator<Person> {
        public int compare(Person o1, Person o2) {
            return o1.name.compareTo(o2.name);
        }
    }
}
