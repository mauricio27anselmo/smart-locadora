package br.com.smartlocadora.controller;

import java.util.List;

public interface ISmartLocadoraController<T> {

    List<T> listAll();
    T find(Long id);
    T insert(T entity);
    void update(T entity);
    void delete(Long id);
}
