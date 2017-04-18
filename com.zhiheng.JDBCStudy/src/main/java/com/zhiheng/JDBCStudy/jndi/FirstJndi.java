package com.zhiheng.JDBCStudy.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FirstJndi {

	public void registerInJndi() {
		try {
			Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "java.lang.Object");;
			InitialContext context = new InitialContext(env);
			context.bind("java:global/JndiEjb", this);
			//context.bind(name, obj);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static void retrieveFormJndi() {
		try {
			InitialContext context = new InitialContext();
			Object lookup = context.lookup("java:global/JndiEjb");
			if(lookup != null && lookup instanceof FirstJndi) {
				FirstJndi jndiEjb = (FirstJndi)lookup;
				jndiEjb.helloJndi();
			}
		} catch (NamingException e) {
			// TODO: handle exception
		}
	}
	
	public void helloJndi() {
		System.out.println("hello I am FirstJndi and form JNDI");
	}
	
	public FirstJndi() {
		// TODO Auto-generated constructor stub
	}
	
}
