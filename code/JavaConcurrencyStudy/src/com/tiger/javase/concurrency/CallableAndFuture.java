package com.tiger.javase.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class CallableAndFuture {

	public static void main(String[] args) {
		MyCallable myCallable0 = new MyCallable(0);
		MyCallable myCallable1 = new MyCallable(1);
		MyCallable myCallable2 = new MyCallable(2);
		
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		try {
			Future future0 = executorService.submit(myCallable0);
			System.out.println("task0: " + future0.get());
			executorService.shutdownNow();
			
			Future future1 = executorService.submit(myCallable1);
			Thread.sleep(5000);
			System.out.println("task1: " + future1.cancel(true));
			
			Future future2 = executorService.submit(myCallable2);
			System.out.println("task2: " + future2.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
