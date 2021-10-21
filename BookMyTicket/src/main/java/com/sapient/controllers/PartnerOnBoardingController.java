package com.sapient.controllers;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.entity.Partner;

/**
 * Rest Interface for onboaring partners.
 * 
 * @author Rupak
 *
 */
@RestController
@RequestMapping("/partners")
public class PartnerOnBoardingController {
	/**
	 * create a new partner.
	 * 
	 * @param newPartner
	 * @return
	 */
	@PostMapping("/partner")
	public Partner newPartner(@RequestBody Partner newPartner) {
		return null;
	}
	
	/**
	 * fetch all partners with default return size as 10.
	 * 
	 * @return
	 */
	@GetMapping("")
	public ResponseEntity<CollectionModel<EntityModel<Partner>>> all(
			@RequestParam(value = "size", defaultValue = "10") int size) {
		return null;
	}

	/**
	 * fetch partner by id.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/partner/{id}")
	public ResponseEntity<EntityModel<Partner>> findOne(@PathVariable Long id) {
		return null;
	}
	
	/**
	 * Update existing partner.
	 * 
	 * @param id
	 * @return
	 */
	@PutMapping("/partner/{id}")
	public Partner updatePartner(@PathVariable Long id) {
		return null;
	}
	/**
	 * Delete a partner.
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/partner/{id}")
	public Partner deletePartner(@PathVariable Long id) {
		return null;
	}
}
