package net.terzeron.test.factorial;

import java.math.BigInteger;

public class Factorial1 {
	public static BigInteger factorial(int x) {
		BigInteger fact = BigInteger.valueOf(1);
		for (int i = 2; i <= x; i++)
			fact = fact.multiply(BigInteger.valueOf(i));
		return fact;
	}
}
