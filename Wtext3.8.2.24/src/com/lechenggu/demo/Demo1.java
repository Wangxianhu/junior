package com.lechenggu.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Demo1 {
	public static void text(Player pla){
		
		Connection con=null;
		try {
			//预编译及连接数据库
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abgame", "root", "123456");
			PreparedStatement ps=con.prepareStatement("insert into tplayer values(null,?,?,?,?,?)");
			ps.setString(1, pla.getLoginname());
			ps.setString(2, pla.getPassword());
			ps.setString(3, pla.getNickname());
			ps.setString(4, pla.getSex());
			ps.setInt(5, pla.getAge());
			int i=ps.executeUpdate();
			System.out.println(i);
			ResultSet rs=ps.executeQuery("select * from tplayer");
			while (rs.next()) {
				int id=rs.getInt(1);
				String loginname=rs.getString(2);
				String tpassword=rs.getString(3);
				String nickname=rs.getString(4);
				String sex=rs.getString(5);
				int age=rs.getInt(6);
				System.out.println(id+" 登录名:"+loginname+" 密码:"+tpassword+" 昵称:"+nickname+" 性别:"+sex+" 年龄:"+age);
			}
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
		Player pla=new Player();
		pla.setLoginname("小新");
		pla.setNickname("新");
		pla.setPassword("fff");
		pla.setSex("男");
		pla.setAge(30);
		text(pla);
	}
}
