package com.reco.learnjava.serial;

import java.io.Serializable;

public class Friend implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	public Friend(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    @Override 
    public String toString() {  
        return "[" + name + "]";  
    }  
}
