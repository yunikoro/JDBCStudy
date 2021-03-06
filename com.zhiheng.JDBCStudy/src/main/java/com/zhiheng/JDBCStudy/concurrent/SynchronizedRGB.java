package com.zhiheng.JDBCStudy.concurrent;

public class SynchronizedRGB {
	private int red;
	private int green;
	private int blue;
	private String name;
	
	private void check(int red, int green, int blue) {
		if(red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
			throw new IllegalArgumentException();
		}
	}
	
	void set(int red, int green, int blue, String name) {
		check(red, green, blue);
		synchronized (this) {
			this.red = red;
			this.green = green;
			this.blue = blue;
			this.name = name;
		}
	}
	
	public synchronized int getRGB() {
		return ((red << 16) | (green << 8) | blue);
	}
	
	public synchronized String getName() {
		return name;
	}
	
	public synchronized void invert() {
		red = 255 - red;
		green = 255 - green;
		blue = 255 - blue;
		name = "inverse of " + name;
	}
	
	public SynchronizedRGB(int red, int green, int blue, String name) {
		check(red, green, blue);
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.name = name;
	}
	
}
