package net.terzeron.test.iterator;

import java.util.Iterator;

/**
 * Created by terzeron on 2016. 9. 5..
 */
public class BasicStack<Item> implements Iterable<Item> {
    public final int CAPACITY = 1000;
    private Item s[];
    private int N;

    public BasicStack() {
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

    public int size() {
        return N;
    }

    public Iterator iterator() {
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
