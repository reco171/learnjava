package com.reco.learnjava.basis;

/**
 * java symbol
 * Java的位运算符详解实例——与（&）、非（~）、或（|）、异或（^）
 * @author Administrator
 *
 */
public class TestJavaSymbol {
	public static void main(String[] args) {
		int a = 3;
		int b =2;
		System.out.println("&: " + (3&2)); //0000 0011 & 0000 0010
		System.out.println("~: " + (~3));
		System.out.println("|: " + (3|2));
		System.out.println("^: " + (3^2));
		//十进制转二进制， -5
		//5: 0000 0101；取反 1111 1010；加1 1111 1011
		System.out.println(Integer.toBinaryString(-5));
		
		//-3的二进制， 3取反
		//0000 0011， 1111 1100， 1111 1101
		System.out.println("-3的二进制， 3取反:");
		System.out.println(Integer.toBinaryString(-3));
		System.out.println(Integer.toBinaryString(~3));
	}
}
