package com.caffeesys.cafesystem.order.service;

public class BranchOrderVO {
	private String itemCode; // 품목코드
	private String itemCategoryCode; // 품목 카테고리 코드
	private String itemName; // 품목명
	private String itemSize; // 품목용량
	private int itemPrice; // 품목가격
	private int itemQuantity; // 품목 수량
	private String itemDetail; // 품목상세설명
	private String itemCateName; // 품목 카테고리 코드명

	@Override
	public String toString() {
		return "BranchOrderVO [itemCode=" + itemCode + ", itemCategoryCode=" + itemCategoryCode + ", itemName="
				+ itemName + ", itemSize=" + itemSize + ", itemPrice=" + itemPrice + ", itemQuantity=" + itemQuantity
				+ ", itemDetail=" + itemDetail + ", itemCateName=" + itemCateName + "]";
	}

	public BranchOrderVO() {
		super();
	}

	public BranchOrderVO(String itemCode, String itemCategoryCode, String itemName, String itemSize, int itemPrice,
			int itemQuantity, String itemDetail, String itemCateName) {
		super();
		this.itemCode = itemCode;
		this.itemCategoryCode = itemCategoryCode;
		this.itemName = itemName;
		this.itemSize = itemSize;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.itemDetail = itemDetail;
		this.itemCateName = itemCateName;
	}

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

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	public String getItemCateName() {
		return itemCateName;
	}

	public void setItemCateName(String itemCateName) {
		this.itemCateName = itemCateName;
	}

}
