package com.sawan.spring.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sawan.spring.data.entities.Product;
import com.sawan.spring.data.repo.ProductRepo;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductRepo repository;

	@GetMapping
	public Iterable<Product> getAllProducts() {
		return repository.findAll();
	}

	@PostMapping
	public Product create(@RequestBody Product product) {
		return repository.save(product);
	}

	@PutMapping
	public Product update(@RequestBody Product product) {
		return repository.save(product);
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		Product prod = null;
		Optional<Product> optional = repository.findById(id);
		if (optional.isPresent()) {
			prod = optional.get();
		}
		return prod;
	}

	@DeleteMapping("/{id}")
	public void deleteProductById(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
}
