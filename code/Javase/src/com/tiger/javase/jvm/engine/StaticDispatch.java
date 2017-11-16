package com.tiger.javase.jvm.engine;

public class StaticDispatch {

	static abstract class Human {

	}

	static class Man extends Human {

	}

	static class Woman extends Human {

	}

	public static void sayHello(Human human) {
		System.out.println("hi guys");
	}

	public static void sayHello(Man man) {
		System.out.println("hi man");
	}

	public static void sayHello(Woman woman) {
		System.out.println("hi girl");
	}

	public static void main(String[] args) {
		Human man = new Man();
		man = new Woman();
		Human woman = new Woman();
		sayHello(man);
		sayHello((Woman) woman);
	}
}
