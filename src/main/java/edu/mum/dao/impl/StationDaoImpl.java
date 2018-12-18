package edu.mum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dao.StationDao;
import edu.mum.domain.Station;

@Repository
public class StationDaoImpl extends GenericDaoImpl<Station> implements StationDao {
	public StationDaoImpl() {
		super.setDaoType(Station.class);
	}
}
