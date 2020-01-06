package org.didi.BlackFridayApp.service;

import java.util.Collection;

import org.didi.BlackFridayApp.db.entity.Product;
import org.didi.BlackFridayApp.db.finder.ProductFinder;
import org.didi.BlackFridayApp.exceptions.MoneyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductFinder productFinder;

	public void delete(Integer id) {

		productFinder.deleteById(id);

	}

	public Product add(Product product) {
		return productFinder.saveAndFlush(product);
	}

	public Collection<Product> list() {
		return productFinder.findAll();
	}

	Product get(String name, Integer amount, Double price, Double minPrice, Double discount) throws MoneyException {
		Product product = new Product();
		product.setName(name);
		product.setAmount(amount);
		product.setPrice(price);
		product.setMinPrice(minPrice);
		product.setDiscount(discount);

		return productFinder.findOne(Example.of(product)).orElseGet(() -> null);
	}

}
