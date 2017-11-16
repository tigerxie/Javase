package com.ericsson.upg.pattern.consumer.waitnotify;

import java.util.LinkedList;

public class Storage {

	private final int MAX_SIZE = 100;

	private LinkedList<Object> list = new LinkedList<Object>();

	public void produce(int num) {
		synchronized (list) {
			while (list.size() + num > MAX_SIZE) {
				System.out.println("producer num: " + num + "list.zie: " + list.size() + "/t don't produce ");
				try {
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			for (int i = 1; i < num; i++) {
				list.add(new Object());
			}
			System.out.println("produced num: " + num + "store num: " + list.size());
			
			list.notifyAll();
		}
	}

	public void consume(int num) {
		synchronized (list) {
			while ( num > list.size()) {
				System.out.println("consumer num: " + num + "list.zie: " + list.size() + "/t don't consum ");
				try {
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			for (int i = 1; i < num; i++) {
				list.remove();
			}
			System.out.println("produced num: " + num + "store num: " + list.size());
			
			list.notifyAll();
		}
	}

	public LinkedList<Object> getList() {
		return list;
	}

	public void setList(LinkedList<Object> list) {
		this.list = list;
	}

	public int getMAX_SIZE() {
		return MAX_SIZE;
	}
}
