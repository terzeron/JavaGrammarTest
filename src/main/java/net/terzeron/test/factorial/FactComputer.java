package net.terzeron.test.factorial;

public class FactComputer {
	public static void main(String[] args) {
		try {
			int x = 10000;
			System.out.println(x+"! = "+Factorial1.factorial(x));
			System.out.println(x+"! = "+Factorial2.factorial(x));
			System.out.println(x+"! = "+Factorial3.factorial(x));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("You must specify an argument");
			System.out.println("Usage : java FactComputer <number>");
		} catch (NumberFormatException e) {
			System.out.println("The argument you specify must be an integer.");
		} catch (IllegalArgumentException e) {
			System.out.println("Bad argument: " + e.getMessage());
		}
	}
}





