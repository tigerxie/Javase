package com.tiger.java.study;

public class Test {
		private static int x = 100;

		public static void main(String args[]) {
			Test hs1 = new Test();
			hs1.x++;
			Test hs2 = new Test();
			hs2.x++;
			hs1 = new Test();
			hs1.x++;
			Test.x--;
			System.out.println("x=" + x);
		}
}
