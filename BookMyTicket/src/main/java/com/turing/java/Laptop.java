package com.turing.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Laptop  {
	private String brand;
	private short ram;
	private int price;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public short getRam() {
		return ram;
	}
	public void setRam(short ram) {
		this.ram = ram;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Laptop(String brand, short ram, int price) {
		super();
		this.brand = brand;
		this.ram = ram;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [brand=" + brand + ", ram=" + ram + ", price=" + price + "]";
	}
	
	public static void main(String... args) {
		try {
			List<Laptop> laps = Arrays.asList(
					new Laptop("Dell", (short)16, 16000),
					new Laptop("Apple", (short)8, 40000),
					new Laptop("Acer", (short)8, 30000)
					);
			//Collections.sort(laps);
			//laps.forEach(System.out::println);
			
			Collections.sort(laps, (l1,l2) -> {
				if(l1.ram == l2.ram)
					return 0;
				return l1.ram > l2.ram ? 1 : -1;
			});
			laps.forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//	//@Override
//	public int compareTo(Laptop o) {
//		if(this.ram == o.ram)
//			return 0;
//		return this.ram > o.ram ? 1 : -1;
//	}
	
	
}
