package edu.mum.serviceimpl;

import edu.mum.domain.Bus;
import edu.mum.repository.BusRepository;
import edu.mum.service.BusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BusServiceImpl implements BusService {
    @Autowired
    BusRepository repository;


    @Override
    public List<Bus> findAll() {
        return (List<Bus>) repository.findAll();
    }

    @Override
    public Bus save(Bus airplane) {
        return repository.save(airplane);
    }

    @Override
    public Bus findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

	@Override
	public Long saveAirplane(Bus airplane) {
		Bus savedAirplane = repository.save(airplane);
		return savedAirplane.getId();
	}
}
