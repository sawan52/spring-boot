package com.sawan.spring.data;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.sawan.spring.data.entities.Product;
import com.sawan.spring.data.repo.ProductRepo;

@SpringBootTest
class SpringdatajpaApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void saveProduct() {

		ProductRepo repo = context.getBean(ProductRepo.class);
		Product product = new Product();

		// adding data to the database
		product.setId(1L);
		product.setName("Mac");
		product.setDescription("awesome");
		product.setPrice(1200d);

		/*
		repo.save(product);

		// read one data from database
		Optional<Product> optional = repo.findById(1L);
		if (optional.isPresent()) {
			Product p = optional.get();
			System.out.println(p);
		}

		// update the product in database
		product.setPrice(1499d);
		repo.save(product);

		// read all data from database
		repo.findAll().forEach(prod -> {
			System.out.print("Product Name: " + prod.getName());
			System.out.println(" Product Price: " + prod.getPrice());
		});
		*/
		
		System.out.println(repo.findByName("Mac"));
		System.out.println(repo.findByPrice(1499d));
		System.out.println(repo.findByNameAndPrice("Iphone", 799d));

	}

}
