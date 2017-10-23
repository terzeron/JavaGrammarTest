package net.terzeron.test.factorial;

import java.math.BigInteger;

public class Factorial2 {
	public static BigInteger factorial(int x) {
		if (x == 1) 
			return BigInteger.valueOf(1);
		else
			return factorial(x - 1).multiply(BigInteger.valueOf(x));
	}
}
