package com.caffeesys.cafesystem.menu.service;

public class MenuInfoVO {
	private String menuCode; // 메뉴코드(PK)
	private String menuCategoryCode; // 메뉴카테고리
	private String menuName; // 메뉴명
	private String menuStart; // 출시일
	private String menuImage; // 메뉴 이미지
	private String menuRecipe; // 레시피 이미지
	private String categoryCode; // category코드
	private String categorySmall; // category소분류M101~M109
	
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getMenuCategoryCode() {
		return menuCategoryCode;
	}
	public void setMenuCategoryCode(String menuCategoryCode) {
		this.menuCategoryCode = menuCategoryCode;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuStart() {
		return menuStart;
	}
	public void setMenuStart(String menuStart) {
		this.menuStart = menuStart;
	}
	public String getMenuImage() {
		return menuImage;
	}
	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage;
	}
	public String getMenuRecipe() {
		return menuRecipe;
	}
	public void setMenuRecipe(String menuRecipe) {
		this.menuRecipe = menuRecipe;
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
		return "MenuVO [menuCode=" + menuCode + ", menuCategoryCode=" + menuCategoryCode + ", menuName=" + menuName
				+ ", menuStart=" + menuStart + ", menuImage=" + menuImage + ", menuRecipe=" + menuRecipe
				+ ", categoryCode=" + categoryCode + ", categorySmall=" + categorySmall + "]";
	}
	public MenuInfoVO(String menuCode, String menuCategoryCode, String menuName, String menuStart, String menuImage,
			String menuRecipe, String categoryCode, String categorySmall) {
		super();
		this.menuCode = menuCode;
		this.menuCategoryCode = menuCategoryCode;
		this.menuName = menuName;
		this.menuStart = menuStart;
		this.menuImage = menuImage;
		this.menuRecipe = menuRecipe;
		this.categoryCode = categoryCode;
		this.categorySmall = categorySmall;
	}
	public MenuInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
