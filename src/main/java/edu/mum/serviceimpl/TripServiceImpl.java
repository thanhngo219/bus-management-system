package edu.mum.serviceimpl;

import edu.mum.domain.Trip;
import edu.mum.exception.InvalidTripException;
import edu.mum.repository.TripRepository;
import edu.mum.service.TripService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TripServiceImpl implements TripService {

    @Autowired
    TripRepository tripRepository;

    @Override
    public List<Trip> findAll() {
        return (List<Trip>) tripRepository.findAll();
    }

    @Override
    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public Trip findOne(Long id) {
        return tripRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        tripRepository.delete(id);
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
