package com.caffeesys.cafesystem.menu.service;

public class MaterialVO {  
	private int materialCode; // 재료원가관리코드
	private String menuCode; // 메뉴코드
	private String tempCategoryCode; //온도코드
	private String sizeCategoryCode; // 사이즈코드
	private String itemCode; // 품목코드
	private String materialMeasure; // 단위
	private int materialCost; // 단가(원)
	private String menuName; //메뉴이름
	private String itemName; //품목이름
	private String tempcate; //온도 명
	private String sizecate; //사이즈 명
	private String categorySmall; //그 외 카테고리
	
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
	public String getTempCategoryCode() {
		return tempCategoryCode;
	}
	public void setTempCategoryCode(String tempCategoryCode) {
		this.tempCategoryCode = tempCategoryCode;
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
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getTempcate() {
		return tempcate;
	}
	public void setTempcate(String tempcate) {
		this.tempcate = tempcate;
	}
	public String getSizecate() {
		return sizecate;
	}
	public void setSizecate(String sizecate) {
		this.sizecate = sizecate;
	}
	public String getCategorySmall() {
		return categorySmall;
	}
	public void setCategorySmall(String categorySmall) {
		this.categorySmall = categorySmall;
	}

	@Override
	public String toString() {
		return "MaterialVO [materialCode=" + materialCode + ", menuCode=" + menuCode + ", tempCategoryCode="
				+ tempCategoryCode + ", sizeCategoryCode=" + sizeCategoryCode + ", itemCode=" + itemCode
				+ ", materialMeasure=" + materialMeasure + ", materialCost=" + materialCost + ", menuName=" + menuName
				+ ", itemName=" + itemName + ", tempcate=" + tempcate + ", sizecate=" + sizecate + ", categorySmall="
				+ categorySmall + "]";
	}

	public MaterialVO(int materialCode, String menuCode, String tempCategoryCode, String sizeCategoryCode,
			String itemCode, String materialMeasure, int materialCost, String menuName, String itemName,
			String tempcate, String sizecate, String categorySmall) {
		super();
		this.materialCode = materialCode;
		this.menuCode = menuCode;
		this.tempCategoryCode = tempCategoryCode;
		this.sizeCategoryCode = sizeCategoryCode;
		this.itemCode = itemCode;
		this.materialMeasure = materialMeasure;
		this.materialCost = materialCost;
		this.menuName = menuName;
		this.itemName = itemName;
		this.tempcate = tempcate;
		this.sizecate = sizecate;
		this.categorySmall = categorySmall;
	}
	
	public MaterialVO() {
		super();
	}
	
}