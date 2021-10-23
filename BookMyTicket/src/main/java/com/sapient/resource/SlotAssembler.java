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
import com.sapient.entity.Slot;
import com.sapient.entity.Theatre;
import com.sapient.service.PartnerService;

@Component
public class SlotAssembler extends RepresentationModelAssemblerSupport<Slot, SlotResource> {

	@Autowired
	private PartnerService service;

	public SlotAssembler(PartnerService serv) {
		super(SearchController.class, SlotResource.class);
		this.service = serv;
	}

	@Override
	public SlotResource toModel(Slot entity) {
		SlotResource model = instantiateModel(entity);

		model.add(linkTo(methodOn(SearchController.class).findScreen(entity.getId())).withSelfRel());

		model.setId(entity.getId());
		model.setStartTime(entity.getStart());
		model.setEndTime(entity.getEnd());
		return model;
	}

	@Override
	public CollectionModel<SlotResource> toCollectionModel(Iterable<? extends Slot> entities) {
		CollectionModel<SlotResource> actorModels = super.toCollectionModel(entities);

		actorModels.add(linkTo(methodOn(PartnerController.class).all()).withSelfRel());

		return actorModels;
	}


}
