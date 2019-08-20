package com.terzeron.grammar.vector;

import java.util.Vector;

class VectorTest {
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        Vector<String>[] A = new Vector[3];
        Vector<String> B = new Vector<>();
        String y = "hello";

        for (int i = 0; i < 3; i++) {
            String x = y + "." + i;
            System.out.println("x is : " + x);
            A[i] = new Vector<>();
            B.add(x);
            A[i].add(x);

            System.out.println("Index of " + x + " in B : " +
                    B.indexOf(x));
            System.out.println("New element into B : " +
                    B.elementAt(B.indexOf(x)));
            System.out.println("Index of " + x + " in A[" + i + "] : " +
                    A[i].indexOf(x));
            System.out.println("New element into A : " +
                    A[i].elementAt(A[i].indexOf(x)));
        }
        String z = "grammar";
        B.add(z);
        System.out.println();
        System.out.println("Add element into B : " +
                B.elementAt(B.indexOf(z)));
        System.out.println("Capacity of B : " + B.capacity());
        System.out.println("Last index of B : " + B.indexOf(B.lastElement()));

    }
}

