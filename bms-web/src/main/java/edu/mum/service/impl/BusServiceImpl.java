package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.BusDao;
import edu.mum.domain.Bus;
import edu.mum.service.BusService;

@Service
@Transactional
public class BusServiceImpl implements BusService {

	@Autowired
	private BusDao busDao;


    @Override
    public List<Bus> findAll() {
        return (List<Bus>) busDao.findAll();
    }

    @Override
    public Bus save(Bus bus) {
        return busDao.update(bus);
    }

    @Override
    public Bus findOne(Long id) {
        return busDao.findOne(id);
    }

    @Override
    public void delete(Long id) {
    	busDao.delete(id);
    }

	@Override
	public Long saveBus(Bus bus) {
		Bus savedBus = busDao.update(bus);
		return savedBus.getId();
	}
}
