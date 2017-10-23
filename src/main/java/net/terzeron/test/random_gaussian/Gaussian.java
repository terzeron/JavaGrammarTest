package net.terzeron.test.random_gaussian;

import java.util.Random;

public class Gaussian {
	public static void main(String args[]) {
		double y;
		Random slot = new Random();
		int count = 0;

		for (int i = 0; i < 100; i++) {
			y = slot.nextGaussian();
			if (y > 6 || y < 0) 
				continue;
			System.out.println((y+3) + " ");
			count++;
		}
		System.out.println(count + " Gaussian random numbers");
	}
}

