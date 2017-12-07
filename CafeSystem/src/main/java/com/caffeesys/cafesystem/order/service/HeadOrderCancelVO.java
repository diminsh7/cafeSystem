package com.caffeesys.cafesystem.order.service;

public class HeadOrderCancelVO {
	private int orderCancelCode; // 발주취소 관리코드
	private String statementNumber; // 전표번호
	private String receiptCategoryCode; // 접수상태번호
	private String orderRefundStatement; // 환불전표번호
	private String orderCancelRequest; // 취소신청일
	private String orderCancelApproval; // 취소승인일
	private String headEmployeeCode; // 취소승인 담당자
	private String orderRefundAble; // 환불여부
	private String orderRefundDate; // 환불날짜
	private String orderRefundAdmin; // 환불승인 담당자
	// ---------↑DB용↑-----↓View용↓-------------
	private String receiptCateName; // 접수상태이름

	@Override
	public String toString() {
		return "HeadOrderCancelVO [orderCancelCode=" + orderCancelCode + ", statementNumber=" + statementNumber
				+ ", receiptCategoryCode=" + receiptCategoryCode + ", orderRefundStatement=" + orderRefundStatement
				+ ", orderCancelRequest=" + orderCancelRequest + ", orderCancelApproval=" + orderCancelApproval
				+ ", headEmployeeCode=" + headEmployeeCode + ", orderRefundAble=" + orderRefundAble
				+ ", orderRefundDate=" + orderRefundDate + ", orderRefundAdmin=" + orderRefundAdmin
				+ ", receiptCateName=" + receiptCateName + "]";
	}

	public int getOrderCancelCode() {
		return orderCancelCode;
	}

	public void setOrderCancelCode(int orderCancelCode) {
		this.orderCancelCode = orderCancelCode;
	}

	public String getStatementNumber() {
		return statementNumber;
	}

	public void setStatementNumber(String statementNumber) {
		this.statementNumber = statementNumber;
	}

	public String getReceiptCategoryCode() {
		return receiptCategoryCode;
	}

	public void setReceiptCategoryCode(String receiptCategoryCode) {
		this.receiptCategoryCode = receiptCategoryCode;
	}

	public String getOrderRefundStatement() {
		return orderRefundStatement;
	}

	public void setOrderRefundStatement(String orderRefundStatement) {
		this.orderRefundStatement = orderRefundStatement;
	}

	public String getOrderCancelRequest() {
		return orderCancelRequest;
	}

	public void setOrderCancelRequest(String orderCancelRequest) {
		this.orderCancelRequest = orderCancelRequest;
	}

	public String getOrderCancelApproval() {
		return orderCancelApproval;
	}

	public void setOrderCancelApproval(String orderCancelApproval) {
		this.orderCancelApproval = orderCancelApproval;
	}

	public String getHeadEmployeeCode() {
		return headEmployeeCode;
	}

	public void setHeadEmployeeCode(String headEmployeeCode) {
		this.headEmployeeCode = headEmployeeCode;
	}

	public String getOrderRefundAble() {
		return orderRefundAble;
	}

	public void setOrderRefundAble(String orderRefundAble) {
		this.orderRefundAble = orderRefundAble;
	}

	public String getOrderRefundDate() {
		return orderRefundDate;
	}

	public void setOrderRefundDate(String orderRefundDate) {
		this.orderRefundDate = orderRefundDate;
	}

	public String getOrderRefundAdmin() {
		return orderRefundAdmin;
	}

	public void setOrderRefundAdmin(String orderRefundAdmin) {
		this.orderRefundAdmin = orderRefundAdmin;
	}

	public String getReceiptCateName() {
		return receiptCateName;
	}

	public void setReceiptCateName(String receiptCateName) {
		this.receiptCateName = receiptCateName;
	}

}