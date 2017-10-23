package net.terzeron.test.constructor;

class Circle {
	private double radius = 1;
	public Circle() {
		this(2);
		System.out.println("Circle()");
	}

	public Circle(double radius) {
		this.radius = radius;
		System.out.println("Circle(" + radius + ")");
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}
}

class ConsTest {
	public static void main(String args[]) {
		Circle circle1 = new Circle();
		System.out.println("area of circle1 with default radius: " + circle1.getArea());
		Circle circle2 = new Circle(3);
		System.out.println("area of circle2 with radius 3: " + circle2.getArea()); 
	}
}
