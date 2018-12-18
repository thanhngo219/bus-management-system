package edu.mum.serviceimpl;

import edu.mum.domain.Trip;
import edu.mum.exception.InvalidFlightException;
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
    TripRepository repository;

    @Override
    public List<Trip> findAll() {
        return (List<Trip>) repository.findAll();
    }

    @Override
    public Trip save(Trip flight) {
        return repository.save(flight);
    }

    @Override
    public Trip findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
    
	@Override
	public Trip validateFlight(String flightId) {
		
		if(flightId == null || flightId.isEmpty()) {
			throw new InvalidFlightException("Invalid flight number" + flightId);
		}
		
		long flightID = Long.parseLong(flightId);
		
		Trip flight = this.findOne(flightID);
		
		if(flight == null) {
			throw new InvalidFlightException("Invalid flight number" + flightId);
		}
		
		return flight;

	}

}
