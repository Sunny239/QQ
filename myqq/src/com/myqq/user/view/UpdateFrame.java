package com.myqq.user.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.myqq.message.view.BtnListener;

public class UpdateFrame extends JFrame{
	JLabel lblOldPassword;
	JLabel lblNewPassword;
	JLabel lblConfirmPassword;
	JLabel lblQqNum;
	public JTextField txtQqNum;
	public JPasswordField txtOldPassword;
	public JPasswordField txtNewPassword;
	public JPasswordField txtConfirmPassword;
	JButton submit;
	public UpdateFrame(){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		lblQqNum = new JLabel("QQ号");
		lblOldPassword = new JLabel("旧密码");
		lblNewPassword = new JLabel("新密码");
		lblConfirmPassword = new JLabel("确认新密码");
		txtOldPassword = new JPasswordField();
		txtNewPassword = new JPasswordField();
		txtConfirmPassword = new JPasswordField();
		txtQqNum = new JTextField();
		submit = new JButton("提交");
		this.getContentPane().setLayout(null);
		
		this.getContentPane().add(lblQqNum);
		lblQqNum.setBounds(80, 50, 80, 20);
		
		this.getContentPane().add(lblOldPassword);
		lblOldPassword.setBounds(80, 80, 80, 20);
		
		this.getContentPane().add(lblNewPassword);
		lblNewPassword.setBounds(80, 110, 80, 20);
		
		this.getContentPane().add(lblConfirmPassword);
		lblConfirmPassword.setBounds(80, 140, 80, 20);
		
		this.getContentPane().add(txtQqNum);
		txtQqNum.setBounds(170, 50, 140, 20);
		
		this.getContentPane().add(txtOldPassword);
		txtOldPassword.setBounds(170, 80, 140, 20);
		
		this.getContentPane().add(txtNewPassword);
		txtNewPassword.setBounds(170, 110, 140, 20);
		
		this.getContentPane().add(txtConfirmPassword);
		txtConfirmPassword.setBounds(170, 140, 140, 20);
		
		this.getContentPane().add(submit);
		submit.setBounds(170, 180, 60, 50);
		
		submit.addActionListener(new BtnListener(this));
		this.setTitle("密码修改");
		this.setSize(400,300);
		this.setVisible(true);
	}
}
