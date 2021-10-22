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
import com.sapient.entity.Screen;
import com.sapient.entity.Theatre;
import com.sapient.service.PartnerService;

@Component
public class TheatreAssembler extends RepresentationModelAssemblerSupport<Theatre, TheatreResource> {

	@Autowired
	private PartnerService service;

	public TheatreAssembler(PartnerService serv) {
		super(SearchController.class, TheatreResource.class);
		this.service = serv;
	}

	@Override
	public TheatreResource toModel(Theatre entity) {
		TheatreResource model = instantiateModel(entity);

		model.add(linkTo(methodOn(SearchController.class).findScreens(entity.getId())).withSelfRel());

		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setAddress(entity.getAddress());
		model.setCity(entity.getCity());
		model.setScreens(toScreenModel(service.findByTheatreId(entity.getId()),entity.getId()));
		return model;
	}

	@Override
	public CollectionModel<TheatreResource> toCollectionModel(Iterable<? extends Theatre> entities) {
		CollectionModel<TheatreResource> actorModels = super.toCollectionModel(entities);

		actorModels.add(linkTo(methodOn(PartnerController.class).all()).withSelfRel());

		return actorModels;
	}

	private List<ScreenResource> toScreenModel(Set<Screen> screens, Long tid) {
		if (screens.isEmpty())
			return Collections.emptyList();

		List<ScreenResource> all = screens.stream().map(screen -> {
			ScreenResource r = new ScreenResource();
			r.setId(screen.getId());
			r.setName(screen.getName());
			r.add(linkTo(methodOn(SearchController.class).findScreen(screen.getId())).withSelfRel());
			return r;
		}).collect(Collectors.toList());
		return all;
	}

}
