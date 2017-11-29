/*
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.  * The Copyright to the computer program(s) herein is the property of Ericsson AB, Sweden. 
 * The program(s) may be used and/or copied with the written permission from Ericsson AB 
 * or in accordance with the terms and conditions stipulated in the agreement/contract 
 * under which the program(s) have been supplied. 
 */
package com.tiger.javase.threadlocal;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
	static class ThreadLocalVariableHolder {
		private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
			private Random random = new Random();

			protected synchronized Integer initialValue() {
				return random.nextInt(10000);
			}
		};

		public static void increment() {
			value.set(value.get() + 1);
		}

		public static int get() {
			return value.get();
		}
	}

	static class Accessor implements Runnable {
		private final int id;

		public Accessor(int id) {
			this.id = id;
		}

		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println(this);
				ThreadLocalVariableHolder.increment();
				System.out.println(this);
				Thread.yield();
			}
		}

		@Override
		public String toString() {
			return "#" + id + ": " + ThreadLocalVariableHolder.get();
		}

	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			executorService.execute(new Accessor(i));
		}
		try {
			TimeUnit.MICROSECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.shutdownNow();
	}

}