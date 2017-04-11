package com.zhiheng.JDBCStudy;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        ConnectionBuilder connBuilder = new ConnectionBuilder();
    	try {
        	Connection conn = connBuilder.getConnection();
        } catch (SQLException e) {
        	System.out.println("SQLState: "+e.getSQLState());
        }
    }
}
