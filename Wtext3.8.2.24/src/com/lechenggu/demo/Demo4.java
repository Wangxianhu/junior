package com.lechenggu.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo4 {
	public static void delete(){
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abgame", "root", "123456");
			PreparedStatement ps=con.prepareStatement("");
			ps.addBatch("delete from tplayer where id=20");
			ps.addBatch("delete from tplayer where id=21");
			ps.addBatch("delete from tplayer where id=22");
			ps.addBatch("delete from tplayer where id=23");
			int[] i=ps.executeBatch();
			System.out.println(i.length);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	public static void main(String[] args) {
		delete();
	}
}
