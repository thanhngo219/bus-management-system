package edu.mum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.StationDao;
import edu.mum.domain.Station;
import edu.mum.service.StationService;

@Service
@Transactional
public class StationServiceImpl implements StationService {
//    @Autowired
//    StationRepository stationRepository;

	@Autowired
	private StationDao stationDao;

    @Override
    public List<Station> findAll() {
        return (List<Station>) stationDao.findAll();
    }

    @Override
    public Station save(Station bus) {
        return stationDao.update(bus);
    }

    @Override
    public Station findOne(Long id) {
        return stationDao.findOne(id);
    }

    @Override
    public void delete(Long id) {
    	stationDao.delete(id);
    }
}
