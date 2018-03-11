package com.ssj.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.css.CSSCharsetRule;

import com.ssj.action.JdbcControl;
import com.ssj.model.students;
import com.ssj.view.Operate;

public class JdbcDemoView {

	private static String string = "QUERY��ѯȫ����Ϣ\n"
			      + "GET��������ѯ��Ϣ\n"
			      + "INSERT��������\n"
			      + "UPDATE��������\n"
			      + "DELETEɾ������\n"
			      + "EXIT��������\n"
			      + "��������Ҫִ�еĲ�����\n";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println(string);
		
		while (in.hasNext()) {
			String ss = in.nextLine();
			if("EXIT".equals(ss)||"E".equals(ss)) {
				System.out.println("���Ѿ�������������");
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
				System.out.println("��������Ҫ��ѯ������");
				String name = in.nextLine();
				getResult(name);
				break;
			case "INSERT":
			case "I":
				students student = new students();
				System.out.println("������ѧ��������");
				student.setName(in.nextLine());
				System.out.println("������ѧ�����䣺");
				student.setAge(in.nextInt());
				System.out.println("�����봴����������");
				student.setCreatename(in.nextLine());
				con.add(student);
				break;
			case "UPDATE":
			case "U":
				students student1 = new students();
				System.out.println("������ѧ��ID��");
				student1.setId(in.nextInt());
				System.out.println("������ѧ��������");
				student1.setName(in.nextLine());
				System.out.println("������ѧ�����䣺");
				student1.setAge(in.nextInt());
				System.out.println("�����봴����������");
				student1.setCreatename(in.nextLine());
				con.update(student1);
				break;
			case "DELETE":
			case "D":
				System.out.println("������Ҫɾ����ѧ��ID��");
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
