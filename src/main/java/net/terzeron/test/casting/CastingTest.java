package net.terzeron.test.casting;

public class CastingTest {
	public static void main(String args[]) {
		int i = 99999;
		System.out.println("i=" + i);
		//short s = i;
		short s = (short) i;
		System.out.println("s=" + s);

		float f = 0.5f;
		System.out.println("f=" + f);
		double d = 0.5;
		System.out.println("d=" + d);
		d = f;
		System.out.println("d=" + d);
		// f = d; // error

		boolean b = true;
		System.out.println("b=" + b);
		// b = 1; // error
		
		byte by = 103;
		System.out.println("by='" + (char) by + "'");
		by = 'a';
		System.out.println("by='" + (char) by + "'");
	}
}
