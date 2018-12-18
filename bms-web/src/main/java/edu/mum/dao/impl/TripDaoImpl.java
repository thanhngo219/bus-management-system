package edu.mum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dao.TripDao;
import edu.mum.domain.Trip;

@Repository
public class TripDaoImpl extends GenericDaoImpl<Trip> implements TripDao {
	public TripDaoImpl() {
		super.setDaoType(Trip.class);
	}
}
