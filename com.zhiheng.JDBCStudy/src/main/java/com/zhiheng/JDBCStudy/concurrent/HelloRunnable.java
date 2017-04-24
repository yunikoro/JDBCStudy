package com.zhiheng.JDBCStudy.concurrent;

public class HelloRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("runnable");
		String importantInfo[] = {"Mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will eat ivy too"};
		
	}
}

