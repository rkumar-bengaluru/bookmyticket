package com.sapient.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "screens")
public class Screen {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToMany(targetEntity = Movie.class)
	private List<Movie> movies;

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

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, movies, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screen other = (Screen) obj;
		return Objects.equals(id, other.id) && Objects.equals(movies, other.movies) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Screen [id=" + id + ", name=" + name + ", movies=" + movies + "]";
	}

	public Screen(Long id, String name, List<Movie> movies) {
		super();
		this.id = id;
		this.name = name;
		this.movies = movies;
	}

	public Screen() {
		super();
	}

}
