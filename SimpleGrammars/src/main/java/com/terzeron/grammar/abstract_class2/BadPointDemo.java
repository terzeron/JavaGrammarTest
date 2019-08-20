package com.terzeron.grammar.abstract_class2;

public class BadPointDemo {

    public static void main(String[] args) {
        CheckedPoint checkedPoint = new CheckedPoint();
        try {
            checkedPoint.move(10, 10);
        } catch (BadPointException e) {

        }
        System.out.println(checkedPoint.x);
    }
}
