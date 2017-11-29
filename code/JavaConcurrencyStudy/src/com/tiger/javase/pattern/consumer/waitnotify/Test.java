package com.tiger.javase.pattern.consumer.waitnotify;

public class Test {
	 public static void main(String[] args)  
	    {  
	        Storage storage = new Storage();  
	  
	        Producer p1 = new Producer(storage);  
	        Producer p2 = new Producer(storage);  
	        Producer p3 = new Producer(storage);  
	        Producer p4 = new Producer(storage);  
	        Producer p5 = new Producer(storage);  
	        Producer p6 = new Producer(storage);  
	        Producer p7 = new Producer(storage);  
	  
	        Consumer c1 = new Consumer(storage);  
	        Consumer c2 = new Consumer(storage);  
	        Consumer c3 = new Consumer(storage);  
	  
	        p1.setNum(10);  
	        p2.setNum(10);  
	        p3.setNum(10);  
	        p4.setNum(10);  
	        p5.setNum(10);  
	        p6.setNum(10);  
	        p7.setNum(80);  
	  
	        c1.setNum(50);  
	        c2.setNum(20);  
	        c3.setNum(30);  
	  
	        c1.start();  
	        c2.start();  
	        c3.start();  
	        p1.start();  
	        p2.start();  
	        p3.start();  
	        p4.start();  
	        p5.start();  
	        p6.start();  
	        p7.start();  
	    }  
}
