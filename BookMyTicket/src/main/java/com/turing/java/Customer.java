package com.turing.java;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Customer {
	private Long id;
	private String name;
	private String email;
	private List<String> phoneNos;
	
	
	public Customer(Long id, String name, String email, List<String> phoneNos) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNos = phoneNos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getPhoneNos() {
		return phoneNos;
	}
	public void setPhoneNos(List<String> phoneNos) {
		this.phoneNos = phoneNos;
	}
	
	
	public static Set<Customer> getAll() {
		return Stream.of(
				new Customer(101L,"rupak","rupak@gmail.com",Arrays.asList("7847956039","123456789")),
				new Customer(101L,"aryan","aryan@gmail.com",Arrays.asList("9847956039","923456789"))
		).collect(Collectors.toSet());
	}
	
}
