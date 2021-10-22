package com.sapient.resource;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class ScreenResource extends RepresentationModel<ScreenResource>{
	private Long id;
	private String name;
	private List<MovieResource> movies;
	public List<MovieResource> getMovies() {
		return movies;
	}
	public void setMovies(List<MovieResource> movies) {
		this.movies = movies;
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
