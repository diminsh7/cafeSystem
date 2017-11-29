package com.caffeesys.cafesystem.order.service;

public class ItemVO {
	private String itemCode; // 품목코드(PK)
	private String itemCategoryCode; // 품목카테고리(FK)
	private String itemName; // 품목명
	private String itemSize; // 품목용량
	private int itemCost; // 품목원가
	private int itemProfit; // 품목마진
	private int itemPrice; // 품목가격
	private String itemDetail; // 품목상세
	private String itemImage; // 품목이미지
	private char itemAble; // 발주가능여부
	private String categoryCode; // category코드
	private String categorySmall; // category소분류601~608
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemCategoryCode() {
		return itemCategoryCode;
	}
	public void setItemCategoryCode(String itemCategoryCode) {
		this.itemCategoryCode = itemCategoryCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemSize() {
		return itemSize;
	}
	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}
	public int getItemCost() {
		return itemCost;
	}
	public void setItemCost(int itemCost) {
		this.itemCost = itemCost;
	}
	public int getItemProfit() {
		return itemProfit;
	}
	public void setItemProfit(int itemProfit) {
		this.itemProfit = itemProfit;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemDetail() {
		return itemDetail;
	}
	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public char getItemAble() {
		return itemAble;
	}
	public void setItemAble(char itemAble) {
		this.itemAble = itemAble;
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
		return "ItemVO [itemCode=" + itemCode + ", itemCategoryCode=" + itemCategoryCode + ", itemName=" + itemName
				+ ", itemSize=" + itemSize + ", itemCost=" + itemCost + ", itemProfit=" + itemProfit + ", itemPrice="
				+ itemPrice + ", itemDetail=" + itemDetail + ", itemImage=" + itemImage + ", itemAble=" + itemAble
				+ ", categoryCode=" + categoryCode + ", categorySmall=" + categorySmall + "]";
	}
	public ItemVO(String itemCode, String itemCategoryCode, String itemName, String itemSize, int itemCost,
			int itemProfit, int itemPrice, String itemDetail, String itemImage, char itemAble, String categoryCode,
			String categorySmall) {
		super();
		this.itemCode = itemCode;
		this.itemCategoryCode = itemCategoryCode;
		this.itemName = itemName;
		this.itemSize = itemSize;
		this.itemCost = itemCost;
		this.itemProfit = itemProfit;
		this.itemPrice = itemPrice;
		this.itemDetail = itemDetail;
		this.itemImage = itemImage;
		this.itemAble = itemAble;
		this.categoryCode = categoryCode;
		this.categorySmall = categorySmall;
	}
	public ItemVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
