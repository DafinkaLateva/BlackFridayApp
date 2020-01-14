package org.didi.BlackFridayApp.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import org.didi.BlackFridayApp.exceptions.AmountException;
import org.didi.BlackFridayApp.exceptions.DiscountException;
import org.didi.BlackFridayApp.exceptions.MoneyException;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "amount")
	private Integer amount;
	@Column(name = "price")
	private Double price;
	@Column(name = "min_price")
	private Double minPrice;
	@Column(name = "discount")
	private Double discount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) throws AmountException {

		if ((amount < 0) || (amount == 0)) {
			throw new AmountException();
		}
		this.amount = amount;

	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) throws MoneyException {
		if (price < 0 || price == 0) {
			throw new MoneyException();
		}
		this.price = price;

	}

	public Double getMinPrice() {
		return minPrice;
	}

	/*
	 * public void setMinPrice(Double minPrice) throws MoneyException {
	 *
	 * if (minPrice > price) { throw new MoneyException(); } this.minPrice =
	 * minPrice; }
	 */
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) throws DiscountException {

		if ((discount < 0)) {
			throw new DiscountException();
		}
		this.discount = discount;

	}

	public void updateFields(@Valid Product productForm) {
		// TODO Auto-generated method stub

	}

}
