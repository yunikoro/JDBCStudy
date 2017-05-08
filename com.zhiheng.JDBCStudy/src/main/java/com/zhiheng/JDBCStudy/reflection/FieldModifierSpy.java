package com.zhiheng.JDBCStudy.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import static java.lang.System.out;

enum Spy {BLACK, WHITE}

public class FieldModifierSpy {

	volatile int share;
	int instance;
	class Inner {};
	
	private static int modifierFromString(String s) {
		int m = 0x0;
		if("public".equals(s))
			m |= Modifier.PUBLIC;
		else if("protected".equals(s))
			m |= Modifier.PROTECTED;
		else if("private".equals(s))
			m |= Modifier.PRIVATE;
		else if("static".equals(s))
			m |= Modifier.STATIC;
		else if("final".equals(s))
			m |= Modifier.FINAL;
		else if("transient".equals(s))
			m |= Modifier.TRANSIENT;
		else if("volatile".equals(s))
			m |= Modifier.VOLATILE;
		return m;
	}
	
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			int searchMods = 0x0;
			for (int i = 1; i < args.length; i++) {
				searchMods |= modifierFromString(args[i]);
			}
			
			Field[] flds = c.getDeclaredFields();
			out.format("Field in Class '%s' containing modifiers: %s%n", c.getName(), Modifier.toString(searchMods));
			boolean found = false;
			for(Field f : flds) {
				int foundMods = f.getModifiers();
				if((foundMods & searchMods) == searchMods) {
					out.format("%-8s [ synthetic=%-5b enum_constant=%-5b]%n", f.getName(), f.isSynthetic(), f.isEnumConstant());
					found = true;
				}
			}
			
			if(!found)
				out.format("No Matching fields%n");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
