package net.terzeron.test.equality;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EqualityTest {
	private static boolean hashContains(HashSet<Point> coll, Point p) {
		boolean containedP = false;
		
		Iterator<Point> it = coll.iterator();
		while (it.hasNext()) {
			Point nextP = it.next();
			if (nextP.equals(p)) {
				containedP = true;
				System.out.println("nextP=(" + nextP.getX() + ", " + nextP.getY() + "), p=(" + p.getX() + ", " + p.getY() + ")");
				break;
			}
		}
		
		return containedP;
	}

	public static void main(String[] args) {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(1, 2);
		
		Point q = new Point(2, 3);
		
		System.out.println(p1.equals(p2)); // true
		System.out.println(p1.equals(q)); // false
		
		System.out.println("");
		
		HashSet<Point> coll = new HashSet<Point>();
		coll.add(p1);
		System.out.println(coll.contains(p2));  // true due to overriding equals() method and hashCode() method
		
		p1.setX(p1.getX() + 1);
		System.out.println(coll.contains(p1)); // false ... 당연함. true가 되게 하려면 다시 add해야 함
		System.out.println(hashContains(coll, p1)); // true 
		
		System.out.println("");
		
		Point p = new Point(1, 2);
		ColoredPoint cp = new ColoredPoint(1, 2, Color.RED);
		System.out.println(p.equals(cp)); // true
		System.out.println(cp.equals(p)); // false 
		
		System.out.println("");
		
		Set<Point> hashSet1 = new HashSet<Point>();
		hashSet1.add(p);
		System.out.println(hashSet1.contains(cp)); // false
		
		Set<Point> hashSet2 = new HashSet<Point>();
		hashSet2.add(cp);
		System.out.println(hashSet2.contains(p)); // true
		
	}
}
