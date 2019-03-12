package com.reco.learnjava.serial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private List<Friend> friends = new ArrayList<Friend>();
	public Student(){}
	public Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
    public List<Friend> getFriends() {
		return friends;
	}
	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}
	@Override 
    public String toString() {  
        return "[" + name + ", " + age + ", " + friends.size() + "]";  
    }  
}
