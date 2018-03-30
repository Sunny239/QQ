package com.myqq.user.view;

import java.util.Date;

import com.myqq.entity.User;

public class Test {
	public static void main(String[] args) {
	User u = new User();
	u.setNickName("feng");
	u.setPassword("789");
	u.setGender('男');
	u.setRegistTime(new Date());
	u.setIntroduce("我叫峰");
	u.setIp("127.0.0.1");
	}
}
