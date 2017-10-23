package net.terzeron.test.generics;

/**
 * Created by terzeron on 2016. 8. 23..
 */
public class GenericsTest1 {
    <T extends Number> GenericsTest1(T value) {
        if (value instanceof Integer) {
            System.out.println("Integer value: " + value);
        }
        if (value instanceof Float) {
            System.out.println("Float value: " + value);
        }
        if (value instanceof Double) {
            System.out.println("Double value: " + value);
        }
        if (value instanceof Long) {
            System.out.println("Long value: " + value);
        }
    }

    public static void main(String[] args) {
        GenericsTest1 genericTest = new GenericsTest1(12);
        genericTest = new GenericsTest1(12.0F);
        genericTest = new GenericsTest1(12.0);
        genericTest = new GenericsTest1(12L);
    }
}
