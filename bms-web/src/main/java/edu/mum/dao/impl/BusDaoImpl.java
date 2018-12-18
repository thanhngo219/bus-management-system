package edu.mum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dao.BusDao;
import edu.mum.domain.Bus;

@Repository
public class BusDaoImpl extends GenericDaoImpl<Bus> implements BusDao {
	public BusDaoImpl() {
		super.setDaoType(Bus.class);
	}
}
