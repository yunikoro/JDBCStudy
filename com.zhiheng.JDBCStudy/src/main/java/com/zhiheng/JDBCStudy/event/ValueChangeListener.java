package com.zhiheng.JDBCStudy.event;

import java.util.EventListener;

public interface ValueChangeListener extends EventListener {
	public abstract void performed(ValueChangeEvent e);
}
