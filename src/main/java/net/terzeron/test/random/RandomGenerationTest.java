package net.terzeron.test.random;

import java.util.Random;

public class RandomGenerationTest {

	public static void main(String args[]) {
		int number;
		int check[] = new int[8];
		Random slot = new Random();

		for (int i = 0; i < 10000; i++) {
			number = (int) (java.lang.Math.abs(slot.nextInt())%6+1);
			System.out.print(number + " ");
			check[number]++;
		}

		System.out.println("");

		for (int i = 0; i < 8; i++) {
			System.out.println(i + "th count : " + check[i]);
		}
	}
}




