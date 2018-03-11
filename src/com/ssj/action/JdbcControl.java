package com.ssj.action;

import java.sql.SQLException;
import java.util.List;

import com.ssj.dao.JdbcDemoDao;
import com.ssj.model.students;

public class JdbcControl {
	
	public boolean add(students ss) throws ClassNotFoundException, SQLException {
		JdbcDemoDao dao = new JdbcDemoDao();
		return  dao.insert(ss);
	}
	public boolean del(int id) throws ClassNotFoundException, SQLException {
		JdbcDemoDao dao = new JdbcDemoDao();
		return dao.delete(2);
	}
	public boolean update(students ss) throws ClassNotFoundException, SQLException {
		JdbcDemoDao dao = new JdbcDemoDao();
		return dao.update(ss);
	}
	public List<students> query() throws ClassNotFoundException, SQLException {
		JdbcDemoDao dao = new JdbcDemoDao();
		return dao.query();
	}
	public List<students> query(String name) throws ClassNotFoundException, SQLException {
		JdbcDemoDao dao = new JdbcDemoDao();
		return dao.get(name);
	}
}
	
