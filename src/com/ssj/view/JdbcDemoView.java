package com.ssj.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.css.CSSCharsetRule;

import com.ssj.action.JdbcControl;
import com.ssj.model.students;
import com.ssj.view.Operate;

public class JdbcDemoView {

	private static String string = "QUERY查询全部信息\n"
			      + "GET按姓名查询信息\n"
			      + "INSERT插入数据\n"
			      + "UPDATE更新数据\n"
			      + "DELETE删除数据\n"
			      + "EXIT结束程序\n"
			      + "请输入您要执行的操作：\n";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println(string);
		
		while (in.hasNext()) {
			String ss = in.nextLine();
			if("EXIT".equals(ss)||"E".equals(ss)) {
				System.out.println("您已经结束程序运行");
				break;
			}
			JdbcControl con = new JdbcControl();
			switch(ss.toUpperCase()) {
			case "QUERY":
			case "Q":
				getQueryResult();
				break;
			case "GET":
			case "G":
				System.out.println("请输入您要查询的姓名");
				String name = in.nextLine();
				getResult(name);
				break;
			case "INSERT":
			case "I":
				students student = new students();
				System.out.println("请输入学生姓名：");
				student.setName(in.nextLine());
				System.out.println("请输入学生年龄：");
				student.setAge(in.nextInt());
				System.out.println("请输入创建人姓名：");
				student.setCreatename(in.nextLine());
				con.add(student);
				break;
			case "UPDATE":
			case "U":
				students student1 = new students();
				System.out.println("请输入学生ID：");
				student1.setId(in.nextInt());
				System.out.println("请输入学生姓名：");
				student1.setName(in.nextLine());
				System.out.println("请输入学生年龄：");
				student1.setAge(in.nextInt());
				System.out.println("请输入创建人姓名：");
				student1.setCreatename(in.nextLine());
				con.update(student1);
				break;
			case "DELETE":
			case "D":
				System.out.println("请输入要删除的学生ID：");
				int id = in.nextInt();
				con.del(id);
				break;
			default :break;
			}
		}
		
	}

	private static void getResult(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		JdbcControl con = new JdbcControl();
		List<students> result = con.query(name);
		for(students s:result) {
			System.out.println(s.toString());
		}
	}
	private static void getQueryResult() throws ClassNotFoundException, SQLException {
		JdbcControl con = new JdbcControl();
		List<students> result = con.query();
		for(students s:result) {
			System.out.println(s.toString());
		}
	}

}
