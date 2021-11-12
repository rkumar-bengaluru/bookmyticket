package com.turing.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.comparing;
public class T10 {

	private String name;
	private int age;

	public T10(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "{" + "name='" + name + '\'' + ", age=" + age + '}';
	}

	public static void main(String[] args) {
		List<T10> persons = new ArrayList<>(Arrays.asList(new T10("John", 15), new T10("Sam", 25), new T10("Will", 20),
				new T10("Dan", 20), new T10("Joe", 10)));
//		Collections.sort(persons, new Comparator<T10>() {
//			@Override
//			public int compare(T10 p1, T10 p2) {
//				return p1.getAge() - p2.getAge();
//			}
//		});

		persons.sort(comparing((T10::getName)));

		System.out.println(persons);
	}

}
