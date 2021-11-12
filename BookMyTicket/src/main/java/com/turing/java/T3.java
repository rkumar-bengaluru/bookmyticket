package com.turing.java;

public class T3 {

	public static void main(String[] args) {
		int x, y, z;
		x = 9;
		y = 10;
		z = ++x + y++; // y = 11, x = 10, z = 20
		System.out.println("z->" + z + ", y ->" + y + ", x ->" + x);
	}

}
