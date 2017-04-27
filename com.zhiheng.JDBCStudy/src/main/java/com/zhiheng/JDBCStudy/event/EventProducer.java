package com.zhiheng.JDBCStudy.event;

public class EventProducer {
	private ListenerRegister register;
	private int value;
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int newValue) {
		if(value != newValue) {
			value = newValue;
			ValueChangeEvent event = new ValueChangeEvent(this, value);
			fireAEvent(event);
		}
	}
	
	public void addListener(ValueChangeListener a) {
		register.addListener(a);
	}
	
	public void removeListener(ValueChangeListener a) {
		register.removeListener(a);
	}
	
	public void fireAEvent(ValueChangeEvent event) {
		register.fireAEvent(event);
	}
	
	public EventProducer() {
		this.register = new ListenerRegister();
	} 
}
