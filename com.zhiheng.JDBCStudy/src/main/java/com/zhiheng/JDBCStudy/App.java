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

/**
 * Hello world!
 * to: http://docs.oracle.com/javase/tutorial/jdbc/basics/cachedrowset.html
 */
public class App {
    public static void main( String[] args ) {
        ConnectionBuilder connBuilder = new ConnectionBuilder();
    	try {
        	Connection conn = connBuilder.getConnection();
        	Statement stmt = null;
        	String query = "select cof_name, sup_id, price, sales, total from coffee.coffees";
        	stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(query);
        	ResultSetMetaData rsmd = rs.getMetaData();
        	Integer colCount = rsmd.getColumnCount();
        	System.out.println(colCount);
        	for(int i = 1; i <= colCount; i++) {
        		String typeName = rsmd.getColumnTypeName(i);
        		String colName = rsmd.getColumnName(i);
        		System.out.println(colName + ", " + typeName);
        	}
        	System.out.println(rs.TYPE_FORWARD_ONLY);
        	while(rs.next()) {
        		Integer coffeeName = rs.getInt("cof_name");
        		String price = rs.getString("price");
        		System.out.println(coffeeName +", "+ price);
        	}
        } catch (SQLException e) {
        	System.out.println("SQLState: " + e.getSQLState());
        	System.out.println("Error Code: "+ e.getErrorCode());
        	System.out.println("Message: " + e.getMessage());
        } finally {
        	
        }
    	
    }
}
