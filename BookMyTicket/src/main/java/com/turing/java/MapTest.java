package com.turing.java;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MapTest {

	public static void main(String[] args) {
		Set<Customer> customers = Customer.getAll();

		// get all emails
		customers.stream().map((Customer c) -> {
			return c.getEmail();
		}).forEach(System.out::println);
		
		// get all phone numbers.
		List<List<String>> all = customers.stream()
			.map(c -> c.getPhoneNos()).collect(Collectors.toList());
		all.forEach(System.out::println);
		
		List<String> phones = customers.stream()
		.flatMap(c -> c.getPhoneNos().stream()) 
		.collect(Collectors.toList());
		phones.forEach(System.out::println);

	}

}
