package com.tiger.javase.jvm.clinit;

public class DeadLoopClass {

	static class DeadLoop {
		static {
			if (true) {
				System.out.println(Thread.currentThread() + "init DeadLoop");
				while (true) {
				}
			}
		}
	}

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread() + "start");
				new DeadLoop();
				System.out.println(Thread.currentThread() + "end");
			}
		};
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		thread1.start();
		thread2.start();
	}
}
