package org.didi.BlackFridayApp.controller;

import java.util.Collection;

import org.didi.BlackFridayApp.db.entity.Order;
import org.didi.BlackFridayApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private OrderService orders;

	@PostMapping("/order/buy/{clientId}, {productId}, {amount}, {String}")
	public String buyProduct(@PathVariable Integer clientId, @PathVariable Integer productId,
			@PathVariable Integer amount, @PathVariable String date) {
		String order = orders.buyProduct(clientId, productId, amount, date);
		return order;

	}

	@GetMapping("order/info/")
	public Collection<Order> getAll() {

		return orders.list();
	}

	@GetMapping("order/getOrderByClientId/{idClient}")
	public Order getOrderByClientId(@PathVariable Integer idClient) {

		Order order = orders.getOrderByClientId(idClient);
		return order;
	}
}
