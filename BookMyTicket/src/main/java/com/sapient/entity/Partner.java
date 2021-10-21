package com.sapient.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "partners")
public class Partner {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
//	@OneToMany(targetEntity = Theatre.class)
//	private List<Theatre> theaters;

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
