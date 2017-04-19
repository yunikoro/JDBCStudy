package com.zhiheng.JDBCStudy.query;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.zhiheng.JDBCStudy.ExceptionHandler.SQLExceptionHandler;

public class ResultSetQuery {
	
	public static void viewTable(Connection conn, String dbName) throws SQLException {
		Statement stmt = null;
		String query = "select cof_name, sup_id, price, sales, total from " + dbName + ".coffees";
		try {
			//stmt = conn.createStatement();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			Integer colCount = rsmd.getColumnCount();
			for(int i = 1; i <= colCount; i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
				if(i == colCount)
					System.out.println();
			}
			while (rs.next()) {
				String coffeeName = rs.getString("COF_Name");
				Integer supplierID = rs.getInt("sup_id");
				Float price = rs.getFloat("price");
				Integer sales = rs.getInt("sales");
				Integer total = rs.getInt("Total");
				System.out.println(coffeeName + "\t" + supplierID + "\t" + price + "\t" + sales + "\t" + total);
			}
		} catch (SQLException e) {
			SQLExceptionHandler.getExceptionInfo(e);
		} finally {
			if(stmt != null) {
				stmt.close();
			}
		}
	}
	
	public static void alternateViewTable(Connection conn) throws SQLException {
		Statement stmt = null;
		String query = "select cof_name, sup_id, price, sales, total from coffees";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			Integer colCount = rsmd.getColumnCount();
			for(int i = 1; i <= colCount; i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
				if(i == colCount)
					System.out.println();
			}
			while(rs.next()) {
				String coffeeName = rs.getString(1);
				Integer supplierID = rs.getInt(2);
				Float price = rs.getFloat(3);
				Integer sales = rs.getInt(4);
				Integer total = rs.getInt(5);
				System.out.println(coffeeName + "\t" + supplierID + "\t" + price + "\t" + sales + "\t" + total);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public static void modifyPrice(Connection conn, String dbName, Float percent) throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet uprs = stmt.executeQuery("select * from " + dbName + ".coffees");
			while (uprs.next()) {
				Float f = uprs.getFloat("price");
				uprs.updateFloat("price", f * percent);
				uprs.updateRow();
			}
		} catch (SQLException e) {
			SQLExceptionHandler.getExceptionInfo(e);
		} finally {
			if(stmt != null)
				stmt.close();
		}
	}
	
	public static void batchUpdate(Connection conn) throws SQLException {
		Statement stmt = null;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			
			stmt.addBatch("insert into coffees values('Amaretto', 49, 9.99, 0, 0)");
			stmt.addBatch("insert into coffees values('Hazelnut', 49, 9.99, 0, 0)");
			stmt.addBatch("insert into coffees values('Amaretto_decaf', 49, 9.99, 0, 0)");
			stmt.addBatch("insert into coffees values('Hazelnut_decaf', 49, 9.99, 0, 0)");
			
			int[] updateCounts = stmt.executeBatch();
			
		} catch (BatchUpdateException e) {
			
		} catch (SQLException e) {
			SQLExceptionHandler.getExceptionInfo(e);
		} finally {
			if(stmt != null)
				stmt.close();
			conn.setAutoCommit(true);
		}
	}
	
	public static void paraBatchUpdate(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("insert into coffees values(?, ?, ?, ?, ?)");
			pstmt.setString(1, "Amaretto");
			pstmt.setInt(2,  49);
			pstmt.setFloat(3,  9.99f);
			pstmt.setInt(4, 0);
			pstmt.addBatch();
			
			pstmt.setString(1, "Hazelnut");
			pstmt.setInt(2,  49);
			pstmt.setFloat(3,  9.99f);
			pstmt.setInt(4, 0);
			pstmt.addBatch();
			
			conn.commit();
		}catch (Exception e) {
			// TODO: handle exception
		} finally {
			if(pstmt != null)
				pstmt.close();
			conn.setAutoCommit(true);
		}	
	}
	
	public static void insertRow(Connection conn, String dbName, String coffeeName, Integer supplierID, Float price, Integer sales, Integer total) throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet uprs = stmt.executeQuery("select * from " + dbName +".coffees");
			uprs.moveToInsertRow();
			uprs.updateString("cof_name", coffeeName);
			uprs.updateInt("sup_id", supplierID);
			uprs.updateFloat("price", price);
			uprs.updateInt("sales", sales);
			uprs.updateInt("total", total);
			
			uprs.insertRow();
			uprs.beforeFirst();
			
		} catch (SQLException e) {
			SQLExceptionHandler.getExceptionInfo(e);
		} finally {
			if(stmt != null)
				stmt.close();
		}
	}
	
	public ResultSetQuery() {
		super();
	}
}
