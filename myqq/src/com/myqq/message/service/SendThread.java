package com.myqq.message.service;

import java.io.OutputStream;
import java.net.Socket;

import com.myqq.entity.Message;
import com.myqq.util.IpUtil;
import com.myqq.util.SerializableUtil;

public class SendThread implements Runnable{
	private Socket socket;
	private OutputStream os;
	private Message message;
	
	public SendThread(Message message){
		try {
			socket = new Socket(IpUtil.SEVER_ADDRESS, 8888);
			os = socket.getOutputStream();
		} catch (Exception e) {
			System.out.println("发送消息线程构造出现错误");
		}
	}
	public void run(){
		try {
			os.write(SerializableUtil.serializable(message));
			os.flush();
			os.close();
		} catch (Exception e) {
			System.out.println("发消息线程出现错误");
		} 
	}
}
