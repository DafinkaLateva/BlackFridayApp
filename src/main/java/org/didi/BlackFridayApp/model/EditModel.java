package org.didi.BlackFridayApp.model;

import org.didi.BlackFridayApp.exceptions.MoneyException;

public class EditModel {

	private String name;
	private Double price;
	private double minPrice;
	private int amount;
	private double discount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) throws MoneyException {
		this.price = price;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) throws MoneyException {
		this.minPrice = minPrice;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
