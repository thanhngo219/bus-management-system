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
    StationRepository stationRepository;


    @Override
    public List<Station> findAll() {
        return (List<Station>) stationRepository.findAll();
    }

    @Override
    public Station save(Station bus) {
        return stationRepository.save(bus);
    }

    @Override
    public Station findOne(Long id) {
        return stationRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        stationRepository.delete(id);
    }
}
