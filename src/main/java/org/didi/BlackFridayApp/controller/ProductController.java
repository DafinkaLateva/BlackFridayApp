package org.didi.BlackFridayApp.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.didi.BlackFridayApp.db.entity.Product;
import org.didi.BlackFridayApp.exceptions.AccountException;
import org.didi.BlackFridayApp.exceptions.MoneyException;
import org.didi.BlackFridayApp.model.EditModel;
import org.didi.BlackFridayApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	private boolean isBlackFriday;

	@PostMapping("/product/add")
	public ResponseEntity<?> addProduct(Product product, HttpSession session) throws MoneyException {
		if (session.getAttribute("userId") == null) {
			return ResponseEntity.status(401).body("unauth");
		} else if (!session.getAttribute("userRole").equals("employee")) {
			return ResponseEntity.status(403).body("forbidden");
		}
		productService.add(product);
		return ResponseEntity.ok(product);
	}

	@DeleteMapping("/product/remove/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return ResponseEntity.status(401).body("unauth");
		} else if (!session.getAttribute("userRole").equals("employee")) {
			return ResponseEntity.status(403).body("forbidden");
		}

		try {
			productService.delete(id);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.noContent().build();

	}

	@GetMapping("/product/list")
	public Collection<Product> getAll() {

		return productService.list();

	}

	@GetMapping("/product/listBF")
	public Collection<Product> getBF() {

		return productService.listBF();
	}

	@GetMapping("/product/getProductById/{id}")
	public Product getProductByid(@PathVariable Integer id) {

		Product product = productService.getProductById(id);
		return product;
	}

	@GetMapping("/product/bf")
	public ResponseEntity<?> launchBf(HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return ResponseEntity.status(401).body("unauth");
		} else if (!session.getAttribute("userRole").equals("employee")) {
			return ResponseEntity.status(403).body("forbidden");
		}

		this.isBlackFriday = !this.isBlackFriday;

		return ResponseEntity.ok(this.isBlackFriday);
	}

	@PutMapping("product/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Integer id, HttpSession session,
			@Valid @RequestBody EditModel productModel) {
		if (session.getAttribute("userId") == null) {
			return ResponseEntity.status(401).body("unauth");
		} else if (!session.getAttribute("userRole").equals("employee")) {
			return ResponseEntity.status(403).body("forbidden");
		}

		return ResponseEntity.ok(productService.updateProduct(id, productModel));

	}

}
