package com.terzeron.grammar.generics;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by terzeron on 2017. 5. 15..
 */
public class GenericsTest2 {
    @NoArgsConstructor
    private static class Animal {
        public String toString() {
            return "Animal";
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List list = new ArrayList<Animal>();
        list.add(new Object());
        list.add("lion");
        list.add(1);

        // compile error
        /*
        for (Animal animal : list) {
            System.out.println(animal);
        }
        */
        for (Object obj : list) {
            System.out.println(obj);
        }

        List<Animal> list2 = new ArrayList<>();
        // compile error
        /*
        list2.add(new Object());
        list2.add("lion");
        list2.add(1);
        */
        list2.add(new Animal());
    }
}
