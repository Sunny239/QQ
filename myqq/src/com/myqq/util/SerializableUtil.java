package com.myqq.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.myqq.entity.Message;

public class SerializableUtil {
	public static byte[] serializable(Message m) throws Exception{
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(m);;
			return bos.toByteArray();
		} finally {
			if (bos != null) {
				bos.close();
			}
			if (oos != null) {
				oos.close();
			}
		}
	}
	public static Message unSerializable(byte[] b) throws Exception{
		ByteArrayInputStream bas = null;
		ObjectInputStream ois = null;
		try {
			bas = new ByteArrayInputStream(b);
			ois = new ObjectInputStream(bas);
			return (Message)ois.readObject();
		} finally {
			if (bas != null) {
				bas.close();
			}
			if (ois != null) {
				ois.close();
			}
		}
	}
}
