package com.turing.java;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class T4 {

	public static void main(String[] args) {
		List<String> countries = Arrays.asList("Germany","England","China","Denmark","Brazil","France","Australia");
		Optional<String> countryName = countries.stream().reduce((c1,c2) -> c1.length() > c2.length() ? c1:c2);
		countryName.ifPresent(System.out::println);
	}

}
