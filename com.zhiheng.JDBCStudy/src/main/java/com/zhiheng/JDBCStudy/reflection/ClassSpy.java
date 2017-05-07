package com.zhiheng.JDBCStudy.reflection;

import static java.lang.System.out;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;;

enum ClassMember {CONSTRUCTOR, FIELD, METHOD, CLASS, ALL}

public class ClassSpy {
	
	private static void printMembers(Member[] mbrs, String s) {
		out.format("%s:%n", s);
		for(Member mbr : mbrs) {
			if(mbr instanceof Field)
				out.format(" %s%n", ((Field)mbr).toGenericString());
			else if(mbr instanceof Constructor)
				out.format(" %s%n", ((Constructor)mbr).toGenericString());
			else if(mbr instanceof Method)
				out.format(" %s%n", ((Method)mbr).toGenericString());
		}
	}
	
	private static void printClasses(Class<?> c) {
		out.format("Classes:%n");
		Class<?>[] clss = c.getClasses();
		for (Class<?> cls : clss) {
			out.format(" %s%n", cls.getCanonicalName());
		}
		if(clss.length == 0)
			out.format("-- No member interfaces, classes or enums --");
		out.format("%n");
 	}
	
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			out.format("Class:%n %s%n%n", c.getCanonicalName());
			
			Package p = c.getPackage();
			out.format("Package:%n %s%n%n", (p != null ? p.getName() : "-- No Package --"));
			
			for (int i = 1; i < args.length; i++) {
				switch (ClassMember.valueOf(args[i])) {
				case CONSTRUCTOR:
					printMembers(c.getFields(), "Fields");
					break;
				case FIELD:
					printMembers(c.getMethods(), "Methods");
					break;
				case CLASS:
					printClasses(c);
					break;	
				case ALL:
					
					break;	
				default:
					assert false;
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
