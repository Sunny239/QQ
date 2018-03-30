package com.myqq.message.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.myqq.entity.Message;
import com.myqq.util.ConnectionUtil;
import com.mysql.jdbc.Statement;

public class MessageDao {
	public void saveMessage(Message message){
		Connection con = null;
		PreparedStatement ps= null;
		
		try {
			con = ConnectionUtil.getCon();
			ps = con.prepareStatement("insert into messages(id,content,sender,senderIp,sendTime,receiver,receiverIp) values(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, ps.RETURN_GENERATED_KEYS);
			ps.setString(2, message.getContent());
			ps.setInt(3, message.getSender());
			ps.setString(4, message.getSenderIp());
			ps.setDate(5, (Date) message.getSendTime());
			ps.setInt(6, message.getReceiver());
			ps.setString(7, message.getReceiverIp());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("消息存入数据库出错");
		} finally {
			ConnectionUtil.CloseCon(null, ps, con);
		}
	}
}
