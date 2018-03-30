package com.myqq.user.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.myqq.message.view.BtnListener;

public class LoginFrame extends JFrame{
	JLabel lblQqNum;
	JLabel lblPassword;
	public JTextField txtQqNum;
	public JPasswordField txtPassword;
	JButton btnLogin;
	JButton btnCancel;
	JButton btnRegist;
	JButton btnUpdatePassword;
	public LoginFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lblQqNum=new JLabel("QQ号：");
		lblPassword=new JLabel("密码：");
		txtQqNum=new JTextField();
		txtPassword=new JPasswordField();
		btnLogin=new JButton("登录");
		btnCancel=new JButton("取消");
		btnRegist = new JButton("注册");
		btnUpdatePassword = new JButton("修改密码");
		
		this.getContentPane().setLayout(null);
		
		this.getContentPane().add(lblQqNum);
		lblQqNum.setBounds(50, 70, 80, 20);
		
		this.getContentPane().add(lblPassword);
		lblPassword.setBounds(50, 100, 80, 20);
		
		this.getContentPane().add(txtQqNum);
		txtQqNum.setBounds(110, 70, 140, 20);
		
		this.getContentPane().add(txtPassword);
		txtPassword.setBounds(110, 100, 140, 20);
		
		this.getContentPane().add(btnLogin);
		btnLogin.setBounds(90, 150, 80, 20);
		
		this.getContentPane().add(btnCancel);
		btnCancel.setBounds(190, 150, 80, 20);
		
		this.getContentPane().add(btnRegist);
		btnRegist.setBounds(260, 70, 100, 20);
		
		this.getContentPane().add(btnUpdatePassword);
		btnUpdatePassword.setBounds(260, 100, 100, 20);
		
		btnLogin.addActionListener(new BtnListener(this));
		btnCancel.addActionListener(new BtnListener(this));
		btnRegist.addActionListener(new BtnListener(this));
		btnUpdatePassword.addActionListener(new BtnListener(this));
		
		this.setTitle("QQ登录");
		this.setSize(400,300);
		this.setVisible(true);
	}
}
