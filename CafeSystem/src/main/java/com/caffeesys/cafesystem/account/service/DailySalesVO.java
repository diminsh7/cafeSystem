package com.caffeesys.cafesystem.account.service;

public class DailySalesVO {
	private int dailySalesCode;		//일매출관리코드
	private String statementNum;	//전표번호
	private String localCode;		//지역코드
	private String shopCode;		//매장코드
	private String dailySalesDate;	//날짜
	private int dailySalesAmount;	//일매출액
	
	public int getDailySalesCode() {
		return dailySalesCode;
	}
	public void setDailySalesCode(int dailySalesCode) {
		this.dailySalesCode = dailySalesCode;
	}
	public String getStatementNum() {
		return statementNum;
	}
	public void setStatementNum(String statementNum) {
		this.statementNum = statementNum;
	}
	public String getLocalCode() {
		return localCode;
	}
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	public String getShopCode() {
		return shopCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	public String getDailySalesDate() {
		return dailySalesDate;
	}
	public void setDailySalesDate(String dailySalesDate) {
		this.dailySalesDate = dailySalesDate;
	}
	public int getDailySalesAmount() {
		return dailySalesAmount;
	}
	public void setDailySalesAmount(int dailySalesAmount) {
		this.dailySalesAmount = dailySalesAmount;
	}
	
	@Override
	public String toString() {
		return "DailySalesVO [dailySalesCode=" + dailySalesCode + ", statementNum=" + statementNum + ", localCode="
				+ localCode + ", shopCode=" + shopCode + ", dailySalesDate=" + dailySalesDate + ", dailySalesAmount="
				+ dailySalesAmount + "]";
	}
}
