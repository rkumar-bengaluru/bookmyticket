package com.sapient.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.entity.Movie;
import com.sapient.entity.Partner;
import com.sapient.entity.Screen;
import com.sapient.entity.Seat;
import com.sapient.entity.Slot;
import com.sapient.entity.Theatre;
import com.sapient.respository.MovieRepository;
import com.sapient.respository.PartnerJPARepository;
import com.sapient.respository.ScreenRepository;
import com.sapient.respository.SeatRepository;
import com.sapient.respository.SlotRepository;
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
	@Autowired
	private SlotRepository slotRepo;
	@Autowired
	private SeatRepository seatRepo;
	public PartnerService(PartnerJPARepository p, TheatreRepository t, ScreenRepository s, MovieRepository m,SlotRepository sl,SeatRepository sr) {
		this.partnerRepo = p;
		this.theatreRepo = t;
		this.screenRepo = s;
		this.movieRepo = m;
		this.slotRepo = sl;
		this.seatRepo = sr;
	}
	
	public Set<Slot> findSlotByModie(Long mid) {
		return this.slotRepo.findByMovieId(mid);
	}
	
	public List<Partner> getAllPartners() {
		return this.partnerRepo.findAll();
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
	public Set<Theatre> findTheatreByPartnerId(Long pid) {
		return this.theatreRepo.findByPartnerId(pid);
	}
	public Screen createScreen(Long pid, Long tid, Screen newScreen) {
		Theatre t = this.theatreRepo.findById(tid).get();
		newScreen.setTheatre(t);
		return this.screenRepo.save(newScreen);
	}
	public Set<Screen> findByTheatreId(Long pid) {
		return this.screenRepo.findByTheatreId(pid);
	}
	public Screen findScreen(Long mid) {
		return this.screenRepo.findById(mid).get();
	}
	public Movie createMovie(Long pid, Long tid, Long sid, Movie newMovie) {
		Screen s = this.screenRepo.findById(sid).get();
		newMovie.setScreen(s);
		return this.movieRepo.save(newMovie);
	}
	public Set<Movie> findByScreenId(Long pid) {
		return this.movieRepo.findByScreenId(pid);
	}
	
	public Movie findMovie(Long mid) {
		return this.movieRepo.findById(mid).get();
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
	
	public List<Movie> findAllRunningMovies() {
		return this.movieRepo.findAll();
	}
	
	public Set<Seat> findSeatsByScreen(Long sid) {
		return this.seatRepo.findSeatByScreenId(sid);
	}
}
