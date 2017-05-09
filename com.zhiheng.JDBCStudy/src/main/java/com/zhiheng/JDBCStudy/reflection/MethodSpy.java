package com.zhiheng.JDBCStudy.reflection;

import java.lang.RuntimeException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import static java.lang.System.out;

public class MethodSpy {
	private static final String fmt = "%24s: %s%n";
	<E extends RuntimeException> void genericThrow() throws E{}
	
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] allMethods = c.getDeclaredMethods();
			for (Method m : allMethods) {
				if (!m.getName().equals(args[1])) {
					continue;
				}
				out.format("%s%n", m.toGenericString());
				
				out.format(fmt, "ReturnType", m.toGenericString());
				out.format(fmt, "GenericReturnType", m.getGenericReturnType());
				
				Class<?>[] pType = m.getParameterTypes();
				Type[] gpType = m.getGenericParameterTypes();
				
				for (int i = 0; i < pType.length; i++) {
					out.format(fmt, "ParameterType", pType[i]);
					out.format(fmt, "GenericParameterType", gpType[i]);
				}
				
				Class<?>[] xType = m.getExceptionTypes();
				Type[] gxType = m.getGenericExceptionTypes();
				for(int i = 0; i < xType.length; i++) {
					out.format(fmt, "ExceptionType", xType[i]);
					out.format(fmt, "GenericExceptionType", gxType[i]);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
