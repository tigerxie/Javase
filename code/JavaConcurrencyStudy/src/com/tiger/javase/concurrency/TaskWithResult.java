package com.ericsson.upg.concurrency;

import java.util.concurrent.Callable;

@SuppressWarnings("rawtypes")
public class TaskWithResult implements Callable {

	private int id = 0;

	public TaskWithResult(int id) {
		this.id = id;
	}

	@Override
	public Object call() throws Exception {
		
		System.out.println(Thread.currentThread().getName() + " call ");
		
		return Thread.currentThread().getName() + " id is " + id;
	}
}
