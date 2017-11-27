package com.caffeesys.cafesystem.menu.service;

public class MenuPriceVO {
	private int menuPriceCode; // 메뉴 가격 관리 코드
	private String menuCode; // 메뉴 코드
	private String tempCategory; // 냉온 카테고리
	private String sizeCategory; // 사이즈 카테고리
	private int menuTotalCost; // 메뉴 원가
	private int menuSellCost; // 메뉴 판매가
	private String menuName; // 메뉴 이름
	private String tempCateName; // 냉온 카테고리 이름
	private String sizeCateName; // 사이즈 카테고리 이름

	@Override
	public String toString() {
		return "MenuPriceVO [menuPriceCode=" + menuPriceCode + ", menuCode=" + menuCode + ", tempCategory="
				+ tempCategory + ", sizeCategory=" + sizeCategory + ", menuTotalCost=" + menuTotalCost
				+ ", menuSellCost=" + menuSellCost + ", menuName=" + menuName + ", tempCateName=" + tempCateName
				+ ", sizeCateName=" + sizeCateName + "]";
	}

	public MenuPriceVO() {
		super();
	}

	public MenuPriceVO(int menuPriceCode, String menuCode, String tempCategory, String sizeCategory, int menuTotalCost,
			int menuSellCost, String menuName, String tempCateName, String sizeCateName) {
		super();
		this.menuPriceCode = menuPriceCode;
		this.menuCode = menuCode;
		this.tempCategory = tempCategory;
		this.sizeCategory = sizeCategory;
		this.menuTotalCost = menuTotalCost;
		this.menuSellCost = menuSellCost;
		this.menuName = menuName;
		this.tempCateName = tempCateName;
		this.sizeCateName = sizeCateName;
	}

	public int getMenuPriceCode() {
		return menuPriceCode;
	}

	public void setMenuPriceCode(int menuPriceCode) {
		this.menuPriceCode = menuPriceCode;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getTempCategory() {
		return tempCategory;
	}

	public void setTempCategory(String tempCategory) {
		this.tempCategory = tempCategory;
	}

	public String getSizeCategory() {
		return sizeCategory;
	}

	public void setSizeCategory(String sizeCategory) {
		this.sizeCategory = sizeCategory;
	}

	public int getMenuTotalCost() {
		return menuTotalCost;
	}

	public void setMenuTotalCost(int menuTotalCost) {
		this.menuTotalCost = menuTotalCost;
	}

	public int getMenuSellCost() {
		return menuSellCost;
	}

	public void setMenuSellCost(int menuSellCost) {
		this.menuSellCost = menuSellCost;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getTempCateName() {
		return tempCateName;
	}

	public void setTempCateName(String tempCateName) {
		this.tempCateName = tempCateName;
	}

	public String getSizeCateName() {
		return sizeCateName;
	}

	public void setSizeCateName(String sizeCateName) {
		this.sizeCateName = sizeCateName;
	}

}
