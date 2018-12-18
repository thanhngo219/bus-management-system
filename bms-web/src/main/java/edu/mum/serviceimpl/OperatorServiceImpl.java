package edu.mum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.OperatorDao;
import edu.mum.domain.Operator;
import edu.mum.service.OperatorService;

@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorDao operatorDao;

    @Override

    public List<Operator> findAll() {
        return (List<Operator>) operatorDao.findAll();
    }

    @Override
    public Operator save(Operator operator) {
        return operatorDao.update(operator);
    }

    @Override
    public Operator findOne(Long id) {
        return operatorDao.findOne(id);
    }

    @Override
    public void delete(Long id) {
    	operatorDao.delete(id);
    }

}
