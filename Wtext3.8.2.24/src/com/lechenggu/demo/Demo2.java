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
			ps.setString(1, "ºÇºÇ");
			ps.setString(2, "kdls");
			ps.setString(3, "ºÇºÇºÇ");
			ps.setString(4, "ÄÐ");
			ps.setString(5, "34");
			ps.addBatch();//
			ps.setString(1, "Ë¹µÙ·Ò");
			ps.setString(2, "kdls");
			ps.setString(3, "ºÇ·¢ËÍ");
			ps.setString(4, "ÄÐ");
			ps.setString(5, "34");		
			ps.addBatch();//
			ps.setString(1, "Ë¾·¨Ëù");
			ps.setString(2, "kdls");
			ps.setString(3, "Éí·Ý");
			ps.setString(4, "ÄÐ");
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
