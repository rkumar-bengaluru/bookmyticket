package com.sapient.resource;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class TheatreResource extends RepresentationModel<TheatreResource>{
	private Long id;
	private String name;
	private String address;
	private String city;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	private List<ScreenResource> screens;
	public Long getId() {
		return id;
	}
	public List<ScreenResource> getScreens() {
		return screens;
	}
	public void setScreens(List<ScreenResource> screens) {
		this.screens = screens;
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
	
}
