package com.terzeron.grammar.iterator;

import java.util.Iterator;

/**
 * Created by terzeron on 2016. 9. 5..
 */
public class IteratorTest {
    public static void main(String[] args) {
        BasicStack<Integer> arrays = new BasicStack<Integer>();
        arrays.push(4);
        arrays.push(8);
        arrays.push(31);
        Integer a = arrays.pop();
        Integer b = arrays.pop();
        Iterator<Integer> i = arrays.iterator();

        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
