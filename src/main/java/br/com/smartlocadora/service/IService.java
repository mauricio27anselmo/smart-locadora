package br.com.smartlocadora.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    List<T> listAll();
    T find(Long id);
    void delete(Long id);
    Long insert(T entity);
    void update(Long id, T entity);
}
