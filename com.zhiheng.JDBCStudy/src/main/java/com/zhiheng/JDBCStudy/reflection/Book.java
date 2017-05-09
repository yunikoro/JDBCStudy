package com.zhiheng.JDBCStudy.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;

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
			Field[] clses = c.getDeclaredFields();
			for (Field field : clses) {
				System.out.println(field.getName());
			}
			Field chap = c.getDeclaredField("chapters");
			out.format(fmt, "before", "chapters", chap.getLong(book));
			chap.setLong(book, 12);
			//System.out.println(chap.getType().getName());
			out.format(fmt, "after", "chapters", chap.getLong(book));
			
			Field chars = c.getDeclaredField("characters");
			out.format(fmt, "before", "characters", Arrays.asList(book.characters));
			String[] newChars = {"Queen", "King"};
			chars.set(book, newChars);
			out.format(fmt, "after", "characters", Arrays.asList(book.characters));
			
			Field t = c.getDeclaredField("twin");
			out.format(fmt, "before", "twin", book.twin);
			t.set(book, Tweedle.DUM);
			out.format(fmt, "after", "twin", t.get(book));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
