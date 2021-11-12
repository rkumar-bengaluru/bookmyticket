package com.turing.java;

public class T55 extends T5{
	{
		System.out.println("C");
	}
	
	static {
		System.out.println("D");
	}
	
	public static void main(String[] args) {
		new T55();
		double x = 22.9;
		System.out.println(Math.floor(x));
		System.out.println(Math.ceil(x));
		System.out.println(Math.rint(x));
		System.out.println(Math.round(x));
		System.out.println(Math.abs(x));
	}

}
