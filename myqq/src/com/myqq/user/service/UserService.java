package com.myqq.user.service;

import java.util.List;

import com.myqq.entity.User;
import com.myqq.user.dao.UserDao;

public class UserService {
	/*登录*/
	public User login(int qqnum,String password) {
		UserDao ud = new UserDao();
		if (ud.login(qqnum, password)) {
			System.out.println("登录成功");
			return ud.getUser(qqnum);
		} else {
			System.out.println("登录失败");
			return null;
		}
	}
	/*列出好友列表*/
	public List<User> listFriends(int qqnum) {
		return new UserDao().getFriends(qqnum);
	}
	/*用户注册*/
	public void regist(User u){
		if (new UserDao().addUser(u)) {
			System.out.println("注册成功");
		} else {
			System.out.println("注册失败");
		}
	}
	/*密码修改*/
	public void updatePassword(int qqnum, String oldPassword, String newPassword,String confirmPassword){
		if (newPassword.equals(confirmPassword)) {
			new UserDao().updatePassword(qqnum, oldPassword, newPassword);
		} else {
			System.out.println("两次密码输入不一致");
		}
	}
	/*获得用户*/
	public User getAnother(int qqnum){
		return new UserDao().getUser(qqnum);
	}
}
