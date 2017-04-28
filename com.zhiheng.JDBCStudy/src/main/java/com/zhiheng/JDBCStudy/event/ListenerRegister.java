package com.zhiheng.JDBCStudy.event;

import java.util.Vector;

public class ListenerRegister {
	
	private Vector<ValueChangeListener> listeners;
	
	public synchronized void addListener(ValueChangeListener a) {
		listeners.add(a);
	}
	
	public synchronized void removeListener(ValueChangeListener a) {
		listeners.remove(a);
	}
	
	@SuppressWarnings("unchecked")
	public void fireAEvent(ValueChangeEvent evt) {
		Vector<ValueChangeListener> currentListeners = null;
		
		synchronized(this) {
			currentListeners = (Vector<ValueChangeListener>) listeners.clone();
		}
		for(int i = 0; i < currentListeners.size(); i++) {
			ValueChangeListener listener = (ValueChangeListener) currentListeners.elementAt(i);
			listener.performed(evt);
		}
	}
	
	public ListenerRegister() {
		this.listeners = new Vector<ValueChangeListener>();
	}
}
