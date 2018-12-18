package edu.mum.serviceimpl;

import edu.mum.domain.Station;
import edu.mum.repository.StationRepository;
import edu.mum.service.StationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StationServiceImpl implements StationService {
    @Autowired
    StationRepository repository;


    @Override
    public List<Station> findAll() {
        return (List<Station>) repository.findAll();
    }

    @Override
    public Station save(Station airplane) {
        return repository.save(airplane);
    }

    @Override
    public Station findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
