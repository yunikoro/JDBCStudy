package com.zhiheng.JDBCStudy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static java.lang.System.out;

public class ConstructorAccess {
	
	public static final String what = "whatValue";
	
	private static int accessModifiers(int m) {
		return m & (Modifier.PUBLIC | Modifier.PRIVATE | Modifier.PROTECTED);
	}
	
	private static int modifierFromString(String s) {
		if ("public".equals(s))
			return Modifier.PUBLIC;
		else if("protected".equals(s))
			return Modifier.PROTECTED;
		else if("private".equals(s))
			return Modifier.PRIVATE;
		else if("package-private".equals(s))
			return 0;
		else
			return -1;
	}
	
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			Class<?> d = ConstructorAccess.class;
			Field what = d.getDeclaredField("what");
			int modf = what.getModifiers();
			System.out.println(Integer.toBinaryString(modf)+", "+modf+", "+what.toGenericString());
			Constructor[] allConstructors = c.getDeclaredConstructors();
			for (Constructor ctor : allConstructors) {
				int searchMod = modifierFromString(args[1]);
				int mods = ctor.getModifiers();
				if(searchMod == mods) {
					out.format("%s%n", ctor.toGenericString());
					out.format(" [ syntheic=%-5b var_args=%-5b]%n", ctor.isSynthetic(), ctor.isVarArgs());
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

}
