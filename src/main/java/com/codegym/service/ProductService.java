package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveP(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Iterable<Product> findAllByNameContaining(String name) {
        return productRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Product> findAllByPriceBetween(String from, String to) {
        return productRepository.findAllByPriceBetween(from,to);
    }

    @Override
    public Iterable<Product> findAllByOrderByPrice() {
        return productRepository.findAllByOrderByPrice();
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }
}
