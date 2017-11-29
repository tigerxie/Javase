package com.tiger.javase.concurrency.series1and2;

public class MyThread2 implements Runnable {

	private int ticket = 5;
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (ticket > 0) {
				System.out.println("ticket2 = " + ticket--);
			}
		}
	}

}
