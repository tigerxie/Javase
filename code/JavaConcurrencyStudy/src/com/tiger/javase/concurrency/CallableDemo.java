package com.tiger.javase.concurrency;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		ArrayList<Future<String>> arrayResult = new ArrayList<Future<String>>();
		
		for (int i = 0; i < 5; i++) {
			Future<String> result =  executorService.submit(new TaskWithResult(i));
			arrayResult.add(result);
		}
		
		for (Future<String> future : arrayResult) {
			try {
				while (!future.isDone());
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				executorService.shutdown();
			}
		}
	}
}
