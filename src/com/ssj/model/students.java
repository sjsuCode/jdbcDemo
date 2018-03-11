package com.ssj.model;

import java.util.Date;

public class students {

	private int id;
	private String name;
	private int age;
	private Date insertdate;
	private String createname;
	
	public students() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getInsertdate() {
		return insertdate;
	}
	public void setInsertdate(Date insertdate) {
		this.insertdate = insertdate;
	}
	public String getCreatename() {
		return createname;
	}
	public void setCreatename(String createname) {
		this.createname = createname;
	}
	@Override
	public String toString() {
		return "students [id=" + id + ", name=" + name + ", age=" + age + ", insertdate=" + insertdate + ", createname="
				+ createname + "]";
	}
	
	
}
