package com.zhiheng.JDBCStudy.reflection;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class RestoreAliases {

	private static Map<String, String> defaultAliases = new HashMap<String, String>();
	static {
		defaultAliases.put("Duke", "duke@i-love-java");
		defaultAliases.put("Fang", "fang@evil-jealous-twin");
	}
	
	public static void main(String[] args) {
		try {
			Constructor ctor = EmailAliases.class.getDeclaredConstructor(HashMap.class);
			ctor.setAccessible(true);
			EmailAliases email = (EmailAliases)ctor.newInstance(defaultAliases);
			email.printKeys();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
