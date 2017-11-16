/*
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.  * The Copyright to the computer program(s) herein is the property of Ericsson AB, Sweden. 
 * The program(s) may be used and/or copied with the written permission from Ericsson AB 
 * or in accordance with the terms and conditions stipulated in the agreement/contract 
 * under which the program(s) have been supplied. 
 */
package com.ericsson.upg.concurrency.hashmap;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class IdentityHashMapTest {
	public static void main(String[] args) {
		
		Integer a = new Integer(123456);
		Integer b = new Integer(123456);
//		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
//		IdentityHashMap<Integer, Integer> identityHashMap = new IdentityHashMap<Integer, Integer>();
		IdentityHashMap<String, Integer> identityHashMap = new IdentityHashMap<String, Integer>();
//		hashMap.put(a, 1);
//		hashMap.put(b, 2);
//		identityHashMap.put(a, 1);
//		identityHashMap.put(b, 2);
//		System.out.println(hashMap);
//		System.out.println(identityHashMap);
		
		
//		identityHashMap.put("1", 1);
//		identityHashMap.put("1", 2);
		hashMap.put("1", 1);
		System.out.println(hashMap.put("1", 2));
		System.out.println(hashMap.get("1"));
		
//		System.out.println(identityHashMap);
//		System.out.println(identityHashMap.get("1"));
//		
//		System.out.println(hashMap);
//		System.out.println(hashMap.get("1"));
		
	}
}