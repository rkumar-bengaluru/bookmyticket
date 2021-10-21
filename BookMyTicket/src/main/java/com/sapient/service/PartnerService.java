package com.sapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.entity.Movie;
import com.sapient.entity.Partner;
import com.sapient.entity.Screen;
import com.sapient.entity.Theatre;
import com.sapient.respository.MovieRepository;
import com.sapient.respository.PartnerJPARepository;
import com.sapient.respository.ScreenRepository;
import com.sapient.respository.TheatreRepository;

@Service
public class PartnerService {
	@Autowired
	private PartnerJPARepository partnerRepo;
	@Autowired
	private TheatreRepository theatreRepo;
	@Autowired
	private ScreenRepository screenRepo;
	@Autowired
	private MovieRepository movieRepo;

	public PartnerService(PartnerJPARepository p, TheatreRepository t, ScreenRepository s, MovieRepository m) {
		this.partnerRepo = p;
		this.theatreRepo = t;
		this.screenRepo = s;
		this.movieRepo = m;
	}
	
	public Partner getPartner(Long id) {
		return this.partnerRepo.findById(id).get();
	}

	public Partner createPartner(Partner p) {
		return partnerRepo.save(p);
	}

	public Theatre createTheater(Long pid, Theatre t) {
		Partner p = this.partnerRepo.findById(pid).get();
		t.setPartner(p);
		return theatreRepo.save(t);
	}

	public Screen createScreen(Long pid, Long tid, Screen newScreen) {
		Theatre t = this.theatreRepo.findById(tid).get();
		newScreen.setTheatre(t);
		return this.screenRepo.save(newScreen);
	}

	public Movie createMovie(Long pid, Long tid, Long sid, Movie newMovie) {
		Screen s = this.screenRepo.findById(sid).get();
		newMovie.setScreen(s);
		return this.movieRepo.save(newMovie);
	}

	public Movie updateMovie(Long pid, Long tid, Long sid, Movie newMovie) {
		Screen s = this.screenRepo.findById(sid).get();
		newMovie.setScreen(s);
		return this.movieRepo.save(newMovie);
	}

	public Movie deleteMovie(Long mid) {
		Movie m = this.movieRepo.findById(mid).get();
		this.movieRepo.delete(m);
		return m;
	}
}
