package org.didi.BlackFridayApp.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.didi.BlackFridayApp.db.entity.Order;
import org.didi.BlackFridayApp.model.BuyProductModel;
import org.didi.BlackFridayApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/order/buy")
	public ResponseEntity<?> buyProduct(BuyProductModel model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return ResponseEntity.status(401).body("unauth");
		} else if (!session.getAttribute("userRole").equals("client")) {
			return ResponseEntity.status(403).body("forbidden");
		}

		String order = orderService.buyProduct((Integer) session.getAttribute("userId"), model.getProductId(),
				model.getAmount(), model.getDate());

		return ResponseEntity.ok(order);

	}

	@GetMapping("order/info/")
	public Collection<Order> getAll() {

		return orderService.list();
	}

	@GetMapping("order/getOrderByClientId/{idClient}")
	public Order getOrderByClientId(@PathVariable Integer idClient) {

		Order order = orderService.getOrderByClientId(idClient);
		return order;
	}

	@DeleteMapping("/order/remove/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable Integer id, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return ResponseEntity.status(401).body("unauth");
		} else if (!session.getAttribute("userRole").equals("employee")) {
			return ResponseEntity.status(403).body("forbidden");
		}

		orderService.delete(id);

		return ResponseEntity.noContent().build();
	}
	/*
	 * @GetMapping("/order/date/") public ResponseEntity<?>
	 * totalTurnoverForAday(OrderModel orderModel, HttpSession session) { if
	 * (session.getAttribute("userId") == null) { return
	 * ResponseEntity.status(401).body("unauth"); } else if
	 * (!session.getAttribute("userRole").equals("client")) { return
	 * ResponseEntity.status(403).body("forbidden"); } Double
	 * totalTurnover=orderService.buyProduct((session.getAttribute("userId"),),
	 * 
	 * 
	 * 
	 * return ResponseEntity.ok(totalTurnover);
	 * 
	 * }
	 */
}
