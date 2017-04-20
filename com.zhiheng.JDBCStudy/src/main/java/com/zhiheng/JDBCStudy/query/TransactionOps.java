package com.zhiheng.JDBCStudy.query;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class TransactionOps {
	public static void getConnection(Connection conn) throws SQLException {
		System.out.println(Connection.TRANSACTION_NONE);
		System.out.println(Connection.TRANSACTION_READ_COMMITTED);
		System.out.println(Connection.TRANSACTION_READ_UNCOMMITTED);
		System.out.println(Connection.TRANSACTION_REPEATABLE_READ);
		System.out.println(Connection.TRANSACTION_SERIALIZABLE);
		conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
	}
}
