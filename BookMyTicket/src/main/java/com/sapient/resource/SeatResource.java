package com.sapient.resource;

import org.springframework.hateoas.RepresentationModel;

import com.sapient.entity.State;

public class SeatResource extends RepresentationModel<SeatResource> {
	private Long id;
	private Integer row;
	private String no;
	private State state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
