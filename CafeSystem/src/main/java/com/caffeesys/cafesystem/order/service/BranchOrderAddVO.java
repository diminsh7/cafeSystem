package com.caffeesys.cafesystem.order.service;

public class BranchOrderAddVO {
	private int orderCode; // 발주관리코드
	private String statementNumber; // 전표번호
	private String orderFaultyDivide; // 발주/불량구분
	private String localCategoryCode; // 지역코드
	private String shopCode; // 매장코드
	private String itemCode; // 품목코드
	private int orderAmount; // 품목별 수량
	private int orderPrice; // 품목별 수량에 따른 가격 합계
	private String receiptCategoryCode; // 접수상태코드
	private String orderCategoryCode; // 배송상태
	private String orderRequest; // 신청일
	private String orderApproval; // 승인일
	private String orderRelease; // 출고일
	private String headEmployeeCode; // 발주승인담당자
	private char orderFaultyAble;// 불량여부

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public String getStatementNumber() {
		return statementNumber;
	}

	public void setStatementNumber(String statementNumber) {
		this.statementNumber = statementNumber;
	}

	public String getOrderFaultyDivide() {
		return orderFaultyDivide;
	}

	public void setOrderFaultyDivide(String orderFaultyDivide) {
		this.orderFaultyDivide = orderFaultyDivide;
	}

	public String getLocalCategoryCode() {
		return localCategoryCode;
	}

	public void setLocalCategoryCode(String localCategoryCode) {
		this.localCategoryCode = localCategoryCode;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getReceiptCategoryCode() {
		return receiptCategoryCode;
	}

	public void setReceiptCategoryCode(String receiptCategoryCode) {
		this.receiptCategoryCode = receiptCategoryCode;
	}

	public String getOrderCategoryCode() {
		return orderCategoryCode;
	}

	public void setOrderCategoryCode(String orderCategoryCode) {
		this.orderCategoryCode = orderCategoryCode;
	}

	public String getOrderRequest() {
		return orderRequest;
	}

	public void setOrderRequest(String orderRequest) {
		this.orderRequest = orderRequest;
	}

	public String getOrderApproval() {
		return orderApproval;
	}

	public void setOrderApproval(String orderApproval) {
		this.orderApproval = orderApproval;
	}

	public String getOrderRelease() {
		return orderRelease;
	}

	public void setOrderRelease(String orderRelease) {
		this.orderRelease = orderRelease;
	}

	public String getHeadEmployeeCode() {
		return headEmployeeCode;
	}

	public void setHeadEmployeeCode(String headEmployeeCode) {
		this.headEmployeeCode = headEmployeeCode;
	}

	public char getOrderFaultyAble() {
		return orderFaultyAble;
	}

	public void setOrderFaultyAble(char orderFaultyAble) {
		this.orderFaultyAble = orderFaultyAble;
	}

	@Override
	public String toString() {
		return "BranchOrderAddVO [orderCode=" + orderCode + ", statementNumber=" + statementNumber
				+ ", orderFaultyDivide=" + orderFaultyDivide + ", localCategoryCode=" + localCategoryCode
				+ ", shopCode=" + shopCode + ", itemCode=" + itemCode + ", orderAmount=" + orderAmount + ", orderPrice="
				+ orderPrice + ", receiptCategoryCode=" + receiptCategoryCode + ", orderCategoryCode="
				+ orderCategoryCode + ", orderRequest=" + orderRequest + ", orderApproval=" + orderApproval
				+ ", orderRelease=" + orderRelease + ", headEmployeeCode=" + headEmployeeCode + ", orderFaultyAble="
				+ orderFaultyAble + "]";
	}

}