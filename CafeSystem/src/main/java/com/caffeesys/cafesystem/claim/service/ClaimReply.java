package com.caffeesys.cafesystem.claim.service;

public class ClaimReply {
	private int claimReplyCode;
	private int customerClaimCode;
	private String claimReplyContents;
	private String employeeCode;
	private String claimReplyDate;

	@Override
	public String toString() {
		return "ClaimReply [claimReplyCode=" + claimReplyCode + ", customerClaimCode=" + customerClaimCode
				+ ", claimReplyContents=" + claimReplyContents + ", employeeCode=" + employeeCode + ", claimReplyDate="
				+ claimReplyDate + "]";
	}

	public ClaimReply() {
		super();
	}

	public ClaimReply(int claimReplyCode, int customerClaimCode, String claimReplyContents, String employeeCode,
			String claimReplyDate) {
		super();
		this.claimReplyCode = claimReplyCode;
		this.customerClaimCode = customerClaimCode;
		this.claimReplyContents = claimReplyContents;
		this.employeeCode = employeeCode;
		this.claimReplyDate = claimReplyDate;
	}

	public int getClaimReplyCode() {
		return claimReplyCode;
	}

	public void setClaimReplyCode(int claimReplyCode) {
		this.claimReplyCode = claimReplyCode;
	}

	public int getCustomerClaimCode() {
		return customerClaimCode;
	}

	public void setCustomerClaimCode(int customerClaimCode) {
		this.customerClaimCode = customerClaimCode;
	}

	public String getClaimReplyContents() {
		return claimReplyContents;
	}

	public void setClaimReplyContents(String claimReplyContents) {
		this.claimReplyContents = claimReplyContents;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getClaimReplyDate() {
		return claimReplyDate;
	}

	public void setClaimReplyDate(String claimReplyDate) {
		this.claimReplyDate = claimReplyDate;
	}

}
