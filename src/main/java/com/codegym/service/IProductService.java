package com.codegym.service;

import com.codegym.model.Product;

public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> findAllByOrderByPrice();
    Iterable<Product> findAllByPriceBetween(String from,String to);
    Iterable<Product> findAllByNameContaining(String name);

}
