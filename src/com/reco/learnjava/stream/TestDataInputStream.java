package com.reco.learnjava.stream;
/**
 * http://blog.csdn.net/woshixuye/article/details/8432579
 * DataInputStream
 * 数据输入流允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TestDataInputStream {

		public static void main(String[] args) throws Exception
		{
			TestDataInputStream t = new TestDataInputStream();
			t.write();
			t.read();
		}

		public void write() throws Exception
		{
			System.out.println(this.getClass().getClassLoader().getResource(""));
			String path = this.getClass().getClassLoader().getResource("test.txt").toURI().getPath();
			OutputStream os = new FileOutputStream(path);
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeDouble(Math.random());
			dos.writeBoolean(true);
			dos.writeInt(1000);
			dos.writeInt(2000);
			dos.writeUTF("hello world中国");
			dos.flush();
			os.close();
			dos.close();
		}

		public void read() throws Exception
		{
			InputStream instream = this.getClass().getClassLoader().getResourceAsStream("test.txt");
			DataInputStream dis = new DataInputStream(instream);
			double d = dis.readDouble();
			boolean b = dis.readBoolean();
			// 先写的先被读出来
			int i1 = dis.readInt();
			int i2 = dis.readInt();
			String s = dis.readUTF();
			instream.close();
			dis.close();
			System.out.println(d);
			System.out.println(b);
			System.out.println(i1);
			System.out.println(i2);
			System.out.println(s);
		}

}