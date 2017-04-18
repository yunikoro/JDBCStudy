package com.zhiheng.JDBCStudy.jndi;

import java.util.Properties;

import javax.naming.CompoundName;
import javax.naming.Name;
import javax.naming.NameParser;
import javax.naming.NamingException;

public class HierParser implements NameParser {
	
	private static final Properties syntax = new Properties();
    
	static {
        syntax.put("jndi.syntax.direction", "right_to_left");
        syntax.put("jndi.syntax.separator", ".");
        syntax.put("jndi.syntax.ignorecase", "false");
        syntax.put("jndi.syntax.escape", "\\");
        syntax.put("jndi.syntax.beginquote", "'");
    }

    public Name parse(String name) throws NamingException {
        return new CompoundName(name, syntax);
    }
}
