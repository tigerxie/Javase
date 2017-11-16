package com.tiger.javase.jvm.clinit;

public class TestClinit {
	static class Super {
		static int i = 1;
		static {
			i = 2;
		}
	}

	static class Sub extends Super {
		static int A = i;
	}

	public static void main(String[] args) {
		System.out.println(Sub.A);
	}
}
