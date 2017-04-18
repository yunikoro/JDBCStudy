package com.zhiheng.JDBCStudy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.zhiheng.JDBCStudy.connection.DataSourceConnectionBuilder;
import com.zhiheng.JDBCStudy.jndi.FirstJndi;

/**
 * Hello world!
 * to: http://docs.oracle.com/javase/tutorial/jdbc/basics/cachedrowset.html
 * overview http://docs.oracle.com/javase/tutorial/
 */
public class App {
    public static void main( String[] args ) {
          DataSourceConnectionBuilder dataSourceBuilder = new DataSourceConnectionBuilder();
          FirstJndi firstJndi = new FirstJndi();
          firstJndi.registerInJndi();
        try {
        	  Connection conn = dataSourceBuilder.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
