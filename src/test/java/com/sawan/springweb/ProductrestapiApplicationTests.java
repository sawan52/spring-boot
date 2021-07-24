package com.sawan.springweb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.sawan.springweb.entities.Product;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductrestapiApplicationTests {

	@Test
	void testGetProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject("http://localhost:8080/studentapi/products/1", Product.class);

		assertNotNull(product);
		assertEquals("IPhone", product.getName());
	}

	@Test
	void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();

		Product product = new Product();
		product.setName("Redmi Y1");
		product.setDescription("It is cheaper");
		product.setPrice(229);

		Product newProduct = restTemplate.postForObject("http://localhost:8080/studentapi/products", product,
				Product.class);
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Redmi Y1", newProduct.getName());
	}

	@Test
	void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		// first we will get the product and then we will update it
		Product product = restTemplate.getForObject("http://localhost:8080/studentapi/products/1", Product.class);

		product.setPrice(1299);
		restTemplate.put("http://localhost:8080/studentapi/products", product);
	}

}
