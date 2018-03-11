package com.ssj.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 创建数据库jdbc连接；
 */

public class DBConnect {
	
	private static final String URL="jdbc:mysql://127.0.0.1:3306/jdbcdemo";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	public static Connection connection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		return connection;
	}
	
}
