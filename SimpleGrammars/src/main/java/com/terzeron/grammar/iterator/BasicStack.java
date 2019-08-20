package com.terzeron.grammar.iterator;

import java.util.Iterator;

/**
 * Created by terzeron on 2016. 9. 5..
 */
public class BasicStack<Item> implements Iterable<Item> {
    private final Item[] s;
    private int N;

    @SuppressWarnings("unchecked")
    public BasicStack() {
        final int CAPACITY = 1000;
        s = (Item[]) new Object[CAPACITY];
    }

    public Item pop() {
        Item item = s[--N];
        s[N] = null;

        return item;
    }

    public void push(Item item) {
        s[N++] = item;
    }

// --Commented out by Inspection START (2019-08-20 14:23):
//    public int size() {
//        return N;
//    }
// --Commented out by Inspection STOP (2019-08-20 14:23)

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return s[--i];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
