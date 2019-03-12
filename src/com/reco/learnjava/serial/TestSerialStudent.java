package com.reco.learnjava.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerialStudent {
	public static void main(String[] args) {
		File file = new File("person.out");  
		try {
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
			Student s = new Student("LiLei", 29);
			Friend f1 = new Friend("f1");
			Friend f2 = new Friend("f2");
			s.getFriends().add(f1);
			s.getFriends().add(f2);
			oout.writeObject(s);  
			oout.close();  
			
	        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));  
	        Object newPerson = oin.readObject(); // û��ǿ��ת����Person����  
	        oin.close();  
	        System.out.println(newPerson);  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
