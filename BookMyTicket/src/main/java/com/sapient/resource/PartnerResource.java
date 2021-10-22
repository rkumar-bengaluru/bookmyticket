package com.sapient.resource;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class PartnerResource extends RepresentationModel<PartnerResource>{
	
	private Long id;
	private String name;
	
	private List<TheatreResource> theatres;

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

	public List<TheatreResource> getTheatres() {
		return theatres;
	}

	public void setTheatres(List<TheatreResource> theatres) {
		this.theatres = theatres;
	}

}
