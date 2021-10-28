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
import com.sapient.entity.Screen;
import com.sapient.entity.Seat;
import com.sapient.entity.Slot;
import com.sapient.service.PartnerService;

@Component
public class ScreenAssembler extends RepresentationModelAssemblerSupport<Screen, ScreenResource> {

	@Autowired
	private PartnerService service;
	
	public ScreenAssembler(PartnerService serv) {
		super(SearchController.class, ScreenResource.class);
		this.service = serv;
	}

	@Override
	public ScreenResource toModel(Screen entity) {
		ScreenResource model = instantiateModel(entity);

		model.add(linkTo(methodOn(SearchController.class).findScreen(entity.getId())).withSelfRel());

		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setMovies(toScreenModel(entity.getId(), service.findByScreenId(entity.getId())));
		model.setSeats(toSeatsModel(service.findSeatsByScreen(entity.getId())));
		return model;
	}

	@Override
	public CollectionModel<ScreenResource> toCollectionModel(Iterable<? extends Screen> entities) {
		CollectionModel<ScreenResource> actorModels = super.toCollectionModel(entities);

		actorModels.add(linkTo(methodOn(PartnerController.class).all()).withSelfRel());

		return actorModels;
	}

	private List<MovieResource> toScreenModel(Long screenId, Set<Movie> theatres) {
		if (theatres.isEmpty())
			return Collections.emptyList();

		List<MovieResource> all = theatres.stream().map(theatre -> {
			MovieResource r = new MovieResource();
			r.setId(theatre.getId());
			r.setName(theatre.getName());
			r.setLanguage(theatre.getLanguage());
			r.setStatus(theatre.getStatus());
			r.setSlots(toSlotModel(service.findSlotByModie(theatre.getId())));
			r.add(linkTo(methodOn(SearchController.class).findMovie(theatre.getId())).withSelfRel());
			return r;
		}).collect(Collectors.toList());
		return all;
	}
	
	private List<SeatResource> toSeatsModel(Set<Seat> seats) {
		if (seats.isEmpty())
			return Collections.emptyList();

		List<SeatResource> all = seats.stream().map(s -> {
			SeatResource r = new SeatResource();
			r.setId(s.getId());
			r.setNo(s.getNo());
			r.setRow(s.getRowno());
			r.setState(s.getState());
			return r;
		}).collect(Collectors.toList());
		return all;
	}
	
	private List<SlotResource> toSlotModel( Set<Slot> theatres) {
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
