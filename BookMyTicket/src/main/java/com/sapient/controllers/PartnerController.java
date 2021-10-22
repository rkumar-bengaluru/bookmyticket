package com.sapient.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sapient.entity.Movie;
import com.sapient.entity.Partner;
import com.sapient.entity.Screen;
import com.sapient.entity.Theatre;
import com.sapient.service.PartnerService;

/**
 * Rest Interface for onboaring partners.
 * 
 * @author Rupak
 *
 */
@RestController
@RequestMapping("/partners")
public class PartnerController {
	private static final Log logger = LogFactory.getLog(PartnerController.class);
	@Autowired
	private PartnerService service;

	public PartnerController(PartnerService serv) {
		this.service = serv;
	}
	
	@GetMapping("/{pid}")
	public Partner getPartner(@PathVariable Long pid) {
		try {
			return service.getPartner(pid);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}
	
	@GetMapping("/")
	public List<Partner> all() {
		try {
			return service.getAllPartners();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	/**
	 * create a new partner.
	 * 
	 * @param newPartner
	 * @returns
	 */
	@PostMapping("/partner")
	public Partner newPartner(@RequestBody Partner newPartner) {
		try {
			return service.createPartner(newPartner);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	/**
	 * Create a new theatre for the partner.
	 * 
	 * @param partnerId
	 * @param newPartner
	 * @return
	 */
	@PostMapping("/{pid}/theatre")
	public Theatre newTheatre(@PathVariable Long pid, @RequestBody Theatre newTheatre) {
		try {
			return service.createTheater(pid, newTheatre);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	/**
	 * Create a new screen for the partner's theatre.
	 * 
	 * @param pid
	 * @param tid
	 * @param newScreen
	 * @return
	 */
	@PostMapping("/{pid}/{tid}/screen")
	public Screen newScreen(@PathVariable Long pid, @PathVariable Long tid, @RequestBody Screen newScreen) {
		try {
			return service.createScreen(pid, tid, newScreen);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	/**
	 * create a new movie for the partner theatre screen.
	 * 
	 * @param pid
	 * @param tid
	 * @param sid
	 * @param newMovie
	 * @return
	 */
	@PostMapping("/{pid}/{tid}/{sid}/movie")
	public Movie newMovie(
			@PathVariable Long pid, 
			@PathVariable Long tid, 
			@PathVariable Long sid,
			@RequestBody Movie newMovie) {
		try {
			return service.createMovie(pid, tid, sid, newMovie);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	/**
	 * Update a movie.
	 * 
	 * @param pid
	 * @param tid
	 * @param sid
	 * @param mid
	 * @param updateMovie
	 * @return
	 */
	@PutMapping("/{pid}/{tid}/{sid}/{mid}")
	public Movie updateMovie(@PathVariable Long pid, @PathVariable Long tid, @PathVariable Long sid,
			@PathVariable Long mid, @RequestBody Movie updateMovie) {
		try {
			return service.updateMovie(pid, tid, sid, updateMovie);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	/**
	 * Delete a movie from the screen.
	 * 
	 * @param pid
	 * @param tid
	 * @param sid
	 * @param mid
	 * @return
	 */
	@DeleteMapping("/{pid}/{tid}/{sid}/{mid}")
	public Movie deleteMovie(@PathVariable Long pid, @PathVariable Long tid, @PathVariable Long sid,
			@PathVariable Long mid) {
		try {
			logger.info(mid);
			return service.deleteMovie(mid);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}
}
