package com.caffeesys.cafesystem.order.service;

public class HeadOrderVO {
	private int orderCode; // 발주관리코드
	private String statementNumber; // 전표번호
	private String orderFaultyDivide; // 발주,불량구분코드
	private String localCategoryCode; // 지역코드
	private String shopCode; // 매장코드
	private String itemCode; // 품목코드
	private int orderAmount; // 수량
	private int orderPrice; // 가격
	private String receiptCateCode; // 접수상태코드
	private String orderCateCode; // 배송상태코드
	private String orderRequest; // 신청일
	private String orderApproval; // 승인일
	private String orderRelease; // 출고일
	private String headEmployeeCode; // 발주승인담당자
	private String orderFaultyAble; // 불량여부
	// ----↑DB↑---------↓VIEW↓--------
	private String shopName; // 지역매장 번호
	private String faultyDivideName; // 발주,불량 구분명
	private String itemName; // 품목명
	private String receiptCateName; // 접수상태코드명
	private String orderCateName; // 배송상태코드명

	@Override
	public String toString() {
		return "HeadOrderVO [orderCode=" + orderCode + ", statementNumber=" + statementNumber + ", orderFaultyDivide="
				+ orderFaultyDivide + ", localCategoryCode=" + localCategoryCode + ", shopCode=" + shopCode
				+ ", itemCode=" + itemCode + ", orderAmount=" + orderAmount + ", orderPrice=" + orderPrice
				+ ", receiptCateCode=" + receiptCateCode + ", orderCateCode=" + orderCateCode + ", orderRequest="
				+ orderRequest + ", orderApproval=" + orderApproval + ", orderRelease=" + orderRelease
				+ ", headEmployeeCode=" + headEmployeeCode + ", orderFaultyAble=" + orderFaultyAble + ", shopName="
				+ shopName + ", faultyDivideName=" + faultyDivideName + ", itemName=" + itemName
				+ ", receiptCateName=" + receiptCateName + ", orderCateName=" + orderCateName + "]";
	}

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

	public String getReceiptCateCode() {
		return receiptCateCode;
	}

	public void setReceiptCateCode(String receiptCateCode) {
		this.receiptCateCode = receiptCateCode;
	}

	public String getOrderCateCode() {
		return orderCateCode;
	}

	public void setOrderCateCode(String orderCateCode) {
		this.orderCateCode = orderCateCode;
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

	public String getOrderFaultyAble() {
		return orderFaultyAble;
	}

	public void setOrderFaultyAble(String orderFaultyAble) {
		this.orderFaultyAble = orderFaultyAble;
	}

	public String getFaultyDivideName() {
		return faultyDivideName;
	}

	public void setFaultyDivideName(String faultyDivideName) {
		this.faultyDivideName = faultyDivideName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getReceiptCateName() {
		return receiptCateName;
	}

	public void setReceiptCateName(String receiptCateName) {
		this.receiptCateName = receiptCateName;
	}

	public String getOrderCateName() {
		return orderCateName;
	}

	public void setOrderCateName(String orderCateName) {
		this.orderCateName = orderCateName;
	}

	public String getshopName() {
		return shopName;
	}

	public void setshopName(String shopName) {
		this.shopName = shopName;
	}

}
