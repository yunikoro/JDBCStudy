package com.zhiheng.JDBCStudy.reflection;

import java.lang.reflect.Field;
import static java.lang.System.out;

enum Tweedle {DEE, DUM}

public class Book {

	public long chapters = 0;
	public String[] characters = {"Alice", "White Rabbit"};
	public Tweedle twin = Tweedle.DEE;
	
	public static void main(String[] args) {
		Book book = new Book();
		String fmt = "%6S:  %-12s = %s%n";
		
		try {
			Class<?> c = book.getClass();
			
			Field chap = c.getDeclaredField("chapters");
			out.format(fmt, "before", "chapters", chap.getLong(book));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
