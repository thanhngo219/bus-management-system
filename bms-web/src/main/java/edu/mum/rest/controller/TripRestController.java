package edu.mum.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.Trip;
import edu.mum.service.TripService;

@RestController
@RequestMapping({"rest/trips"})
public class TripRestController {
	
	@Autowired
	private TripService tripService;
	
	@RequestMapping()
	public List<Trip> getAllTrips() {
		return tripService.findAll();
	}
}
