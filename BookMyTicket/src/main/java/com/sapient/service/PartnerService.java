package com.sapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.entity.Partner;
import com.sapient.respository.PartnerJPARepository;

@Service
public class PartnerService {
	@Autowired
	private PartnerJPARepository repository;

	public PartnerService(PartnerJPARepository r) {
		this.repository = r;
	}

	public Partner createPartner(Partner p) {
		return repository.save(p);
	}

//	public Theatre createTheater(Long pid, Theatre t) {
//		return repository.createTheater(pid, t);
//	}
//
//	public Screen createScreen(Long pid, Long tid, Screen newScreen) {
//		return repository.createScreen(pid, tid, newScreen);
//	}
//
//	public Movie createMovie(Long pid, Long tid, Long sid, Movie newMovie) {
//		return repository.createMovie(pid, tid, sid, newMovie);
//	}
//
//	public Movie updateMovie(Long pid, Long tid, Long sid, Movie newMovie) {
//		return repository.createMovie(pid, tid, sid, newMovie);
//	}
//
//	public Movie deleteMovie(Long mid) {
//		return repository.deleteMovie(mid);
//	}
}
