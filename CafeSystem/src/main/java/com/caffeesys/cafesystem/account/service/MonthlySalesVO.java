package com.caffeesys.cafesystem.account.service;

public class MonthlySalesVO {
	private int monthlySalesCode;		//월매출관리코드
	private String statementNum;		//전표번호
	private String localCode;			//지역코드
	private String shopCode;			//매장코드
	private String shopName;			//매장명
	private String monthlySalesDate;	//날짜
	private int monthlySalesAmount;		//월매출액
	private int monthlySalesMoneydue;	//실납부 예정금액
	
	public int getMonthlySalesCode() {
		return monthlySalesCode;
	}
	public void setMonthlySalesCode(int monthlySalesCode) {
		this.monthlySalesCode = monthlySalesCode;
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
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getMonthlySalesDate() {
		return monthlySalesDate;
	}
	public void setMonthlySalesDate(String monthlySalesDate) {
		this.monthlySalesDate = monthlySalesDate;
	}
	public int getMonthlySalesAmount() {
		return monthlySalesAmount;
	}
	public void setMonthlySalesAmount(int monthlySalesAmount) {
		this.monthlySalesAmount = monthlySalesAmount;
	}
	public int getMonthlySalesMoneydue() {
		return monthlySalesMoneydue;
	}
	public void setMonthlySalesMoneydue(int monthlySalesMoneydue) {
		this.monthlySalesMoneydue = monthlySalesMoneydue;
	}
	
	@Override
	public String toString() {
		return "MonthlySalesVO [monthlySalesCode=" + monthlySalesCode + ", statementNum=" + statementNum
				+ ", localCode=" + localCode + ", shopCode=" + shopCode + ", shopName=" + shopName
				+ ", monthlySalesDate=" + monthlySalesDate + ", monthlySalesAmount=" + monthlySalesAmount
				+ ", monthlySalesMoneydue=" + monthlySalesMoneydue + "]";
	}
}
