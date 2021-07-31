package com.sawan.springweb.controllers;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sawan.springweb.entities.Product;
import com.sawan.springweb.repos.ProductRepository;

@RestController
public class ProductRestController {

	@Autowired
	ProductRepository repository;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	@Cacheable("product-cache")
	@Transactional(readOnly = true)
	public Product getproduct(@PathVariable("id") int id) {
		LOGGER.info("Finding product by ID: " + id);
		return repository.findById(id).get();
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return repository.save(product);
	}

	@RequestMapping(value = "/products", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return repository.save(product);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	@Cacheable("product-cache")
	public void deleteProduct(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

}
