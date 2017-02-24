package com.lechenggu.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Text {
	public static void main(String[] args) {
		Connection con=DBUtil.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into tplayer(id,loginname) values(6,'¿Ó')");
			int i=ps.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con, null, null);
		}
	}
}
