package com.caffeesys.cafesystem.shop.service;

public class ShopVO {

	private String localCategoryCode; // 지역코드(PK)
	private String shopCode; // 매장코드(PK)
	private String contractCode; // 계약코드(FK)
	private String shopName; // 점포명
	private String shopAddress; // 점포주소
	private String shopCall; // 점포연락처
	private String shopPostcode; // 점포우편번호
	private int shopSize; // 점포규모
	private String contractOwnerName; // contract소유자이름
	private String categoryCode; // category코드
	private String categorySmall; // category소분류001~017
	
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
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getShopCall() {
		return shopCall;
	}
	public void setShopCall(String shopCall) {
		this.shopCall = shopCall;
	}
	public String getShopPostcode() {
		return shopPostcode;
	}
	public void setShopPostcode(String shopPostcode) {
		this.shopPostcode = shopPostcode;
	}
	public int getShopSize() {
		return shopSize;
	}
	public void setShopSize(int shopSize) {
		this.shopSize = shopSize;
	}
	public String getContractOwnerName() {
		return contractOwnerName;
	}
	public void setContractOwnerName(String contractOwnerName) {
		this.contractOwnerName = contractOwnerName;
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
		return "ShopVO [localCategoryCode=" + localCategoryCode + ", shopCode=" + shopCode + ", contractCode="
				+ contractCode + ", shopName=" + shopName + ", shopAddress=" + shopAddress + ", shopCall=" + shopCall
				+ ", shopPostcode=" + shopPostcode + ", shopSize=" + shopSize + ", contractOwnerName="
				+ contractOwnerName + ", categoryCode=" + categoryCode + ", categorySmall=" + categorySmall + "]";
	}
	public ShopVO(String localCategoryCode, String shopCode, String contractCode, String shopName, String shopAddress,
			String shopCall, String shopPostcode, int shopSize, String contractOwnerName, String categoryCode,
			String categorySmall) {
		super();
		this.localCategoryCode = localCategoryCode;
		this.shopCode = shopCode;
		this.contractCode = contractCode;
		this.shopName = shopName;
		this.shopAddress = shopAddress;
		this.shopCall = shopCall;
		this.shopPostcode = shopPostcode;
		this.shopSize = shopSize;
		this.contractOwnerName = contractOwnerName;
		this.categoryCode = categoryCode;
		this.categorySmall = categorySmall;
	}
	public ShopVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}