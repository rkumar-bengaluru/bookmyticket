package com.turing;

public class OnlineTest extends Thread {
	
	class B {
		public B() {System.out.println("B");}
	}
	class A {
		private B b = new B();
		public A() {System.out.println("A");}
	}
	
	{
		System.out.println("sssssss");
	}
	
	static {
		int x = 5;
	}
	static void abc() {
		y= x++ + ++x;
	}
	static int x,y;
	
	static int cde() {
		return 5;
	}
	static String s = "";
	static void abcd(int s) {
		System.out.println(s);
		
		class C {}
	}
	public static void main(String[] args) {
		try 
		{
			int a = 5;
			System.out.println("Value " + ((a < 5) ? 9.9 : 7.1));
			x--;
			System.out.println(x);
			abc();
			System.out.println(x + y + ++x);
			int i = 1;
			assert i > 0 : cde();
			
			System.out.println(s instanceof String);
			char c = 'e';
			System.out.println(c);
			abcd(c);
			
			OnlineTest t = new OnlineTest();
			t.new A();
			
			boolean ax = true;
			
		}
		catch (NumberFormatException e) /* Line 9 */
		{
		    System.out.println("bad number"); /* Line 11 */
		}
		float f1 = -343;
		
	}

}
