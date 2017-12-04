package com.caffeesys.cafesystem.account.service;

public class FeeVO {
	private int feeCode;				//가맹수수료 관리코드
	private String statementNum;		//전표번호
	private String shopName;			//매장명
	private String feeMonth;			//연월
	private int monthlySalesCode;		//월매출 관리코드
	private int feePrice;				//수수료 납부액
	private String feeAuto;				//자동 이체일
	private String feeReal;				//실이체일
	private int feeRemain;				//잔여 납부금
	
	public int getFeeCode() {
		return feeCode;
	}
	public void setFeeCode(int feeCode) {
		this.feeCode = feeCode;
	}
	public String getStatementNum() {
		return statementNum;
	}
	public void setStatementNum(String statementNum) {
		this.statementNum = statementNum;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getFeeMonth() {
		return feeMonth;
	}
	public void setFeeMonth(String feeMonth) {
		this.feeMonth = feeMonth;
	}
	public int getMonthlySalesCode() {
		return monthlySalesCode;
	}
	public void setMonthlySalesCode(int monthlySalesCode) {
		this.monthlySalesCode = monthlySalesCode;
	}
	public int getFeePrice() {
		return feePrice;
	}
	public void setFeePrice(int feePrice) {
		this.feePrice = feePrice;
	}
	public String getFeeAuto() {
		return feeAuto;
	}
	public void setFeeAuto(String feeAuto) {
		this.feeAuto = feeAuto;
	}
	public String getFeeReal() {
		return feeReal;
	}
	public void setFeeReal(String feeReal) {
		this.feeReal = feeReal;
	}
	public int getFeeRemain() {
		return feeRemain;
	}
	public void setFeeRemain(int feeRemain) {
		this.feeRemain = feeRemain;
	}
	
	@Override
	public String toString() {
		return "FeeVO [feeCode=" + feeCode + ", statementNum=" + statementNum + ", shopName=" + shopName + ", feeMonth="
				+ feeMonth + ", monthlySalesCode=" + monthlySalesCode + ", feePrice=" + feePrice + ", feeAuto="
				+ feeAuto + ", feeReal=" + feeReal + ", feeRemain=" + feeRemain + "]";
	}
}
