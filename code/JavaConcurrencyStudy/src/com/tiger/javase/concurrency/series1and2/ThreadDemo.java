package com.tiger.javase.concurrency.series1and2;

public class ThreadDemo {

	public static void main(String[] args) {
//		new MyThread().start();
//		new MyThread().start();
//		new MyThread().start();
		
		MyThread2 myThread2 = new MyThread2();
		new Thread(myThread2).start();
		new Thread(myThread2).start();
		new Thread(myThread2).start();
	}
}
