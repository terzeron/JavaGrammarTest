package net.terzeron.test.nested_class;

public class NestedClassTest {
	private int val = 3;
	private static int outerVal = 5;

	static class StaticNestedClass {
		static int getStaticVal() {
			return outerVal;
		}
	}
	class InnerClass {
		int getVal() {
			return val;
		}
		int getStaticVal() {
			return outerVal;
		}
	}
	public InnerClass getInner() {
		return new InnerClass();
	}

	public static void main(String args[]) {
		NestedClassTest a = new NestedClassTest();
		StaticNestedClass n1 = new StaticNestedClass();
		InnerClass n2 = a.getInner();

		System.out.println(StaticNestedClass.getStaticVal());
		System.out.println(n1.getStaticVal());
		System.out.println(n2.getStaticVal());
	}
}
