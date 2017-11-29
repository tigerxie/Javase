package com.tiger.javase.pattern.consumer;

import java.util.concurrent.BlockingDeque;

public class Producer implements Runnable {

	private final BlockingDeque sharedQueue;

	public Producer(BlockingDeque shareQueue) {
		this.sharedQueue = shareQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Produced: " + i);
			try {
				sharedQueue.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
