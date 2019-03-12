package com.reco.learnjava.basis;

public class TestCharString {
public static void main(String[] args) {
	char[] test=new char[10];
	System.out.println(test.length);

    String a="abc"; char c[]={'a','b','c'};
    char d[] ={'a','b'};
    System.out.println(a.equals(c) );  
    
    System.out.println(a.equals(new String(c))); //  

    System.out.println(a.compareTo(new String(c)));
    System.out.println(new String(d).compareTo(new String(c)));

}
}
