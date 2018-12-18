package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Operator;

@Repository
public interface OperatorRepository extends CrudRepository<Operator, Long> {
	
}
