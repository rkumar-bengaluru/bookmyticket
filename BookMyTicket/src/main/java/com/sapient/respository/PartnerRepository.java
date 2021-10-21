package com.sapient.respository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.sapient.controllers.PartnerController;
import com.sapient.entity.Movie;
import com.sapient.entity.Partner;
import com.sapient.entity.Screen;
import com.sapient.entity.Theatre;

public class PartnerRepository {
	private static final Log logger = LogFactory.getLog(PartnerController.class);

	public Partner createPartner(Partner p) {
		return p;
	}

	public Theatre createTheater(Long pid, Theatre t) {
		return t;
	}

	public Screen createScreen(Long pid, Long tid,  Screen newScreen) {
		return newScreen;
	}

	public Movie createMovie(
			@PathVariable Long pid, 
			@PathVariable Long tid, 
			@PathVariable Long sid,
			@RequestBody Movie newMovie) {
		return newMovie;
	}
	
	public Movie updateMovie(
			@PathVariable Long pid, 
			@PathVariable Long tid, 
			@PathVariable Long sid,
			@RequestBody Movie newMovie) {
		return newMovie;
	}
	
	public Movie deleteMovie(
			@PathVariable Long mid) {
		return null;
	}
}
