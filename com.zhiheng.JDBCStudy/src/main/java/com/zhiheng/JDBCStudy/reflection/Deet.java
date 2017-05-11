package com.zhiheng.JDBCStudy.reflection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import static java.lang.System.out;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import static java.lang.System.err;

public class Deet<T> {

	private boolean testDeet(Locale l) {
		out.format("Locale = %s, ISO Language Code = %s%n", l.getDisplayName(), l.getISO3Country());
		return true;
	}
	
	private int testFoo(Locale l) {
		return 0;
	}
	
	private boolean testbar() {
		return true;
	}
	
	public static void main(String[] args) {
		if(args.length != 4) {
			err.format("Usage: java Deet <classname> <language> <country> variant%n");
			return;
		}
		
		try {
			Class<?> c = Class.forName(args[0]);
			Object t = c.newInstance();
			
			Method[] allMethods = c.getDeclaredMethods();
			for (Method m : allMethods) {
				String mname = m.getName();
				if(!mname.startsWith("test") || m.getGenericReturnType() != boolean.class)
					continue;
				Type[] pType = m.getGenericParameterTypes();
				if((pType.length != 1) || Locale.class.isAssignableFrom(pType[0].getClass())) {
					continue;
				}
				List.class.isAssignableFrom(ArrayList.class);
				out.format("invoking %s()%n", mname);
				try {
					m.setAccessible(true);
					Object o = m.invoke(t, new Locale(args[1], args[2], args[3]));
					out.format("%s() return %b%n", mname, (Boolean) o);
				} catch (InvocationTargetException e) {
					Throwable cause = e.getCause();
					err.format("invocation of %s failed: %s%n", mname, cause.getMessage());
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
