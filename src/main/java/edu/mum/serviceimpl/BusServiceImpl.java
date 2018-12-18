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
    BusRepository busRepository;


    @Override
    public List<Bus> findAll() {
        return (List<Bus>) busRepository.findAll();
    }

    @Override
    public Bus save(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public Bus findOne(Long id) {
        return busRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        busRepository.delete(id);
    }

	@Override
	public Long saveBus(Bus bus) {
		Bus savedBus = busRepository.save(bus);
		return savedBus.getId();
	}
}
