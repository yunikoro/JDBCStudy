package com.zhiheng.JDBCStudy.event;

import java.util.EventObject;

public class ValueChangeEvent extends EventObject {
	
	private int value;
	
	public ValueChangeEvent(Object source) {
		this(source, 0);
	}
	
	public ValueChangeEvent(Object source, int newValue) {
		super(source);
		this.value = newValue;
	}
	
	public int getValue() {
		return value;
	}
}
