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
import com.zhiheng.JDBCStudy.concurrent.Consumer;
import com.zhiheng.JDBCStudy.concurrent.Drop;
import com.zhiheng.JDBCStudy.concurrent.HelloRunnable;
import com.zhiheng.JDBCStudy.concurrent.HelloThread;
import com.zhiheng.JDBCStudy.concurrent.Producer;
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
    	
    	Drop drop = new Drop(); 
    	
    	Thread thread1 = new Thread(new Producer(drop));
    	thread1.setName("Prodecer1");
    	Thread thread2 = new Thread(new Producer(drop));
    	thread1.setName("Prodecer2");
    	Thread thread3 = new Thread(new Producer(drop));
    	thread3.setName("Prodecer3");
    	Thread thread4 = new Thread(new Consumer(drop));
    	thread2.setName("Consumer");
    	
    	thread1.start();
    	thread2.start();
    	thread3.start();
    	thread4.start();
    }
}
