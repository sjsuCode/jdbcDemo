package com.ssj.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import com.ssj.db.DBConnect;
import com.ssj.model.students;

public class JdbcDemoDao {

	public boolean update(students ss) throws ClassNotFoundException, SQLException {
		Connection connection = DBConnect.connection();
		String strsql = "update students set name = ?,age = ?,createname = ? where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(strsql);
		preparedStatement.setString(1, ss.getName());
		preparedStatement.setInt(2, ss.getAge());
		preparedStatement.setString(3, ss.getCreatename());
		preparedStatement.setInt(4, ss.getId());
		boolean result = preparedStatement.execute();
		connection.close();
		return result;
	}
	
	public boolean delete(int id) throws ClassNotFoundException, SQLException {
		Connection connection = DBConnect.connection();
		Statement statement = connection.createStatement();
		
		String strsql = "delete from students where id = "+id;
		boolean result = statement.execute(strsql);
		connection.close();
		return result;
	}
	
	public boolean insert(students s) throws ClassNotFoundException, SQLException {
		Connection connection = DBConnect.connection();
		
		String strsql = " insert into students(name,age,insertdate,createname) values (?,?,current_date(),?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(strsql);
		preparedStatement.setString(1,s.getName());
		preparedStatement.setInt(2, s.getAge());
		preparedStatement.setString(3, s.getCreatename());
		
		boolean result = preparedStatement.execute();
		connection.close();
		return result;
	}
	
	public List<students> query() throws ClassNotFoundException, SQLException{
		Connection connection = DBConnect.connection();
		Statement statement = connection.createStatement();
		String strsql = "select * from students";
		ResultSet resultSet = statement.executeQuery(strsql);
		List<students> questList = new ArrayList<>(); 
		while(resultSet.next()) {
			students students = new students();
			students.setId(resultSet.getInt("id"));
			students.setName(resultSet.getString("name"));
			students.setAge(resultSet.getInt("age"));
			students.setInsertdate(resultSet.getDate("insertdate"));
			students.setCreatename(resultSet.getString("createname"));
			
			questList.add(students);
		}
		connection.close();
		return questList;
	}
	
    public List<students> get(String name) throws ClassNotFoundException, SQLException{
    	
    	Connection connection = DBConnect.connection();
		String strsql = "select * from students where name = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(strsql);
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<students> questList = new ArrayList<>(); 
		while(resultSet.next()) {
			students students = new students();
			students.setId(resultSet.getInt("id"));
			students.setName(resultSet.getString("name"));
			students.setAge(resultSet.getInt("age"));
			students.setInsertdate(resultSet.getDate("insertdate"));
			students.setCreatename(resultSet.getString("createname"));
			
			questList.add(students);
		}
		//connection.close();
		return questList;
	}
}
