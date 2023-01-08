package br.com.smartlocadora.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    List<T> listAll();
    T find(Long id);
    void delete(Long id);
    T insert(T entity);
    T update(T entity);
}
