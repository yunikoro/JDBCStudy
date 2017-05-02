package com.zhiheng.JDBCStudy.concurrent;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Safelock {
	static class Friend {
		private final String name;
		private final Lock lock = new ReentrantLock();
		
		public String getName() {
			return this.name;
		}
		
		public boolean impendingBow(Friend bower) {
			Boolean myLock = false;
			Boolean yourLock = false;
			
			try {
				myLock = lock.tryLock();
				yourLock = bower.lock.tryLock();
			} finally {
				if(! (myLock && yourLock)) {
					if(myLock) {
						lock.unlock();
					}
					if(yourLock) {
						bower.lock.unlock();
					}
				}
			}
			return myLock && yourLock;
		}
		
		public void bow(Friend bower) {
			if(impendingBow(bower)) {
				try {
					System.out.format("%s: %s has bowed to me!%n", this.name, bower.getName());
				} finally {
					lock.unlock();
					bower.lock.unlock();
				}
			} else {
				System.out.format("%s: %s started to bow to me, but saw that I was already bowing to him.%n", this.name, bower.getName());
			}
		}
		
		static class BowLoop implements Runnable {
			private Friend bower;
			private Friend bowee;
			
			@Override
			public void run() {
				Random random = new Random();
				for(;;) {
					try {
						Thread.sleep(random.nextInt(10));
					} catch (InterruptedException e) {
						
					}
					bowee.bow(bower);
				}
			}
			
			public BowLoop(Friend bower, Friend bowee) {
				this.bower = bower;
				this.bowee = bowee;
			}
		}
		
		public Friend(String name) {
			this.name = name;
		}
	}
	
	public static void main(String[] args) {
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");
		
		Thread thread1 = new Thread(new BowLoop(alphonse, gaston));
		Thread thread2 = new Thread(new BowLoop(gaston, alphonse));
		thread1.setName("T1");
		thread2.setName("T2");
		thread1.start();
		thread2.start();
		
	}
}
