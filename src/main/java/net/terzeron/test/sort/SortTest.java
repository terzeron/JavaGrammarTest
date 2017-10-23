package net.terzeron.test.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class SortTest {
	public static void main(String[] args) {
		List<HashMap<String, String>> arr = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> hm1 = new HashMap<String, String>();
		hm1.put("TheaterName", "world");
		arr.add(hm1);
		HashMap<String, String> hm2 = new HashMap<String, String>();
		hm2.put("TheaterName", "coffee");
		arr.add(hm2);
		HashMap<String, String> hm3 = new HashMap<String, String>();
		hm3.put("TheaterName", "java");
		arr.add(hm3);
		HashMap<String, String> hm4 = new HashMap<String, String>();
		hm4.put("TheaterName", "hello");
		arr.add(hm4);
		HashMap<String, String> hm5 = new HashMap<String, String>();
		hm5.put("TheaterName", "garbage");
		arr.add(hm5);
		
		Comparator<HashMap<String, String>> byTheaterName = new TheaterNameComparator();
		
		Collections.sort(arr, byTheaterName);
		
		for (HashMap<String, String> item : arr) { 
			System.out.println(item.get("TheaterName"));
		}
	}
}

class TheaterNameComparator implements Comparator<HashMap<String, String>> {
	public int compare(HashMap<String, String> a, HashMap<String, String> b) {
		return a.get("TheaterName").compareTo(b.get("TheaterName"));
	}
}
