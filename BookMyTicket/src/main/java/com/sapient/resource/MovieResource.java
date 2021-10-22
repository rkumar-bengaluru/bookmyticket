package com.sapient.resource;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class MovieResource extends RepresentationModel<MovieResource>{
	private Long id;
	private String name;
	private List<SlotResource> slots;
	private String language;
	private String status;
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<SlotResource> getSlots() {
		return slots;
	}
	public void setSlots(List<SlotResource> slots) {
		this.slots = slots;
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
	
}
