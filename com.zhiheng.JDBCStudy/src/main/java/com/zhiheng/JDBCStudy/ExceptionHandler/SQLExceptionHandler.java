package com.zhiheng.JDBCStudy.ExceptionHandler;

import java.sql.SQLException;

public class SQLExceptionHandler {
	public static void getExceptionInfo(SQLException e) {
		System.out.println("SQL Message: " + e.getMessage());
		System.out.println("SQL State: " + e.getSQLState());
		System.out.println("Error Code: " + e.getErrorCode());
		System.out.println("Cause: " + e.getCause());
		e.getNextException();
	}
}
