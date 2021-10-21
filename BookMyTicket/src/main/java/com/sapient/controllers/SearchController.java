package com.sapient.controllers;

import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.entity.Movie;
import com.sapient.entity.Screen;
import com.sapient.entity.Theatre;
import com.sapient.respository.TheatreRepository;

/**
 * Rest interface for end user's lookup queries.
 * 
 * @author Rupak
 *
 */
@RestController
@RequestMapping("/search")
public class SearchController {
	private static final Log logger = LogFactory.getLog(SearchController.class);
	@Autowired
	private TheatreRepository trepo;

	public SearchController(TheatreRepository tr) {
		this.trepo = tr;
	}

	/**
	 * Search the theatres which is currently showing movies.
	 * 
	 * @param size
	 * @return
	 */
	@GetMapping("")
	public ResponseEntity<CollectionModel<EntityModel<Theatre>>> findTheaters(
			@RequestParam(value = "size", defaultValue = "10") int size) {
		logger.info("findTheatres");
		// TODO
		return null;
	}

	/**
	 * return all screens for the particular theatre.
	 * 
	 * @param size
	 * @return
	 */
	@GetMapping("/{tid}")
	public ResponseEntity<CollectionModel<EntityModel<Screen>>> findScreens(
			@RequestParam(value = "size", defaultValue = "10") int size, @PathVariable Long tid) {
		logger.info("findScreens");
		// TODO
		return null;
	}

	@GetMapping("/{tid}/{sid}")
	public ResponseEntity<CollectionModel<EntityModel<Movie>>> findMovies(
			@RequestParam(value = "size", defaultValue = "6") int size, @PathVariable Long tid,
			@PathVariable Long sid) {
		logger.info("findMovies");
		// TODO
		return null;
	}

	@GetMapping("th/{tid}")
	public Set<Theatre> findTheatreByPartnerId(@PathVariable Long tid) {
		logger.info("findTheatreByPartnerId ->" + tid);
		Set<Theatre> all = trepo.findByPartnerId(tid);
		return all;
	}
}
