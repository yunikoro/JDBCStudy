package com.zhiheng.JDBCStudy.concurrent;

import java.util.Random;

public class Producer implements Runnable {
	
	private Drop drop;
	
	public Producer(Drop drop) {
		this.drop = drop;
	}
	
	@Override
	public void run() {
		String[] importantInfo = {"mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will eat ivy too"};
		Random random = new Random();
		
		for(int i = 0; i < importantInfo.length; i++) {
			drop.put(importantInfo[i]);
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				
			}
		}
		drop.put("DONE");
	}

}
