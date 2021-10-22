package com.sapient.resource;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.sapient.controllers.PartnerController;
import com.sapient.controllers.SearchController;
import com.sapient.entity.Movie;
import com.sapient.entity.Slot;
import com.sapient.service.PartnerService;

@Component
public class MovieAssembler extends RepresentationModelAssemblerSupport<Movie, MovieResource> {

	@Autowired
	private PartnerService service;

	public MovieAssembler(PartnerService serv) {
		super(SearchController.class, MovieResource.class);
		this.service = serv;
	}

	@Override
	public MovieResource toModel(Movie entity) {
		MovieResource model = instantiateModel(entity);

		model.add(linkTo(methodOn(SearchController.class).findMovie(entity.getId())).withSelfRel());

		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setLanguage(entity.getLanguage());
		model.setStatus(entity.getStatus());
		model.setSlots(toScreenModel(service.findSlotByModie(entity.getId())));
		return model;
	}

	@Override
	public CollectionModel<MovieResource> toCollectionModel(Iterable<? extends Movie> entities) {
		CollectionModel<MovieResource> actorModels = super.toCollectionModel(entities);

		actorModels.add(linkTo(methodOn(PartnerController.class).all()).withSelfRel());

		return actorModels;
	}
	private List<SlotResource> toScreenModel( Set<Slot> theatres) {
		if (theatres.isEmpty())
			return Collections.emptyList();

		List<SlotResource> all = theatres.stream().map(theatre -> {
			SlotResource r = new SlotResource();
			r.setId(theatre.getId());
			r.setStartTime(theatre.getStart());
			r.setEndTime(theatre.getEnd());
			r.add(linkTo(methodOn(SearchController.class).findMovie(theatre.getId())).withSelfRel());
			return r;
		}).collect(Collectors.toList());
		return all;
	}
}
