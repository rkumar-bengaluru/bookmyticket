package com.turing.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
public class T16 implements  Runnable {
	
	public T16() {
	}
	class Super {
		void foo() {
			System.out.println("Foo");
		}
	}
	
	class Anoter {
		void foo() {}
	}
	
	
	class Child extends Super {
		void foo() {
			System.out.println("Child");
			
		}
	}
	
	abstract class Parent {
		
		abstract void show();
		public int a;
		
		Parent() {
			a = 10;
		}
		
		abstract public void get();
	}
	
	interface Test {
		void doit();
	}
	
	static class Sorting implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
		
	}
	
	public static void main(char args[]) {
		System.out.println('a');
	}

	public static void main(String[] args) {
		T16 t = new T16();
		Thread th = new Thread(t);
		th.start();	
		List<String> list1 = new ArrayList<>();	
		list1.add("foo");

		List<String> list2 = list1;
		List<String> list3 = new ArrayList<>(list2); // foo
		list1.clear(); // []
		list2.add("bar"); // bar
		list3.add("baz"); // foo,baz
		
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		
		System.out.println(list1 == list2);
		Integer a[] = {2,3,1};
		List<Integer> list = Arrays.asList(a);
		list.sort(new Sorting());
		System.out.println(list);
		
		// 24
		Stack<String> stack = new Stack<>();
		Queue<String> queue = new LinkedList<>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		queue.add(stack.pop()); // AB -- C 
		
		stack.push("D");
		stack.push("E"); // ABDE -- C
		queue.add("F");// ABDE -- CF
		
		stack.push(( (LinkedList<String>)queue).remove()); // ABDEC -- F
		System.out.println(stack);
		System.out.println(queue);
		( (LinkedList<String>)queue).add(stack.pop()); 
		queue.add(stack.pop()); // ABD -- FCE
		
		System.out.println(stack); // AB
		System.out.println(queue);// F
		
		String x = "abc";
		String y = "abc";
		String z = x.concat(y);
		System.out.println(z);
		
		
		
		box b1 = t.new box();
		box b2 = t.new box();
		b1.height = 1;
		b1.width= 2;
		b1.length = 3;
		
		b2 = b1;
		System.out.println(b2.height);
		
		Set<Integer> set = new TreeSet<Integer>();
		set.add(3);
		set.add((int)3.0);
		set.add(2);
		set.add(2);
		set.add(new Integer(2));
		set.add(Integer.parseInt("2"));
		System.out.println(set);
		
		int[] ab = {1,2,3};
		int b[];
		
		
		th.start();
	}
	
	class box {
		int width;
		int height;
		int length;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		
	}
	
	public void a() {
		int a;
	}
	
	public void a(String s) {}

}
