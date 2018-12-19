package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.TripDao;
import edu.mum.domain.Trip;
import edu.mum.exception.InvalidTripException;
import edu.mum.service.TripService;

@Service
@Transactional
public class TripServiceImpl implements TripService {
	
	@Autowired
	private TripDao tripDao;

    @Override
    public List<Trip> findAll() {
        return (List<Trip>) tripDao.findAll();
    }

    @Override
    public Trip save(Trip trip) {
        return tripDao.update(trip);
    }

    @Override
    public Trip findOne(Long id) {
        return tripDao.findOne(id);
    }

    @Override
    public void delete(Long id) {
    	tripDao.delete(id);
    }
    
	@Override
	public Trip validateTrip(String tripId) {
		
		if(tripId == null || tripId.isEmpty()) {
			throw new InvalidTripException("Invalid trip number" + tripId);
		}
		
		long tripID = Long.parseLong(tripId);
		
		Trip trip = this.findOne(tripID);
		
		if(trip == null) {
			throw new InvalidTripException("Invalid trip number" + tripId);
		}
		
		return trip;

	}

}
