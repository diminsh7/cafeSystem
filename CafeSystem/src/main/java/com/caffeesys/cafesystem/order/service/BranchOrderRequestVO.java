package com.caffeesys.cafesystem.order.service;

import java.sql.Date;

public class BranchOrderRequestVO {

	private int orderCode; // 발주관리코드
	private String statementNumber; // 전표번호
	private String orderFaultyDivide; // 발주/불량구분
	private String localCategoryCode; // 지역코드
	private String shopCode; // 매장코드
	private String itemCode; // 품목코드
	private int orderAmount; // 수량
	private int orderPrice; // 가격
	private int cal; // 수량 * 가격
	private String receiptCategoryCode; // 접수상태코드
	private String orderCategoryCode; // 배송상태
	private Date orderRequest; // 신청일
	private Date orderApproval; // 승인일
	private Date orderRelease; // 출고일
	private String headEmployeeCode; // 발주승인담당자
	private char orderFaultyAble;//불량여부
	private String branchEmployeeCode; //직원코드 
	private String cateReceipt; //접수상태명
	private String cateOrder; //배송상태명
	private String shopName; //매장명
	private String divideName; //발주상태명
	private String headName; //승인담당자명
	private String itemName; //품목명
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
	public int getCal() {
		return cal;
	}
	public void setCal(int cal) {
		this.cal = cal;
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
	public Date getOrderRequest() {
		return orderRequest;
	}
	public void setOrderRequest(Date orderRequest) {
		this.orderRequest = orderRequest;
	}
	public Date getOrderApproval() {
		return orderApproval;
	}
	public void setOrderApproval(Date orderApproval) {
		this.orderApproval = orderApproval;
	}
	public Date getOrderRelease() {
		return orderRelease;
	}
	public void setOrderRelease(Date orderRelease) {
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
	public String getBranchEmployeeCode() {
		return branchEmployeeCode;
	}
	public void setBranchEmployeeCode(String branchEmployeeCode) {
		this.branchEmployeeCode = branchEmployeeCode;
	}
	public String getCateReceipt() {
		return cateReceipt;
	}
	public void setCateReceipt(String cateReceipt) {
		this.cateReceipt = cateReceipt;
	}
	public String getCateOrder() {
		return cateOrder;
	}
	public void setCateOrder(String cateOrder) {
		this.cateOrder = cateOrder;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getDivideName() {
		return divideName;
	}
	public void setDivideName(String divideName) {
		this.divideName = divideName;
	}
	public String getHeadName() {
		return headName;
	}
	public void setHeadName(String headName) {
		this.headName = headName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	@Override
	public String toString() {
		return "BranchOrderRequestVO [orderCode=" + orderCode + ", statementNumber=" + statementNumber
				+ ", orderFaultyDivide=" + orderFaultyDivide + ", localCategoryCode=" + localCategoryCode
				+ ", shopCode=" + shopCode + ", itemCode=" + itemCode + ", orderAmount=" + orderAmount + ", orderPrice="
				+ orderPrice + ", cal=" + cal + ", receiptCategoryCode=" + receiptCategoryCode + ", orderCategoryCode="
				+ orderCategoryCode + ", orderRequest=" + orderRequest + ", orderApproval=" + orderApproval
				+ ", orderRelease=" + orderRelease + ", headEmployeeCode=" + headEmployeeCode + ", orderFaultyAble="
				+ orderFaultyAble + ", branchEmployeeCode=" + branchEmployeeCode + ", cateReceipt=" + cateReceipt
				+ ", cateOrder=" + cateOrder + ", shopName=" + shopName + ", divideName=" + divideName + ", headName="
				+ headName + ", itemName=" + itemName + "]";
	}
	
	public BranchOrderRequestVO(int orderCode, String statementNumber, String orderFaultyDivide,
			String localCategoryCode, String shopCode, String itemCode, int orderAmount, int orderPrice, int cal,
			String receiptCategoryCode, String orderCategoryCode, Date orderRequest, Date orderApproval,
			Date orderRelease, String headEmployeeCode, char orderFaultyAble, String branchEmployeeCode,
			String cateReceipt, String cateOrder, String shopName, String divideName, String headName,
			String itemName) {
		super();
		this.orderCode = orderCode;
		this.statementNumber = statementNumber;
		this.orderFaultyDivide = orderFaultyDivide;
		this.localCategoryCode = localCategoryCode;
		this.shopCode = shopCode;
		this.itemCode = itemCode;
		this.orderAmount = orderAmount;
		this.orderPrice = orderPrice;
		this.cal = cal;
		this.receiptCategoryCode = receiptCategoryCode;
		this.orderCategoryCode = orderCategoryCode;
		this.orderRequest = orderRequest;
		this.orderApproval = orderApproval;
		this.orderRelease = orderRelease;
		this.headEmployeeCode = headEmployeeCode;
		this.orderFaultyAble = orderFaultyAble;
		this.branchEmployeeCode = branchEmployeeCode;
		this.cateReceipt = cateReceipt;
		this.cateOrder = cateOrder;
		this.shopName = shopName;
		this.divideName = divideName;
		this.headName = headName;
		this.itemName = itemName;
	}
	
	public BranchOrderRequestVO() {
		super();
	}
	
}