package com.myqq.entity;

import java.util.Date;

public class User {
	private int qqnum;
	private String password;
	private String nickName;
	private char gender;
	private String introduce;
	private String ip;
	private Date registTime;
	public User() {
		
	}
	public User(int qqnum,String passwod,String nickName,char gender,String introduce,String ip,Date registTime) {
		this.qqnum = qqnum;
		this.password = passwod;
		this.nickName = nickName;
		this.gender = gender;
		this.introduce = introduce;
		this.ip = ip;
		this.registTime = registTime;
	}
	public int getQqnum() {
		return qqnum;
	}
	public void setQqnum(int qqnum) {
		this.qqnum = qqnum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	public String toString(){
		return this.nickName;
	}
}
