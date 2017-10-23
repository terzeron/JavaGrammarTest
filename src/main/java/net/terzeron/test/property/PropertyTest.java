package net.terzeron.test.property;

import java.util.*;

public class PropertyTest {
	public static void main(String args[]) {
		Properties p = System.getProperties();
		Enumeration<String> e = (Enumeration<String>) p.propertyNames();
		String key;
		while (e.hasMoreElements()) {
			key = (String) e.nextElement();
			System.out.println(key + ":::" + System.getProperty(key));
		}
	}
}