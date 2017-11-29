package com.tiger.javase.concurrency.series3;

public class DeprecatedSuspendResume implements Runnable {

	private volatile int firstVal;
	private volatile int secondVal;

	public boolean areValuesEqual() {
		return (firstVal == secondVal);
	}

	public void run() {
		try {
			firstVal = 0;
			secondVal = 0;
			workMethod();
		} catch (InterruptedException x) {
			System.out.println("interrupted while in workMethod()");
		}
	}

	private void workMethod() throws InterruptedException {
		int val = 1;
		while (true) {
			stepOne(val);
			stepTwo(val);
			val++;
			Thread.sleep(200);
		}
	}

	private void stepOne(int newVal) throws InterruptedException {
		firstVal = newVal;
		Thread.sleep(300);
	}

	private void stepTwo(int newVal) {
		secondVal = newVal;
	}

	public static void main(String[] args) {
		DeprecatedSuspendResume dsr = new DeprecatedSuspendResume();
		Thread t = new Thread(dsr);
		t.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException x) {
		}
		for (int i = 0; i < 10; i++) {

			t.suspend();

			System.out.println("dsr.areValuesEqual()=" + dsr.areValuesEqual());

			t.resume();

			try {
				Thread.sleep((long) (Math.random() * 2000.0));
			} catch (InterruptedException x) {
			}
		}
		System.exit(0);
	}
}
