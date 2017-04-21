package com.zhiheng.JDBCStudy.concurrent;

public class HelloThread extends Thread {

	@Override
	public void run() {
		super.run();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println("I'm interrupt");
			e.printStackTrace();
		}
		
		System.out.println("This is a thread");
	}

}