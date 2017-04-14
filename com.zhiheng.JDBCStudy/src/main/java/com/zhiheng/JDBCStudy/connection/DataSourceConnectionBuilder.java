package com.zhiheng.JDBCStudy.connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceConnectionBuilder {

	public DataSourceConnectionBuilder() {
		
	}

	public static void main(String[] args) {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/coffee");
		try {
			Context ctx = new InitialContext();
			ctx.bind("jdbc/coffee", dataSource);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			Context ctx = new InitialContext();
			MysqlDataSource mydataSource = (MysqlDataSource)ctx.lookup("jdbc/coffee");
			Connection conn = mydataSource.getConnection("root", "ilikecrow451454");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
