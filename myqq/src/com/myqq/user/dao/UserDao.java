package com.myqq.user.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myqq.entity.User;
import com.myqq.util.ConnectionUtil;
import com.myqq.util.IpUtil;

public class UserDao {
	/*通用变量定义*/
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	/*添加用户*/
	public boolean addUser(User u){
		try {
			con = ConnectionUtil.getCon();
			ps = con.prepareStatement("select qqnum from users where qqnum=?");
			ps.setInt(1, u.getQqnum());
			rs = ps.executeQuery();
			if (rs != null) {
				System.out.println("qq号已存在");
				return false;
			}
			ps = con.prepareStatement("insert into users(qqnum,password,nickName,gender,introduce,ip,registTime) values(?,?,?,?,?,?,?)");
			ps.setInt(1, u.getQqnum());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getNickName());
			ps.setString(4, String.valueOf(u.getGender()));
			ps.setString(5, u.getIntroduce());
			ps.setString(6, u.getIp());
			ps.setDate(7, (Date) u.getRegistTime());
			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println("用户添加成功");
				return true;
			} else {
				System.out.println("用户添加失败");
				return false;
			}
		} catch (SQLException e) {
			System.out.println("用户添加出现错误");
			return false;
		} finally {
			ConnectionUtil.CloseCon(null, ps, con);
		}
	}
	/*通过qqnum获得用户*/
	public User getUser(int qqnum) {
		try {
			con = ConnectionUtil.getCon();
			ps = con.prepareStatement("select * from users u where u.qqnum=?");
			ps.setInt(1, qqnum);
			rs = ps.executeQuery();
			User u = null;
			while(rs.next()){
				u = new User();
				u.setQqnum(rs.getInt(1));
				u.setPassword(rs.getString(2));
				u.setNickName(rs.getString(3));
				u.setGender(rs.getString(4).charAt(0));
				u.setIntroduce(rs.getString(5));
				u.setIp(rs.getString(6));
				u.setRegistTime(rs.getDate(7));
			}
			return u;
		} catch (Exception e) {
			System.out.println("获取用户出现错误");
			return null;
		} finally {
			ConnectionUtil.CloseCon(rs, ps, con);
		}
	}
	/*用户名、密码 判断登录*/
	public boolean login(int qqnum,String password){
		try {
			con = ConnectionUtil.getCon();
			ps = con.prepareStatement("select * from users u where u.qqnum=? and u.password=?");
			ps.setInt(1, qqnum);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next() == true) {
				IpUtil.updateIp(qqnum);
			} else {
				System.out.println("登录更新ip失败");
			}
			return true;
		} catch (Exception e) {
			System.out.println("登录出现错误");
			return false;
		} finally {
			ConnectionUtil.CloseCon(rs, ps, con);
		}
	}
	/*通过qqnum获得好友列表*/
	public List<User> getFriends(int qqnum) {
		List<User> list = new ArrayList<User>();
		try {
			con = ConnectionUtil.getCon();
			ps = con.prepareStatement("select * from users u where u.qqnum<>?");
			ps.setInt(1, qqnum);
			rs = ps.executeQuery();
			while(rs.next()){
				User u = new User();
				u.setQqnum(rs.getInt(1));
				u.setPassword(rs.getString(2));
				u.setNickName(rs.getString(3));
				u.setGender(rs.getString(4).charAt(0));
				u.setIntroduce(rs.getString(5));
				u.setIp(rs.getString(6));
				u.setRegistTime(rs.getDate(7));
				list.add(u);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("获取好友列表失败");
			return null;
		} finally {
			ConnectionUtil.CloseCon(rs, ps, con);
		}
	}
	/*密码修改*/
	public void updatePassword(int qqnum,String oldPassword,String newPassword){
		try {
			con = ConnectionUtil.getCon();
			ps = con.prepareStatement("select password from users u where u.qqnum=?");
			ps.setString(1,new String().valueOf(qqnum));
			rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString(1 ).equals(oldPassword)) {
					ps = con.prepareStatement("update users set password=? where qqNum=?");
					ps.setString(1, newPassword);
					ps.setString(2, new String().valueOf(qqnum));
					int count = ps.executeUpdate();
					if (count > 0) {
						System.out.println("密码修改成功");
					} else {
						System.out.println("密码修改失败");
					}
				} else {
					System.out.println("旧密码不正确");
				}
			} else {
				System.out.println("QQ号不存在");
			}
		} catch (Exception e) {
			System.out.println("修改密码出错");
		} finally {
			ConnectionUtil.CloseCon(rs, ps, con);
		}
	}
}
