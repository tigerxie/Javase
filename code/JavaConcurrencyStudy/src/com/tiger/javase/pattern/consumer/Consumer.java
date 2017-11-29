package com.tiger.javase.pattern.consumer;

import java.util.concurrent.BlockingDeque;

public class Consumer implements Runnable {

	private final BlockingDeque shareQueue;

	public Consumer(BlockingDeque shareQueue) {
		this.shareQueue = shareQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consumed: " + shareQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
