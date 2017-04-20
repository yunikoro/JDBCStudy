package com.zhiheng.JDBCStudy;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

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
        System.out.println(Connection.TRANSACTION_NONE);
		System.out.println(Connection.TRANSACTION_READ_COMMITTED);
		System.out.println(Connection.TRANSACTION_READ_UNCOMMITTED);
		System.out.println(Connection.TRANSACTION_REPEATABLE_READ);
		System.out.println(Connection.TRANSACTION_SERIALIZABLE);
        try {
        	Connection conn = dataSourceBuilder.getConnection();
        	System.out.println(conn.getTransactionIsolation());
        	//ResultSetQuery.insertRow(conn, "coffee", "latte", 150, 8.99f, 56, 100);
        	HashMap<String, Integer> salesForWeek = new HashMap<String, Integer>(1);
        	salesForWeek.put("Colombian", 5);
        	//ResultSetQuery.updateCoffeeSales(conn, "coffee", salesForWeek);
        	//ResultSetQuery.viewTable(conn, "coffee");
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }
}
