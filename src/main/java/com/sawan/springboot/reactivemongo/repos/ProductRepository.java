package com.sawan.springboot.reactivemongo.repos;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sawan.springboot.reactivemongo.models.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
