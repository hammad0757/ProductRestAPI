package com.hammad.productrestapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.hammad.productrestapi.entities.Product;

@SpringBootTest
class ProductrestapiApplicationTests {

	@Value("${productrestapi.services.url}")
	private String baseURL;
	
	@Test
	void testGetProduct() {
		System.out.println(baseURL);
		RestTemplate restTemplate=new RestTemplate();
		Product product = restTemplate.getForObject(baseURL+"/1", Product.class);
		assertNotNull(product);
	}
	
	@Test
	public void testCreateProduct() {
		RestTemplate restTemplate=new RestTemplate();
		Product newProduct=new Product();
		newProduct.setName("Samsung");
		newProduct.setDescription("Good Mobile");
		newProduct.setPrice(1000);
		Product returnProduct = restTemplate.postForObject(baseURL, newProduct, Product.class);
		assertEquals(returnProduct.getName(), newProduct.getName());
	}

	@Test
	void testUpdateProduct() {
		
		RestTemplate restTemplate=new RestTemplate();
		Product product = restTemplate.getForObject(baseURL+"/1", Product.class);
		product.setPrice(1500);
		restTemplate.put(baseURL, product, Product.class);

	}
	
	@Test
	public void testDeleteProduct() {
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.delete("http://localhost:8080/products/6");
	}
}
