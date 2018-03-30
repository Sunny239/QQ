package com.myqq.user.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.myqq.entity.User;
import com.myqq.message.view.BtnListener;

public class ChatFrame extends JFrame{
	public User myself;
	public User another;
	
	public JTextField txtMsg;
	public JTextArea txtArel;
	public JButton btn;
	JPanel jPanel;
	JPanel txtPanel;
	public ChatFrame(User myself, User another){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.myself = myself;
		this.another = another;
		jPanel = new JPanel();
		//创建独立窗口
		this.getContentPane().add(jPanel);
		jPanel.setLayout(new BorderLayout());
		
		txtArel = new JTextArea(5,20);
		jPanel.add(txtArel, BorderLayout.CENTER);
		
		txtPanel = new JPanel();
		txtMsg = new JTextField(10);
		
		btn = new JButton("发送");
		btn.addActionListener(new BtnListener(this));
		
		txtPanel.add(txtMsg);
		txtPanel.add(btn);
		jPanel.add(txtPanel,BorderLayout.SOUTH);
		this.setTitle(another.getNickName());
		this.setSize(400,300);
		this.setVisible(true);
	}
}
