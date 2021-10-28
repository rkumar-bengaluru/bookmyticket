package com.turing;

import java.util.Stack;

public class Turing3 {
	
	public int baseball(String[] input) {
		int sum = 0;
		Stack<String> stack = new Stack<>();
		for(int i = 0; i <= input.length - 1; i++) {
			if(input[i].equals("C")) {
				if(stack.size() > 0) {
					stack.pop();
				}
			} else if(input[i].equals("D")) {
				if(stack.size() > 0) {
					Integer t = Integer.parseInt(stack.peek()) * 2;
					stack.push(t.toString());
				}
			} else if(input[i].equals("+")) {
				if(stack.size() > 1) {
					Integer r = Integer.parseInt(stack.get(stack.size() -1)) + 
							Integer.parseInt(stack.get(stack.size() -2));
					stack.push(r.toString());
				}
			} else {
				stack.push(input[i]);
			}
		}
		
		for(int i = 0; i <= stack.size() -1;i++) {
			sum += Integer.parseInt(stack.get(i));
		}
		return sum;
	}

	public static void main(String[] args) {
		try {
			String[] input = { "5","2","C","D","+" };
			String[] ainput = {"5", "-2","4","C","D","9","+","+"};
			Turing3 t = new Turing3();
			System.out.println(t.baseball(input));
			System.out.println(t.baseball(ainput));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
