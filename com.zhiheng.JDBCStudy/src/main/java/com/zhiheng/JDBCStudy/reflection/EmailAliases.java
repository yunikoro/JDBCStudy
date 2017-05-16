package com.zhiheng.JDBCStudy.reflection;

import java.util.HashMap;
import java.util.Set;

import static java.lang.System.out;

public class EmailAliases {
	private Set<String> aliases;
	
	private EmailAliases(HashMap<String, String> h) {
		aliases = h.keySet();
	}
	
	public void printKeys() {
		out.format("Mail keys: %n");
		for(String k : aliases)
			out.format(" %s%n", k);
	}
	
}
