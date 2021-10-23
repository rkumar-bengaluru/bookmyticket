package com.sapient.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "partners")
public class Partner {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "partner_id")
	private List<Theatre> theatres = new ArrayList<>();

	public List<Theatre> getTheatres() {
		return theatres;
	}

	public void setTheatres(List<Theatre> theatres) {
		this.theatres = theatres;
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

	public Partner() {
		super();
	}

	public Partner(Long id, String name, List<Theatre> theaters) {
		super();
		this.id = id;
		this.name = name;
	}

}
