package com.caffeesys.cafesystem.menu.service;

public class MenuPriceVO {
	private int menuPriceCode;
	private String menuCode;
	private String tempCategory;
	private String sizeCategory;
	private int menuTotalCost;
	private int menuSellCost;

	@Override
	public String toString() {
		return "MenuPriceVO [menuPriceCode=" + menuPriceCode + ", menuCode=" + menuCode + ", tempCategory="
				+ tempCategory + ", sizeCategory=" + sizeCategory + ", menuTotalCost=" + menuTotalCost
				+ ", menuSellCost=" + menuSellCost + "]";
	}

	public MenuPriceVO() {
		super();
	}

	public MenuPriceVO(int menuPriceCode, String menuCode, String tempCategory, String sizeCategory, int menuTotalCost,
			int menuSellCost) {
		super();
		this.menuPriceCode = menuPriceCode;
		this.menuCode = menuCode;
		this.tempCategory = tempCategory;
		this.sizeCategory = sizeCategory;
		this.menuTotalCost = menuTotalCost;
		this.menuSellCost = menuSellCost;
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

}
