package org.didi.BlackFridayApp.service;

import java.util.Collection;

import org.didi.BlackFridayApp.db.entity.Order;
import org.didi.BlackFridayApp.db.entity.Product;
import org.didi.BlackFridayApp.db.entity.User;
import org.didi.BlackFridayApp.db.finder.OrderFinder;
import org.didi.BlackFridayApp.db.finder.ProductFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	@Autowired
	private ProductFinder productFinder;

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@Autowired
	private OrderFinder orderFinder;

	public Order orderAdd(Order order) {
		return orderFinder.saveAndFlush(order);
	}

	public String buyProduct(Integer clientId, Integer productId, Integer amount, String date) {
		Order order = new Order();
		User user = userService.getUserById(clientId);
		Product product = productService.getProductById(productId);
		double orderPrice = amount * product.getPrice();
		double discountedOrderPrice = amount * (product.getPrice() - product.getPrice() * product.getDiscount());
		if (amount > product.getAmount() || product.getAmount() == 0) {
			return "There is not enough of this product";
		}

		order.setIdClient(clientId);
		order.setIdProd(productId);
		order.setAmount(amount);
		order.setPrice(orderPrice);
		order.setFinalPrice(discountedOrderPrice);
		order.setDate(date);
		Order newOrder = orderAdd(order);
		product.setAmount(product.getAmount() - amount);
		Product newProduct = productService.add(product);// TODO: change add to edit later

		return "Your order has been successul.";
	}

	public Collection<Order> list() {
		return orderFinder.findAll();
	}

	public Order getOrderByClientId(Integer idClient) {
		Order order = new Order();
		order.setIdClient(idClient);
		return orderFinder.findOne(Example.of(order)).orElseGet(() -> null);
	}
}
