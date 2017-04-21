package com.zhiheng.JDBCStudy.concurrent;

public class HelloRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("runnable");
	}
}

