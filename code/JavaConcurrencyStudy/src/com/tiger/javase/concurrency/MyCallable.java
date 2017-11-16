package com.ericsson.upg.concurrency;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {

	private int flag = 0 ;
	
	public MyCallable(int flag) {
		this.flag = flag;
	}

	@Override
	public Object call() throws Exception {
		
		if (flag == 0) {
			return "flag=0";
		}
		
		if (flag == 1) {
			while (true) {
				try {
					System.out.print("looping ...");
					Thread.sleep(2000);
				} catch (InterruptedException ie) {
					throw ie;
				}
			}
		} else {
			throw new Exception("invalidate");
		}
	}
	
}