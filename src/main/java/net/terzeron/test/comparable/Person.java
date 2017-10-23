package net.terzeron.test.comparable;

/**
 * Created by terzeron on 2016. 2. 24..
 */
public class Person implements Comparable<Person> {
    int i;
    Person(int i) {
        this.i = i;
    }

    public int compareTo(Person o) {
        int j = o.i;
        System.out.println("this.i::" + this.i + " <> j::" + j);
        if (this.i < j) {
            return -1;
        } else if (this.i == j) {
            return 0;
        } else {
            return 1;
        }
    }

    public String toString() {
        return String.valueOf("Person" + i);
    }
}
