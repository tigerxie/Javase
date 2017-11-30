package com.tiger.javase.test;

public class Test1 {
	private static int x = 100;

	public static void main(String args[]) {
		Test1 hs1 = new Test1();
		hs1.x++;
		Test1 hs2 = new Test1();
		hs2.x++;

		hs1 = new Test1();
		hs1.x++;

		Test1.x--;
		
		System.out.println("x=" + x);
		System.out.println(new Test1().hashCode());
		System.out.println(new Test1().hashCode());
		System.out.println(new Test1().hashCode());
		System.out.println(new Test1().toString());
		System.out.println(new Test1().toString());
		System.out.println(new Test1() == new Test1());
		System.out.println(new Test1().equals(new Test1()));
	}
}
