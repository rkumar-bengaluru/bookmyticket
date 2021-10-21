package com.sapient.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.entity.Movie;
import com.sapient.entity.Partner;
import com.sapient.entity.Screen;
import com.sapient.entity.Theatre;

/**
 * Rest Interface for onboaring partners.
 * 
 * @author Rupak
 *
 */
@RestController
@RequestMapping("/partners")
public class PartnerController {
	/**
	 * create a new partner.
	 * 
	 * @param newPartner
	 * @returns
	 */
	@PostMapping("/partner")
	public Partner newPartner(@RequestBody Partner newPartner) {
		// TODO
		return null;
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
		// TODO
		return null;
	}
	/**
	 * Create a new screen for the partner's theatre.
	 * @param pid
	 * @param tid
	 * @param newScreen
	 * @return
	 */
	@PostMapping("/{pid}/{tid}/screen")
	public Screen newScreen(
			@PathVariable Long pid, 
			@PathVariable Long tid, 
			@RequestBody Screen newScreen) {
		// TODO
		return null;
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
		// TODO
		return null;
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
	public Movie updateMovie(
			@PathVariable Long pid, 
			@PathVariable Long tid, 
			@PathVariable Long sid,
			@PathVariable Long mid,
			@RequestBody Movie updateMovie) {
		return null;
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
	public Partner deleteMovie(
			@PathVariable Long pid, 
			@PathVariable Long tid, 
			@PathVariable Long sid,
			@PathVariable Long mid) {
		return null;
	}
}
