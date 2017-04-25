package com.zhiheng.JDBCStudy.concurrent;

public class SynchronizedCounter {
	private int c = 0;
	private volatile String lastName;
	
	
	public synchronized void increment() {
		c++;
	}
	
	public synchronized void decrement() {
		c--;
	}
	
	public synchronized int value() {
		return c;
	}
	
	public void addName(String name) {
		System.out.println(Thread.currentThread().getName() + "start addName");
		synchronized(this) {
			System.out.println(Thread.currentThread().getName());
			lastName = name;
			c++;
		}
		System.out.println(Thread.currentThread().getName() + "end addName");
	}
}
