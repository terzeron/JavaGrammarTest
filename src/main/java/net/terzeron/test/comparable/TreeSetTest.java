package net.terzeron.test.comparable;

import java.util.*;

/**
 * Created by terzeron on 2016. 2. 24..
 */
public class TreeSetTest {
    private static Set<Person> s = new TreeSet<Person>();

    public static void main(String args[]) {
        s.add(new Person(20));
        s.add(new Person(30));
        s.add(new Person(10));
        s.add(new Person(50));
        System.out.println(s);
    }
}
