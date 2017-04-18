package com.zhiheng.JDBCStudy.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceConnectionBuilder {
	
	private MysqlDataSource mds;
	
	public Connection getConnection() throws SQLException {
		return this.mds.getConnection();
	}
	
	public MysqlDataSource getMySqlDataSource() {
		return this.mds;
	}
	
	public DataSourceConnectionBuilder() {
		mds = new MysqlDataSource();
		mds.setURL("jdbc:mysql://localhost:3306/coffee");
		mds.setUser("root");
		mds.setPassword("ilikecrow451454");
	}
}
