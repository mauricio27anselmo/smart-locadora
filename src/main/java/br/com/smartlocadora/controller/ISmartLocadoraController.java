package br.com.smartlocadora.controller;

import java.util.List;

public interface ISmartLocadoraController<T> {

    List<T> listAll();
    T find(Long id);
    T insert(T object);
    void update(T object);
    void delete(Long id);
}
