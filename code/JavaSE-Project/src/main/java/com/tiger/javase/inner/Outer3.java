/*
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.  * The Copyright to the computer program(s) herein is the property of Ericsson AB, Sweden. 
 * The program(s) may be used and/or copied with the written permission from Ericsson AB 
 * or in accordance with the terms and conditions stipulated in the agreement/contract 
 * under which the program(s) have been supplied. 
 */
package com.tiger.javase.inner;

public class Outer3 {
	public static final int TOTAL_NUMBER = 5;
	public int id = 123;

	public void func() {
		final int age = 15;
		String str = "http://www.weixueyuan.net";
		class Inner {
			public void innerTest() {
				System.out.println(TOTAL_NUMBER);
				System.out.println(id);
				// System.out.println(str);?????????????final??
				System.out.println(age);
			}
		}
		new Inner().innerTest();
	}

	public static void main(String[] args) {
		Outer3 outer = new Outer3();
		outer.func();
	}
}