package com.myqq.util;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class IpUtil {
	public static final String SEVER_ADDRESS = "127.0.0.1";
	public static String getIp () {
		String hostName;
		try {
			hostName = InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
			hostName = "";
			System.out.println("IP地址获取错误");
		}
		return hostName;
	}
	
	public static void updateIp(int qqnum){
		Connection con=null;
		PreparedStatement ps=null;
		try{
			con=ConnectionUtil.getCon();
			ps=con.prepareStatement(
					"update users set ip=? where qqnum=?");
			ps.setString(1, IpUtil.getIp());
			ps.setInt(2, qqnum);
			ps.executeUpdate();
		}catch(Exception e){
			System.out.println("IP地址更新错误");
		}finally{
			ConnectionUtil.CloseCon(null, ps, con);
		}
	}
}
