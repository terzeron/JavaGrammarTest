package com.terzeron.grammar.lambda;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionTest {
    @Test
    public void testMakeCollections() {
        Set<Integer> integers = Set.of(2, 6, 7, 10);
        System.out.println(integers);
        
        List<Integer> integers2 = List.of(2, 6, 7, 10);
        System.out.println(integers2);

        Map<Integer, String> map = Map.of(2, "two", 6, "six");
        System.out.println(map);

        Map<Integer, String> map2 = Map.ofEntries(Map.entry(2, "two"), Map.entry(4, "four"));
        System.out.println(map2);

        int[] ints1 = {1,3,5,7,9};
        int[] ints2 = {1,3,5,6,7};
        int i = Arrays.mismatch(ints1, ints2);
        System.out.println(i);

        int[] arrayA = {-2, 1, 3, 5, 7, 9};
        int[] arrayB = {-1, 0, 1, 3, 5, 7, 10};
        int j = Arrays.mismatch(arrayA, 1, arrayA.length, arrayB, 2, arrayB.length);
        System.out.println(j);

        String[] strA = {"one", "two"};
        String[] strB = {"four", "three"};
        int i2 = Arrays.compare(strA, strB);
        System.out.println(i2);

        List<String[]> list = Arrays.asList(strA, strB);
        System.out.println("before: ");
        list.forEach(a -> System.out.print(Arrays.toString(a)));
        Collections.sort(list, Arrays::compare);
        System.out.println("\nafter: ");
        list.forEach(a -> System.out.print(Arrays.toString(a)));
        System.out.println("");

        String[] sa = {"d", "e", "f", "g", "h"};
        String[] sb = {"a", "b", "c", "d", "e", "f"};
        boolean b = Arrays.equals(sa, 0, 2, sb, 3, 5);
        System.out.println(b);

        Vector<Integer> vec = new Vector<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(vec);
        Enumeration<Integer> en = vec.elements();
        System.out.println(en);
        Iterator<Integer> iterator = en.asIterator();
        System.out.println(iterator);
        iterator.forEachRemaining(System.out::println);
    }
}
