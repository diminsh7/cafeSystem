package com.caffeesys.cafesystem.claim.service;

public class ClaimVO {
	private int customerClaimCode; // 클레임 관리코드 (PK)
	private String claimCategoryCode; // 카테고리 (FK)
	private String employeeCode; // 직원코드 (FK)
	private String customerClaimTitle; // 제목
	private String customerClaimContents; // 내용
	private String customerClaimDate; // 날짜
	private String customerClaimFile; // 첨부파일 저장경로
	private String claimCategoryName; // 카테고리 이름 저장용

	public ClaimVO() {
		super();
	}

	public ClaimVO(int customerClaimCode, String claimCategoryCode, String employeeCode, String customerClaimTitle,
			String customerClaimContents, String customerClaimDate, String customerClaimFile,
			String claimCategoryName) {
		super();
		this.customerClaimCode = customerClaimCode;
		this.claimCategoryCode = claimCategoryCode;
		this.employeeCode = employeeCode;
		this.customerClaimTitle = customerClaimTitle;
		this.customerClaimContents = customerClaimContents;
		this.customerClaimDate = customerClaimDate;
		this.customerClaimFile = customerClaimFile;
		this.claimCategoryName = claimCategoryName;
	}

	@Override
	public String toString() {
		return "ClaimVO [customerClaimCode=" + customerClaimCode + ", claimCategoryCode=" + claimCategoryCode
				+ ", employeeCode=" + employeeCode + ", customerClaimTitle=" + customerClaimTitle
				+ ", customerClaimContents=" + customerClaimContents + ", customerClaimDate=" + customerClaimDate
				+ ", customerClaimFile=" + customerClaimFile + ", claimCategoryName=" + claimCategoryName
				+ ", getCustomerClaimCode()=" + getCustomerClaimCode() + ", getClaimCategoryCode()="
				+ getClaimCategoryCode() + ", getEmployeeCode()=" + getEmployeeCode() + ", getCustomerClaimTitle()="
				+ getCustomerClaimTitle() + ", getCustomerClaimContents()=" + getCustomerClaimContents()
				+ ", getCustomerClaimDate()=" + getCustomerClaimDate() + ", getCustomerClaimFile()="
				+ getCustomerClaimFile() + ", getClaimCategoryName()=" + getClaimCategoryName() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public int getCustomerClaimCode() {
		return customerClaimCode;
	}

	public void setCustomerClaimCode(int customerClaimCode) {
		this.customerClaimCode = customerClaimCode;
	}

	public String getClaimCategoryCode() {
		return claimCategoryCode;
	}

	public void setClaimCategoryCode(String claimCategoryCode) {
		this.claimCategoryCode = claimCategoryCode;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getCustomerClaimTitle() {
		return customerClaimTitle;
	}

	public void setCustomerClaimTitle(String customerClaimTitle) {
		this.customerClaimTitle = customerClaimTitle;
	}

	public String getCustomerClaimContents() {
		return customerClaimContents;
	}

	public void setCustomerClaimContents(String customerClaimContents) {
		this.customerClaimContents = customerClaimContents;
	}

	public String getCustomerClaimDate() {
		return customerClaimDate;
	}

	public void setCustomerClaimDate(String customerClaimDate) {
		this.customerClaimDate = customerClaimDate;
	}

	public String getCustomerClaimFile() {
		return customerClaimFile;
	}

	public void setCustomerClaimFile(String customerClaimFile) {
		this.customerClaimFile = customerClaimFile;
	}

	public String getClaimCategoryName() {
		return claimCategoryName;
	}

	public void setClaimCategoryName(String claimCategoryName) {
		this.claimCategoryName = claimCategoryName;
	}

}
