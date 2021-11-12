package com.turing.java;

abstract class Animal  {
	public abstract void makeNoise();
	public abstract void move();
}

abstract class Canine extends Animal {
	public void wageTail() {
		System.out.println("wagging");
	}
	@Override
	public void move() {
		System.out.println("running");
	}
}

class Dog extends Canine {

	public void fetch() {
		System.out.println("fetch");
	}
	@Override
	public void makeNoise() {
		System.out.println("bark");
	}
	
}
public class T2 {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.makeNoise();
		dog.move();
		dog.wageTail();
		dog.fetch();
		
		Canine c = new Dog();
		c.makeNoise();
		c.move();
		c.wageTail();
		//c.fetch(); // compile error
		
		Animal a = new Dog();
		a.makeNoise();
		a.move();
		//a.wageTail();// compile error
		//a.fetch(); // compile error

	}

}
