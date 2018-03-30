package com.myqq.entity;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{
	final int SEND_ING = 0;
	final int SEND_OVER = 1;
	
	private String content;
	private int sender;
	private String senderIp;
	private Date sendTime;
	private int receiver;
	private String receiverIp;
	private Date receiveTime;
	
	public Message(String content,int sender,String senderIp ,int receiver,String reveiverIp){
		this.content = content;
		this.sender = sender;
		this.senderIp = senderIp;
		this.receiver = receiver;
		this.receiverIp = reveiverIp;
		sendTime = new Date(System.currentTimeMillis());
	}

	public String getSenderIp() {
		return senderIp;
	}

	public void setSenderIp(String senderIp) {
		this.senderIp = senderIp;
	}

	public String getReceiverIp() {
		return receiverIp;
	}

	public void setReceiverIp(String receiverIp) {
		this.receiverIp = receiverIp;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
}
