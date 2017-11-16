package com.tiger.javase.jvm.classloader;

import java.util.Hashtable;

public class Init {
	static int i = 1;
	static {
		System.out.println(i);
		i = 2;
		System.out.println(i);
	}

	public static void main(String[] args) {
		new Hashtable<>();
		System.out.println(i);
	}

}
