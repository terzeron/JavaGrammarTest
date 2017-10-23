package net.terzeron.test.fibonacci;

public class Fibonacci {
	public static void main(String[] args) {
		int current, prev = 1, prevprev = 0;

		for (int i = 0; i < 20; i++) {
			current = prev + prevprev;
			System.out.print(current + " ");
			prevprev = prev;
			prev = current;
		}
		System.out.println();
	}
}
