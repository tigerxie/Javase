/*
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.  * The Copyright to the computer program(s) herein is the property of Ericsson AB, Sweden. 
 * The program(s) may be used and/or copied with the written permission from Ericsson AB 
 * or in accordance with the terms and conditions stipulated in the agreement/contract 
 * under which the program(s) have been supplied. 
 */
package com.tiger.javase.inner;

public class InnerClassDemo2 {
	public static void main(String[] args) {
		Outer2.Inner inner = new Outer2.Inner();
		inner.dostuff();
	}
}

class Outer2 {
	private static int size;

	static class Inner {
		public void dostuff() {
			size++;
			System.out.println("size=" + size);
		}
	}
}