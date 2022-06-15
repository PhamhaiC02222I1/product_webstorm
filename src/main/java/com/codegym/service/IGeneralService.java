package com.codegym.service;

import com.codegym.model.Product;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void save(T t);
    void remove(Long id);
    T saveP(T t);
}
