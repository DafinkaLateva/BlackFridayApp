package org.didi.BlackFridayApp.service;

import java.util.Collection;
import java.util.List;

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

	public Collection<Product> listBF() {
		List<Product> products = productFinder.findAll();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getDiscount() == 0) {
				products.remove(i);
			}
		}
		return products;
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

	public Product getProductById(Integer id) {
		Product product = new Product();
		product.setId(id);
		return productFinder.findOne(Example.of(product)).orElseGet(() -> null);
	}

}