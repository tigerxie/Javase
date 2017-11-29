package com.tiger.javase.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCacheThreadPool {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
//		ExecutorService executorService1 = Executors.newFixedThreadPool(10);
//		ExecutorService executorService2 = Executors.newScheduledThreadPool(10);
//		ExecutorService executorService3 = Executors.newSingleThreadExecutor();
		for (int i = 1; i <= 10; i++) {
			executorService.execute(new MyRunnable());
			System.out.println("********" + i + "********");
		}
		executorService.shutdown();
	}
}
