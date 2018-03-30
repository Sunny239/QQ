package com.myqq.message.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import com.myqq.entity.Message;
import com.myqq.entity.User;
import com.myqq.message.service.MessageService;
import com.myqq.user.service.UserService;
import com.myqq.user.view.ChatFrame;
import com.myqq.user.view.LoginFrame;
import com.myqq.user.view.MainFrame;
import com.myqq.user.view.RegistFrame;
import com.myqq.user.view.UpdateFrame;
import com.myqq.util.IpUtil;

public class BtnListener implements ActionListener{
	int temp = 0;
	static final int LOGIN_FRAME = 1;
	static final int REGIST_FRAME = 2;
	static final int UPDATE_FRAME = 3;
	static final int CHAT_FRAME = 4;
	
	LoginFrame loginFrame;
	RegistFrame registFrame;
	UpdateFrame updateFrame;
	ChatFrame chatFrame;
	
	public BtnListener(LoginFrame loginFrame){
		this.loginFrame = loginFrame;
		temp = LOGIN_FRAME;
	}
	public BtnListener(RegistFrame registFrame){
		this.registFrame =registFrame;
		temp = REGIST_FRAME;
	}
	public BtnListener(UpdateFrame updateFrame){
		this.updateFrame = updateFrame;
		temp = UPDATE_FRAME;
	}
	public BtnListener(ChatFrame chatFrame){
		this.chatFrame = chatFrame;
		temp = CHAT_FRAME;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (temp == LOGIN_FRAME) {
			if (arg0.getActionCommand() == "登录") {
				User u = new UserService().login(Integer.parseInt(loginFrame.txtQqNum.getText()),new String( loginFrame.txtPassword.getPassword()));
				if (u != null) {
					new MainFrame(u);
					loginFrame.dispose();
					loginFrame = null;
				} else {
					System.out.println("登录失败");
				}
			}
			if (arg0.getActionCommand() == "取消") {
				loginFrame.dispose();
				loginFrame = null;
			}
			if (arg0.getActionCommand() == "注册") {
				new RegistFrame();
			}
			if (arg0.getActionCommand() == "修改密码") {
				new UpdateFrame();
			}
		}
		
		if (temp == REGIST_FRAME) {
			new UserService().regist(new User(
					Integer.parseInt(registFrame.txtQqNum.getText()),
					new String(registFrame.txtPassword.getPassword()),
					registFrame.txtNickName.getText(),
					registFrame.txtGender.getText().charAt(0),
					registFrame.txtIntroduce.getText(),
					IpUtil.getIp(), 
					new Date(System.currentTimeMillis())));
		}
		
		if (temp == UPDATE_FRAME) {
			new UserService().updatePassword(Integer.parseInt(updateFrame.txtQqNum.getText()), 
					new String(updateFrame.txtOldPassword.getPassword()),
					new String(updateFrame.txtNewPassword.getPassword()),
					new String(updateFrame.txtConfirmPassword.getPassword()));
		}
		
		if (temp == CHAT_FRAME) {
			String msg = chatFrame.txtMsg.getText();
			Message message = new Message(msg, chatFrame.myself.getQqnum(), chatFrame.myself.getIp(), chatFrame.another.getQqnum(), chatFrame.another.getIp());
			new MessageService().sendMessage(message);
			
			chatFrame.txtMsg.setText("");
			String content=chatFrame.txtArel.getText();
			
			content+=chatFrame.myself.getNickName()+":"+msg+"\n";
			chatFrame.txtArel.setText(content);
		}
}
	
}
