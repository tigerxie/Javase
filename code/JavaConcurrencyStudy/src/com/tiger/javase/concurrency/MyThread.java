package com.tiger.javase.concurrency;

public class MyThread implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is excuting");   
        try{   
            Thread.sleep(100);   
        }catch(InterruptedException e){   
            e.printStackTrace();   
        }   
	}
}
