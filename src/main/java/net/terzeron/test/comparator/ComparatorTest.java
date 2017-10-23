package net.terzeron.test.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

/**
 * Created by terzeron on 2016. 2. 24..
 */
public class ComparatorTest {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        ComparatorTest test = new ComparatorTest();

        personList.add(new Person(1, "abc"));
        personList.add(new Person(5, "mno"));
        personList.add(new Person(3, "xyz"));
        System.out.println("Person List Before sort ::: " + personList);

        Collections.sort(personList, new Person.IntComparator());
        System.out.println("Person List After Integer sort ::: " + personList);

        Collections.sort(personList, new Person.StringComparator());
        System.out.println("Person List After String sort ::: " + personList);
    }
}
