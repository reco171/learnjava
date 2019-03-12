package com.reco.learnjava.serial;
/**
 * 参考之一：http://blog.csdn.net/jiangwei0910410003/article/details/18989711/
 * java 序列化
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ObjectOutputStream.PutField;

public class TestWriteObject implements Serializable {
	 private static final long serialVersionUID = 1L;
	 	private String username = "user1";
		private String password = "pass";

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
	    @Override 
	    public String toString() {  
	        return "[" + username + ", "  + password + "]";  
	    }  
		private void writeObject(ObjectOutputStream out) {
			try {
				PutField putFields = out.putFields();
				System.out.println("原密码:" + password);
				password = "encryption";//模拟加密
				putFields.put("password", password);
				putFields.put("username", username);
				System.out.println("加密后的密码" + password);
				out.writeFields();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void readObject(ObjectInputStream in) {
			try {
				GetField readFields = in.readFields();
				Object object = readFields.get("password", "");
				System.out.println("要解密的字符串:" + object.toString());
				password = "pass";//模拟解密,需要获得本地的密钥
				username = readFields.get("username", "username").toString();
				System.out.println("username:" + username);

			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}

		public static void main(String[] args) {
			try {
				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream("result.obj"));
				out.writeObject(new TestWriteObject());
				out.close();

				ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
						"result.obj"));
				TestWriteObject t = (TestWriteObject) oin.readObject();
				System.out.println("----解密后的字符串----:" + t.getPassword());
				System.out.println(t.toString());
				oin.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
}
