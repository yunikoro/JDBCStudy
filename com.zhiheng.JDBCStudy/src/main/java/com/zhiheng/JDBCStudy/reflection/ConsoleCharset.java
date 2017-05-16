package com.zhiheng.JDBCStudy.reflection;

import java.io.Console;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

import static java.lang.System.out;

public class ConsoleCharset {
	public static void main(String[] args) {
		Constructor[] ctors = Console.class.getDeclaredConstructors();
		Constructor ctor = null;
		for(int i = 0; i < ctors.length; i++) {
			ctor = ctors[i];
			if(ctor.getGenericParameterTypes().length == 0) {
				break;
			}
		}
		
		try {
			ctor.setAccessible(true);
			Console c = (Console)ctor.newInstance();
			Field f = c.getClass().getDeclaredField("cs");
			f.setAccessible(true);
			out.format("Console charset         : %s%n", f.get(c));
			out.format("Charset.defaultCharset(): %s%n", Charset.defaultCharset());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
