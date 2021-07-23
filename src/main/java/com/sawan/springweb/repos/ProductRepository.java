package com.sawan.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sawan.springweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
