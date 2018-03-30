package com.myqq.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionUtil {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("链接时静态加载出错");
		}
	}
	public static Connection getCon() {
		Connection con = null;;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/My_Chat?useUnicode=true&characterEncoding=UTF-8","root","");
		} catch (Exception e) {
			System.out.println("数据库链接出错");
		}
		return con;
	}
	public static void CloseCon(ResultSet rs,PreparedStatement ps,Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println("断开链接出错");
		}
	}
}
