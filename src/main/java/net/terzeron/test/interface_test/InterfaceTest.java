package net.terzeron.test.interface_test;

class Colored implements Colorable {
	private int color;
	public void setColor(int color) {
		this.color = color;
	}
	public int getColor() {
		return color;
	}
}

abstract class Colored2 implements Colorable {
	private int color;
	public void setColor(int color) {
		this.color = color;
	}
}

class InterfaceTest {
	public static void main(String args[]) {
		Colorable c = new Colored();
		c.setColor(Colorable.GREEN);
		System.out.println(c.getColor());
	}
}
