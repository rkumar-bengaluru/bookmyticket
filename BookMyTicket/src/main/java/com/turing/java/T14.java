package com.turing.java;

public class T14 {

	class Super {
		private void foo() {
			System.out.println("Super");
		}
	}
	
	class SubClass extends Super {
		public void foo() {
			System.out.println("SubClass");
		}
	}
	public static void main(String[] args) {
		T14 t = new T14();
		Super s = t.new Super();
		s.foo();
		
		SubClass c = t.new SubClass();
		c.foo();

	}

}
