package com.zhiheng.JDBCStudy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.zhiheng.JDBCStudy.connection.DataSourceConnectionBuilder;
import com.zhiheng.JDBCStudy.jndi.FirstJndi;
import com.zhiheng.JDBCStudy.query.ResultSetQuery;

/**
 * Hello world!
 * to: http://docs.oracle.com/javase/tutorial/jdbc/basics/cachedrowset.html
 * overview http://docs.oracle.com/javase/tutorial/
 */
public class App {
    public static void main( String[] args ) {
        DataSourceConnectionBuilder dataSourceBuilder = new DataSourceConnectionBuilder();
        try {
        	Connection conn = dataSourceBuilder.getConnection();
        	ResultSetQuery.insertRow(conn, "coffee", "latte", 150, 8.99f, 56, 100);
        	ResultSetQuery.viewTable(conn, "coffee");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
