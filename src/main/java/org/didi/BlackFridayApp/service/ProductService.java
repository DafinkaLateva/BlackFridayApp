package org.didi.BlackFridayApp.service;

import java.util.Collection;
import java.util.List;

import org.didi.BlackFridayApp.db.entity.Product;
import org.didi.BlackFridayApp.db.finder.ProductFinder;
import org.didi.BlackFridayApp.exceptions.AccountException;
import org.didi.BlackFridayApp.exceptions.AmountException;
import org.didi.BlackFridayApp.exceptions.DiscountException;
import org.didi.BlackFridayApp.exceptions.MoneyException;
import org.didi.BlackFridayApp.model.EditModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductFinder productFinder;

	public void delete(Integer id) throws AccountException {

		productFinder.deleteById(id);

	}

	public Product add(Product product) throws MoneyException {

		return productFinder.saveAndFlush(product);
	}

	public Collection<Product> list() {
		return productFinder.findAll();
	}

	public Collection<Product> listBF() {
		List<Product> products = productFinder.findAll();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getDiscount() == 0.0) {
				products.remove(i);
			}
		}
		return products;
	}

	Product get(String name, Integer amount, Double price, Double minPrice, Double discount)
			throws MoneyException, AmountException {
		Product product = new Product();
		product.setName(name);
		try {
			product.setAmount(amount);
		} catch (AmountException e) {
			e.printStackTrace();
		}
		try {
			product.setPrice(price);
		} catch (MoneyException e) {
			e.printStackTrace();
		}

		product.setMinPrice(minPrice);

		try {
			product.setDiscount(discount);
		} catch (DiscountException e) {
			e.printStackTrace();
		}

		return productFinder.findOne(Example.of(product)).orElseGet(() -> null);
	}

	public Product getProductById(Integer id) {
		Product product = new Product();
		product.setId(id);
		return productFinder.findOne(Example.of(product)).orElseGet(() -> null);
	}

	public Product updateProduct(Integer id, EditModel productModel) {
		Product updatedProduct = getProductById(id);
		updatedProduct.setName(productModel.getName());
		try {
			updatedProduct.setPrice(productModel.getPrice());
		} catch (MoneyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updatedProduct.setMinPrice(productModel.getMinPrice());
		try {
			updatedProduct.setAmount(productModel.getAmount());
		} catch (AmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			updatedProduct.setDiscount(productModel.getDiscount());
		} catch (DiscountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updatedProduct.updateFields(updatedProduct);
		return productFinder.save(updatedProduct);
	}

}