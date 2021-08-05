package com.sawan.springboot.reactivemongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sawan.springboot.reactivemongo.models.Product;
import com.sawan.springboot.reactivemongo.repos.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository repo;

	@PostMapping
	public Mono<Product> addProduct(@RequestBody Product product) {
		return repo.save(product);
	}

	@GetMapping
	public Flux<Product> getProducts() {
		return repo.findAll();
	}

}
