package com.tiger.javase.container;

import java.util.LinkedHashMap;
import java.util.Map;

public class TreeMapTest {

	public static void main(String[] args) {
		// Map<Integer, Integer> map1 = new TreeMap<>();
		Map<Integer, Integer> map1 = new LinkedHashMap<Integer, Integer>();
		map1.put(1, 1);
		map1.put(2, 2);
		map1.put(5, 5);
		map1.put(4, 4);
		map1.put(3, 3);
		for (Integer integer : map1.keySet()) {

			System.out.println(map1.get(integer));
		}

		// Map<String, String> map2 = new TreeMap<>();
		Map<String, String> map2 = new LinkedHashMap<>();
		map2.put("b", "bb");
		map2.put("d", "dd");
		map2.put("a", "aa");
		map2.put("c", "cc");
		map2.put("e", "ee");
		for (String string : map2.keySet()) {
			System.out.println(map2.get(string));
		}
	}
}
