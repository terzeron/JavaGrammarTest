package net.terzeron.test.thread2;

class Test {
	private String x;
	
	public Test(String x) {
		this.x = x;
		System.out.println(x);
	}
}

public class ThreadTest2 extends Thread {
	public void run() {
		Test a = new Test("a");
		Test b = new Test("b");
		Test c = new Test("c");
		Test d = new Test("d");

		//System.out.println("start...");
		//a.start();
		//b.start();
		//c.start();
		//d.start();
	}


	public static void main(String args[]) {
		ThreadTest2 tt = new ThreadTest2();

		tt.start();
	}
}












