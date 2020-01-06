package org.didi.BlackFridayApp.controller;

import java.util.Collection;

import org.didi.BlackFridayApp.db.entity.Product;
import org.didi.BlackFridayApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService products;

	@PostMapping("/product/add")
	public Product addProduct(Product product) {

		return products.add(product);

	}

	@DeleteMapping("/product/remove/{id}")

	public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
		products.delete(id);
		return ResponseEntity.noContent().build();

	}

	@PostMapping("/product/edit")

	public Product edit(Product product) {
		return product;

	}

	@GetMapping("/product/list")
	public Collection<Product> getAll() {

		return products.list();
	}
}
