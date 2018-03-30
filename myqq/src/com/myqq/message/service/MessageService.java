package com.myqq.message.service;

import com.myqq.entity.Message;

public class MessageService {
	public void sendMessage(Message message){
		new Thread(new SendThread(message)).start();
	}
}
