package com.lechenggu.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Demo {
	public static void test(){
		Connection con=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			String url="jdbc:mysql://localhost:3306/abgame";
			String user="root";
			String password="123456";
			String sql="select * from tplayer";
			con=DriverManager.getConnection(url, user, password);//connection（连接对象），driver manager（驱动管理类）
			//发送请求
			Statement st = con.createStatement();//statement（清单对象）
			ResultSet rs=st.executeQuery(sql);//result set（结果放对象）
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
		public static void test1(){
			Connection con=null;
			try {
				//加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				//连接数据库
				String url="jdbc:mysql://localhost:3306/abgame";
				String user="root";
				String password="123456";
				con=DriverManager.getConnection(url, user, password);//connection（连接对象），driver manager（驱动管理类）
				//发送请求
				PreparedStatement ps=con.prepareStatement("select * from tplayer where id=?");
//				ps.setString(1, "3");
				ps.setInt(1, 1);
				ResultSet rs=ps.executeQuery();//result set（结果放对象）
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
		Demo.test1();
	}
}
