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
import com.zhiheng.JDBCStudy.concurrent.HelloRunnable;
import com.zhiheng.JDBCStudy.concurrent.HelloThread;
import com.zhiheng.JDBCStudy.concurrent.SimpleThreads;
import com.zhiheng.JDBCStudy.concurrent.SynchronizedCounter;
import com.zhiheng.JDBCStudy.connection.DataSourceConnectionBuilder;
import com.zhiheng.JDBCStudy.event.EventConsumer;
import com.zhiheng.JDBCStudy.event.EventProducer;
import com.zhiheng.JDBCStudy.jndi.FirstJndi;
import com.zhiheng.JDBCStudy.query.ResultSetQuery;

/**
 * Hello world!
 * to: http://docs.oracle.com/javase/tutorial/jdbc/basics/cachedrowset.html
 * overview http://docs.oracle.com/javase/tutorial/
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
    	/*EventProducer producer = new EventProducer();
    	producer.addListener(new EventConsumer());
    	producer.setValue(2);
    	producer.setValue(3);
    	producer.setValue(4);*/
    	
    	SynchronizedCounter counter = new SynchronizedCounter();
    	Thread jack = new Thread(new Runnable() {
    		@Override
    		public void run() {
    			counter.addName("Jack");			
    		}
    	});
    	jack.setName("Jack");
    	jack.start();
    	
    	Thread bill = new Thread(new Runnable() {
    		@Override
    		public void run() {
    			counter.addName("Bill");
    		}
    	});
    	bill.setName("Bill");
    	bill.start();
    }
}
