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
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			String url="jdbc:mysql://localhost:3306/abgame";
			String user="root";
			String password="123456";
			String sql="select * from tplayer";
			con=DriverManager.getConnection(url, user, password);//connection�����Ӷ��󣩣�driver manager�����������ࣩ
			//��������
			Statement st = con.createStatement();//statement���嵥����
			ResultSet rs=st.executeQuery(sql);//result set������Ŷ���
			while (rs.next()) {
				int id=rs.getInt(1);
				String loginname=rs.getString(2);
				String tpassword=rs.getString(3);
				String nickname=rs.getString(4);
				String sex=rs.getString(5);
				int age=rs.getInt(6);
				System.out.println(id+" ��¼��:"+loginname+" ����:"+tpassword+" �ǳ�:"+nickname+" �Ա�:"+sex+" ����:"+age);
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
				//��������
				Class.forName("com.mysql.jdbc.Driver");
				//�������ݿ�
				String url="jdbc:mysql://localhost:3306/abgame";
				String user="root";
				String password="123456";
				con=DriverManager.getConnection(url, user, password);//connection�����Ӷ��󣩣�driver manager�����������ࣩ
				//��������
				PreparedStatement ps=con.prepareStatement("select * from tplayer where id=?");
//				ps.setString(1, "3");
				ps.setInt(1, 1);
				ResultSet rs=ps.executeQuery();//result set������Ŷ���
				while (rs.next()) {
					int id=rs.getInt(1);
					String loginname=rs.getString(2);
					String tpassword=rs.getString(3);
					String nickname=rs.getString(4);
					String sex=rs.getString(5);
					int age=rs.getInt(6);
					System.out.println(id+" ��¼��:"+loginname+" ����:"+tpassword+" �ǳ�:"+nickname+" �Ա�:"+sex+" ����:"+age);
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
