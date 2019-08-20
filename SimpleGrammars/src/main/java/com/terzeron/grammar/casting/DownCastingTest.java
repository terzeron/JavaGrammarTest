package com.terzeron.grammar.casting;

/**
 * Created by terzeron on 2016. 8. 23..
 */
public class DownCastingTest {

    static class SuperClass {

    }

    static class SubClass extends SuperClass {
        public void method() {
            System.out.println("Subclass method called");
        }
    }

    public static void main(String[] args) {
        SuperClass superClass1 = new SuperClass();
        SuperClass superClass2 = new SubClass();

        // valid down com.terzeron.grammar.casting
        SubClass subClass1 = (SubClass) superClass2;
        subClass1.method();

        // invalid down com.terzeron.grammar.casting
        SubClass subClass2 = (SubClass) superClass1;
    }
}
