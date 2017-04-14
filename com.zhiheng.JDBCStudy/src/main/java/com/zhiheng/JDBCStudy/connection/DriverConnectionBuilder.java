package com.zhiheng.JDBCStudy.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DriverConnectionBuilder {
	private Connection conn;
	private Properties loginProperties;
	private String url;
	
	public Connection getConnection() throws SQLException{
		this.conn = DriverManager.getConnection(this.url, this.loginProperties);
		return conn;
	}
	
	public DriverConnectionBuilder() {
		this.conn = null;
		this.loginProperties = new Properties();
		this.loginProperties.setProperty("user", "root");
		this.loginProperties.setProperty("password", "ilikecrow451454");
		this.url = "jdbc:mysql://localhost:3306/coffee";
	}
}