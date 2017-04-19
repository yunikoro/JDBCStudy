package com.zhiheng.JDBCStudy.ExceptionHandler;

import java.sql.BatchUpdateException;
import java.sql.SQLException;

public class SQLExceptionHandler {
	
	public static void getExceptionInfo(SQLException e) {
		System.out.println("SQL Message: " + e.getMessage());
		System.out.println("SQL State: " + e.getSQLState());
		System.out.println("Error Code: " + e.getErrorCode());
		System.out.println("Cause: " + e.getCause());
		e.getNextException();
	}
	
	public static void getBatchUpdateException(BatchUpdateException e) {
		System.err.println("------BatchUpdateException------");
		System.err.println("SQLState: " + e.getSQLState());
		System.err.println("Message: " + e.getMessage());
		System.err.println("Vendor: " + e.getErrorCode());
		int[] updateCounts = e.getUpdateCounts();
		
		for(int i = 0; i < updateCounts.length; i++) {
			System.err.print(updateCounts[i] + " ");
		}
	}
}
