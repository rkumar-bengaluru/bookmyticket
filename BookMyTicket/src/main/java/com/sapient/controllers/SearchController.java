package com.sapient.controllers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.entity.Movie;
import com.sapient.entity.Partner;
import com.sapient.entity.Screen;
import com.sapient.entity.Theatre;
import com.sapient.resource.MovieAssembler;
import com.sapient.resource.MovieResource;
import com.sapient.resource.PartnerResouceAssember;
import com.sapient.resource.PartnerResource;
import com.sapient.resource.ScreenAssembler;
import com.sapient.resource.ScreenResource;
import com.sapient.resource.TheatreAssembler;
import com.sapient.resource.TheatreResource;
import com.sapient.service.PartnerService;

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
	private PartnerService service;
	@Autowired
	private PartnerResouceAssember passembler;
	@Autowired
	private TheatreAssembler tassembler;
	@Autowired
	private ScreenAssembler sassembler;
	@Autowired
	private MovieAssembler massembler;

	public SearchController(
			PartnerService tr, 
			PartnerResouceAssember a, 
			TheatreAssembler t,
			ScreenAssembler s,
			MovieAssembler m) {
		this.service = tr;
		this.passembler = a;
		this.tassembler = t;
		this.sassembler = s;
		this.massembler = m;
	}

	/**
	 * Get all partners.
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<CollectionModel<PartnerResource>> getAllActors() {
		List<Partner> partners = service.getAllPartners();
		return new ResponseEntity<>(passembler.toCollectionModel(partners), HttpStatus.OK);
	}

	@GetMapping("/partner/{pid}")
	public ResponseEntity<CollectionModel<TheatreResource>> 
		findTheatersOfPartner(@PathVariable Long pid) {
		Set<Theatre> theatres = service.findTheatreByPartnerId(pid);
		return new ResponseEntity<>(tassembler.toCollectionModel(theatres), HttpStatus.OK);
	}
	
	@GetMapping("/theater/{tid}")
	public ResponseEntity<CollectionModel<TheatreResource>> 
		findScreensOfTheatres(@PathVariable Long tid) {
		Set<Theatre> theatres = service.findTheatreByPartnerId(tid);
		return new ResponseEntity<>(tassembler.toCollectionModel(theatres), HttpStatus.OK);
	}
	
	@GetMapping("/screen/{tid}")
	public ResponseEntity<ScreenResource> 
		findScreen(@PathVariable Long tid) {
		Screen screen = service.findScreen(tid);
		return new ResponseEntity<>(sassembler.toModel(screen), HttpStatus.OK);
	}
	
	@GetMapping("/movie/{mid}")
	public ResponseEntity<MovieResource> 
		findMovie(@PathVariable Long mid) {
		Movie movie = service.findMovie(mid);
		return new ResponseEntity<>(massembler.toModel(movie), HttpStatus.OK);
	}

	@GetMapping("/movie/active")
	public ResponseEntity<CollectionModel<MovieResource>> 
		findRunningShows() {
		List<Movie> movies = service.findAllRunningMovies();
		List<Movie> active = movies.stream().filter(
				m -> {
					logger.info("movie status " + m.getStatus());
					return m.getStatus().equals("RUNNING");
				}).collect(Collectors.toList());
		return new ResponseEntity<>(massembler.toCollectionModel(active), HttpStatus.OK);
	}
}
