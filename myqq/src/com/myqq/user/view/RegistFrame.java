package com.myqq.user.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.myqq.message.view.BtnListener;

public class RegistFrame extends JFrame{
	JLabel lblQqNum;
	JLabel lblPassword;
	JLabel lblNickName;
	JLabel lblGender;
	JLabel lblIntroduce;
	public JTextField txtQqNum;
	public JPasswordField txtPassword;
	public JTextField txtNickName;
	public JTextField txtGender;
	public JTextField txtIntroduce;
	JButton submit;
	public RegistFrame(){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		lblQqNum=new JLabel("QQ号：");
		lblPassword=new JLabel("密码：");
		lblNickName = new JLabel("名称 : ");
		lblGender = new JLabel("性别 : ");
		lblIntroduce = new JLabel("简介 : ");
		txtQqNum=new JTextField();
		txtPassword=new JPasswordField();
		txtNickName = new JTextField();
		txtGender = new JTextField();
		txtIntroduce = new JTextField();
		submit = new JButton("提交");
		this.getContentPane().setLayout(null);
		
		this.getContentPane().add(lblQqNum);
		lblQqNum.setBounds(80, 10, 80, 20);
		
		this.getContentPane().add(lblPassword);
		lblPassword.setBounds(80, 40, 80, 20);
		
		this.getContentPane().add(lblNickName);
		lblNickName.setBounds(80, 70, 80, 20);
		
		this.getContentPane().add(lblGender);
		lblGender.setBounds(80, 100, 80, 20);
		
		this.getContentPane().add(lblIntroduce );
		lblIntroduce.setBounds(80, 130, 80, 20);
		
		
		
		
		
		this.getContentPane().add(txtQqNum);
		txtQqNum.setBounds(140, 10, 140, 20);
		
		this.getContentPane().add(txtPassword);
		txtPassword.setBounds(140, 40, 140, 20);
		
		this.getContentPane().add(txtNickName);
		txtNickName.setBounds(140, 70, 140, 20);
		
		this.getContentPane().add(txtGender);
		txtGender.setBounds(140, 100, 140, 20);
		
		this.getContentPane().add(txtIntroduce);
		txtIntroduce.setBounds(140, 130, 140, 20);
		
		this.getContentPane().add(submit);
		submit.setBounds(170, 180, 60, 50);
		
		submit.addActionListener(new BtnListener(this));
		this.setTitle("用户注册");
		this.setSize(400,300);
		this.setVisible(true);
	}
}
