package com.caffeesys.cafesystem.order.service;

import java.util.List;

public class BranchOrderCommand {
	private List<String> itemCode;
	private List<Integer> orderAmount;
	private List<Integer> orderPrice;

	@Override
	public String toString() {
		return "BranchOrderCommand [itemCode=" + itemCode + ", orderAmount=" + orderAmount + ", orderPrice="
				+ orderPrice + "]";
	}

	public List<String> getItemCode() {
		return itemCode;
	}

	public void setItemCode(List<String> itemCode) {
		this.itemCode = itemCode;
	}

	public List<Integer> getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(List<Integer> orderAmount) {
		this.orderAmount = orderAmount;
	}

	public List<Integer> getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(List<Integer> orderPrice) {
		this.orderPrice = orderPrice;
	}

}
