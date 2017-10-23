package net.terzeron.test.factorial;

import java.math.BigInteger;
import java.util.Vector;

public class Factorial3 {
	// Vector를 하나 생성하고 여기에 i!의 값을 저장한다. 
	protected static Vector<BigInteger> table = new Vector<BigInteger>();
	// 1!의 값인 1을 저장한다.
	static {
		table.addElement(BigInteger.valueOf(1));
	}

	public static synchronized BigInteger factorial(int x) {
		if (x < 0) 
			throw new IllegalArgumentException("x must be non-negative.");
		// x!에 대해서 x
		for (int size = table.size(); size <= x; size++) {
			// 이전값 lastfact에 x를 곱한 값을 nextfact에 저장한다.
			BigInteger lastfact = (BigInteger) table.elementAt(size - 1);
			BigInteger nextfact = lastfact.multiply(BigInteger.valueOf(size));
			table.addElement(nextfact);
		}
		return ((BigInteger) table.elementAt(x));
	}
}

// 이 알고리즘은 O(n^2)이므로 비효율적이다.








