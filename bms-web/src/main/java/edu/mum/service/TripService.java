package edu.mum.service;

import edu.mum.domain.Trip;

public interface TripService extends BaseService<Trip> {
	
    public Trip validateTrip(String tripId);

}
