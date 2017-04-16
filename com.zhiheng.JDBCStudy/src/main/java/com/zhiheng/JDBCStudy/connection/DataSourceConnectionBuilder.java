package com.zhiheng.JDBCStudy.connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceConnectionBuilder {

	
	
	public DataSourceConnectionBuilder() {
		MysqlDataSource mds = new MysqlDataSource();
		mds.setURL("jdbc:mysql://localhost:3306/coffee");
		
	}
}
