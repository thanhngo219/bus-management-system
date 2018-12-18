package edu.mum.serviceimpl;

import edu.mum.domain.Operator;
import edu.mum.repository.OperatorRepository;
import edu.mum.service.OperatorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorRepository repository;

    @Override

    public List<Operator> findAll() {
        return (List<Operator>) repository.findAll();
    }

    @Override
    public Operator save(Operator airline) {
        return repository.save(airline);
    }

    @Override
    public Operator findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

}
