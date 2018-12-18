package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Station;

@Repository
public interface StationRepository extends CrudRepository<Station, Long> {


}
