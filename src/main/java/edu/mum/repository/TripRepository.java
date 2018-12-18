package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Trip;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {

}
