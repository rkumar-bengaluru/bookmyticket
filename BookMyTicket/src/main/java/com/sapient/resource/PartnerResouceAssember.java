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
import com.sapient.entity.Partner;
import com.sapient.entity.Theatre;
import com.sapient.service.PartnerService;

@Component
public class PartnerResouceAssember extends RepresentationModelAssemblerSupport<Partner, PartnerResource> {

	@Autowired
	private PartnerService service;

	public PartnerResouceAssember(PartnerService serv) {
		super(SearchController.class, PartnerResource.class);
		this.service = serv;
	}

	@Override
	public PartnerResource toModel(Partner entity) {
		PartnerResource model = instantiateModel(entity);

		model.add(linkTo(methodOn(SearchController.class).findTheatersOfPartner(entity.getId())).withSelfRel());

		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setTheatres(toTheatreModel(entity.getId(), service.findTheatreByPartnerId(entity.getId())));
		return model;
	}

	@Override
	public CollectionModel<PartnerResource> toCollectionModel(Iterable<? extends Partner> entities) {
		CollectionModel<PartnerResource> actorModels = super.toCollectionModel(entities);

		actorModels.add(linkTo(methodOn(PartnerController.class).all()).withSelfRel());

		return actorModels;
	}

	private List<TheatreResource> toTheatreModel(Long pid, Set<Theatre> theatres) {
		if (theatres.isEmpty())
			return Collections.emptyList();

		List<TheatreResource> all = theatres.stream().map(theatre -> {
			TheatreResource r = new TheatreResource();
			r.setId(theatre.getId());
			r.setName(theatre.getName());
			r.add(linkTo(methodOn(SearchController.class).findScreensOfTheatres(theatre.getId())).withSelfRel());
			return r;
		}).collect(Collectors.toList());
		return all;
	}

}
