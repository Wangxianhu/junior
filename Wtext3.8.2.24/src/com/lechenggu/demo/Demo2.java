package com.lechenggu.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo2 {
	public static void test(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abgame", "root", "123456");
			PreparedStatement ps=con.prepareStatement("insert into tplayer values(null,?,?,?,?,?)");
			ps.setString(1, "�Ǻ�");
			ps.setString(2, "kdls");
			ps.setString(3, "�ǺǺ�");
			ps.setString(4, "��");
			ps.setString(5, "34");
			ps.addBatch();//
			ps.setString(1, "˹�ٷ�");
			ps.setString(2, "kdls");
			ps.setString(3, "�Ƿ���");
			ps.setString(4, "��");
			ps.setString(5, "34");		
			ps.addBatch();//
			ps.setString(1, "˾����");
			ps.setString(2, "kdls");
			ps.setString(3, "���");
			ps.setString(4, "��");
			ps.setString(5, "34");
			ps.addBatch();
			int[] m = ps.executeBatch();
			System.out.println(m.length);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		test();
	}
}
