package com.sawan.spring.data.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sawan.spring.data.entities.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {

	List<Product> findByName(String name);

	List<Product> findByPrice(Double price);

	List<Product> findByNameAndPrice(String name, Double price);

}
