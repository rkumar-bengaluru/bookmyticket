package com.turing.java;

public class T49 {
	public Integer divide(int a, int b) {
		try {
			return a / b;
		} finally {
			System.out.println("finally");
		}
	}
	
	public static void main(String[] args) {
		// 49
		T49 t49 = new T49();
		try {
			t49.divide(10, 0);
		}catch(Exception e) {
			System.out.println("Division by 0!");
		}
		// 01
//		int x = 9;
//		if(x ==9) {
//			int x = 8; // compile error.
//		}
		// 02
		
	}
}
