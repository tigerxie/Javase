package com.tiger.javase.pattern.consumer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerPattern {

	public static void main(String[] args) {
		
		// Creating shared object
		BlockingDeque shareQueue = new LinkedBlockingDeque();
		
		// Creating Producer and Consumer Thread
		Thread prodThread = new Thread(new Producer(shareQueue));
		Thread consThread = new Thread(new Consumer(shareQueue));
		
		//Starting producer and Consumer thread
		prodThread.start();
		consThread.start();
	}
}
