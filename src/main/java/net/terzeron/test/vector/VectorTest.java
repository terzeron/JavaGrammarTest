package net.terzeron.test.vector;

import java.lang.String;	
import java.util.Vector;	

class VectorTest {
	public static void main(String args[]) {
		Vector<String> A[] = new Vector[3];
		Vector<String> B = new Vector<String>();
		String y = new String("hello");

		for (int i = 0; i < 3; i++) {
			String x = new String(y + "." + i);
			A[i] = new Vector();
			System.out.println("x is : " + x);
			B.addElement(x);
			A[i].addElement(x);
			System.out.println("Index of " + x + " in B : " + 
					B.indexOf(x));
			System.out.println("New element into B : " + 
					B.elementAt(B.indexOf(x)));
			System.out.println("Index of " + x + " in A[" + i + "] : "+ 
					A[i].indexOf(x));
			System.out.println("New element into A : " + 
					A[i].elementAt(A[i].indexOf(x)));
		}
		String z = "test";
		B.addElement(z);
		System.out.println("");
		System.out.println("Add element into B : " + 
				B.elementAt(B.indexOf(z)));
		System.out.println("Capacity of B : " + B.capacity());
		System.out.println("Last index of B : " + B.indexOf(B.lastElement()));

	}
}

