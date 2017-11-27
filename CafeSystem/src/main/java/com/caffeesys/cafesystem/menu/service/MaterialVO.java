package com.caffeesys.cafesystem.menu.service;

public class MaterialVO {
	private int materialCode; // 재료원가관리코드
	private String menuCode; // 메뉴코드
	private String sizeCategoryCode; // 사이즈
	private String itemCode; // 품목코드
	private String materialMeasure; // 단위
	private int materialCost; // 단가(원)
	private String tempCategoryCode; //온도
	public int getMaterialCode() {
		return materialCode;
	}
	public void setMaterialCode(int materialCode) {
		this.materialCode = materialCode;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getSizeCategoryCode() {
		return sizeCategoryCode;
	}
	public void setSizeCategoryCode(String sizeCategoryCode) {
		this.sizeCategoryCode = sizeCategoryCode;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getMaterialMeasure() {
		return materialMeasure;
	}
	public void setMaterialMeasure(String materialMeasure) {
		this.materialMeasure = materialMeasure;
	}
	public int getMaterialCost() {
		return materialCost;
	}
	public void setMaterialCost(int materialCost) {
		this.materialCost = materialCost;
	}
	public String getTempCategoryCode() {
		return tempCategoryCode;
	}
	public void setTempCategoryCode(String tempCategoryCode) {
		this.tempCategoryCode = tempCategoryCode;
	}
	@Override
	public String toString() {
		return "MaterialVO [materialCode=" + materialCode + ", menuCode=" + menuCode + ", sizeCategoryCode="
				+ sizeCategoryCode + ", itemCode=" + itemCode + ", materialMeasure=" + materialMeasure
				+ ", materialCost=" + materialCost + ", tempCategoryCode=" + tempCategoryCode + "]";
	}
	public MaterialVO(int materialCode, String menuCode, String sizeCategoryCode, String itemCode,
			String materialMeasure, int materialCost, String tempCategoryCode) {
		super();
		this.materialCode = materialCode;
		this.menuCode = menuCode;
		this.sizeCategoryCode = sizeCategoryCode;
		this.itemCode = itemCode;
		this.materialMeasure = materialMeasure;
		this.materialCost = materialCost;
		this.tempCategoryCode = tempCategoryCode;
	}
	public MaterialVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}