package edu.mum.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T save(T t);
    T findOne(Long id);
    void delete(Long id);
}
