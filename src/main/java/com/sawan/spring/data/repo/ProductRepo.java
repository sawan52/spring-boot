package com.sawan.spring.data.repo;

import org.springframework.data.repository.CrudRepository;

import com.sawan.spring.data.entities.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {

}
