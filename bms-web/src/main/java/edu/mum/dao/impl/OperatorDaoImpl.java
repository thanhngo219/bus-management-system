package edu.mum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dao.OperatorDao;
import edu.mum.domain.Operator;

@Repository
public class OperatorDaoImpl extends GenericDaoImpl<Operator> implements OperatorDao {
	public OperatorDaoImpl() {
		super.setDaoType(Operator.class);
	}
}
