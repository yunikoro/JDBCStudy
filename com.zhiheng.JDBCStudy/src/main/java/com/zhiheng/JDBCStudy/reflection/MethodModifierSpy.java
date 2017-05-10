package com.zhiheng.JDBCStudy.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static java.lang.System.out;

public class MethodModifierSpy {
	
	private static int count;
	private static synchronized void inc() {
		count++;
	}
	
	public static int cnt() {
		return count;
	}
			
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] allMethods = c.getDeclaredMethods();
			for(Method m : allMethods) {
				if(!m.getName().equals(args[1]))
					continue;
				out.format("%s%n", m.toGenericString());
				out.format(" Modifier: %s%n", m.getModifiers());
				out.format("   [ synthetic=%-5b var_args=%-5b brige=%-5b ]", m.isSynthetic(), m.isVarArgs(), m.isBridge());
				inc();
				
			}
			out.format("%d matching overload%s found%n", cnt(), (cnt() == 1 ? "" : "s"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
