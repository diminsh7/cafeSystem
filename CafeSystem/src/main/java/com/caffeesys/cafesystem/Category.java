package com.caffeesys.cafesystem;

public class Category {
	private String categoryCode;
	private String categoryLarge;
	private String categoryMiddle;
	private String categorySmall;

	@Override
	public String toString() {
		return "Category [categoryCode=" + categoryCode + ", categoryLarge=" + categoryLarge + ", categoryMiddle="
				+ categoryMiddle + ", categorySmall=" + categorySmall + "]";
	}

	public Category() {
		super();
	}

	public Category(String categoryCode, String categoryLarge, String categoryMiddle, String categorySmall) {
		super();
		this.categoryCode = categoryCode;
		this.categoryLarge = categoryLarge;
		this.categoryMiddle = categoryMiddle;
		this.categorySmall = categorySmall;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryLarge() {
		return categoryLarge;
	}

	public void setCategoryLarge(String categoryLarge) {
		this.categoryLarge = categoryLarge;
	}

	public String getCategoryMiddle() {
		return categoryMiddle;
	}

	public void setCategoryMiddle(String categoryMiddle) {
		this.categoryMiddle = categoryMiddle;
	}

	public String getCategorySmall() {
		return categorySmall;
	}

	public void setCategorySmall(String categorySmall) {
		this.categorySmall = categorySmall;
	}

}
