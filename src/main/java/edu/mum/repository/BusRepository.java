package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Bus;

@Repository
public interface BusRepository extends CrudRepository<Bus, Long> {


}
