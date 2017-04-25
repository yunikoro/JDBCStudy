package com.zhiheng.JDBCStudy.event;

/**
 * http://blog.csdn.net/teamlet/article/details/42618733
 * @author cohuang
 *
 */

public class EventConsumer implements ValueChangeListener {

	@Override
	public void performed(ValueChangeEvent e) {
		System.out.println("value chagned, new value = " + e.getValue());
	}

}
