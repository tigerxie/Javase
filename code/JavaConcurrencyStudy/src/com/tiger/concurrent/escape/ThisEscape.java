package com.tiger.concurrent.escape;

public class ThisEscape {

	private int weight = 0;

	public ThisEscape() {
		new Thread(new InnerThread()).start();
		weight = 1;
		for (long i = 0; i < 100000000; i++) {

		}
		weight = 10;
	}

	private class InnerThread implements Runnable {

		@Override
		public void run() {
			System.out.println("weight=" + ThisEscape.this.weight);
		}
	}

	public static void main(String[] args) {
		new ThisEscape();
	}
}
