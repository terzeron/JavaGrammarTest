package net.terzeron.test.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by terzeron on 2017. 5. 15..
 */
public class GenericsTest2 {
    class Animal {
        public String toString() {
            return "Animal";
        }
    }

    public static void main(String[] args) {
        List list = new ArrayList<Animal>();
        list.add(new Object());
        list.add("rere");
        list.add(1);

        // compile error
        /*
        for (Animal animal : list) {
            System.out.println(animal);
        }
        */

        List<Animal> list2 = new ArrayList();
        // compile error
        /*
        list2.add(new Object());
        list2.add("rere");
        list2.add(1);
        */
    }
}
