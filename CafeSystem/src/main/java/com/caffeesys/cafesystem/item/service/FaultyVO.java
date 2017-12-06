package com.caffeesys.cafesystem.item.service;

public class FaultyVO {
	private int	faultyCode; // 불량품목관리코드(PK)
	private String statementNumber; // 불량발생전표번호(FK)
	private String itemCode; // 품목코드(FK)
	private String faultyCategory; // 불량카테고리(FK)
	private int faultyAmount; // 불량수량
	private String faultyImage; // 불량이미지
	private String faultyReason; // 불량상세사유
	private int orderCode; // order코드
	private String itemName; // item명
	private String categoryCode; // category코드
	private String categorySmall; // category소분류801~804
	
	public int getFaultyCode() {
		return faultyCode;
	}
	public void setFaultyCode(int faultyCode) {
		this.faultyCode = faultyCode;
	}
	public String getStatementNumber() {
		return statementNumber;
	}
	public void setStatementNumber(String statementNumber) {
		this.statementNumber = statementNumber;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getFaultyCategory() {
		return faultyCategory;
	}
	public void setFaultyCategory(String faultyCategory) {
		this.faultyCategory = faultyCategory;
	}
	public int getFaultyAmount() {
		return faultyAmount;
	}
	public void setFaultyAmount(int faultyAmount) {
		this.faultyAmount = faultyAmount;
	}
	public String getFaultyImage() {
		return faultyImage;
	}
	public void setFaultyImage(String faultyImage) {
		this.faultyImage = faultyImage;
	}
	public String getFaultyReason() {
		return faultyReason;
	}
	public void setFaultyReason(String faultyReason) {
		this.faultyReason = faultyReason;
	}
	public int getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategorySmall() {
		return categorySmall;
	}
	public void setCategorySmall(String categorySmall) {
		this.categorySmall = categorySmall;
	}
	@Override
	public String toString() {
		return "FaultyVO [faultyCode=" + faultyCode + ", statementNumber=" + statementNumber + ", itemCode=" + itemCode
				+ ", faultyCategory=" + faultyCategory + ", faultyAmount=" + faultyAmount + ", faultyImage="
				+ faultyImage + ", faultyReason=" + faultyReason + ", orderCode=" + orderCode + ", itemName=" + itemName
				+ ", categoryCode=" + categoryCode + ", categorySmall=" + categorySmall + "]";
	}
	public FaultyVO(int faultyCode, String statementNumber, String itemCode, String faultyCategory, int faultyAmount,
			String faultyImage, String faultyReason, int orderCode, String itemName, String categoryCode,
			String categorySmall) {
		super();
		this.faultyCode = faultyCode;
		this.statementNumber = statementNumber;
		this.itemCode = itemCode;
		this.faultyCategory = faultyCategory;
		this.faultyAmount = faultyAmount;
		this.faultyImage = faultyImage;
		this.faultyReason = faultyReason;
		this.orderCode = orderCode;
		this.itemName = itemName;
		this.categoryCode = categoryCode;
		this.categorySmall = categorySmall;
	}
	public FaultyVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
