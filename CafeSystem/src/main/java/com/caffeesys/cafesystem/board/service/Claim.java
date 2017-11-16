package com.caffeesys.cafesystem.board.service;

public class Claim {
	private int customerClaimCode; //클레임 관리코드 (PK)
	private String claimCategoryCode; //카테고리 (FK)
	private String employeeCode; //직원코드 (FK)
	private String customerClaimTitle; //제목
	private String customerClaimContents; //내용
	private String customerClaimDate; //날짜
	private String customerClaimFile; //첨부파일 저장경로
	private String headEmployeeAdmin; //관리담당자

	@Override
	public String toString() {
		return "Claim [customerClaimCode=" + customerClaimCode + ", claimCategoryCode=" + claimCategoryCode
				+ ", employeeCode=" + employeeCode + ", customerClaimTitle=" + customerClaimTitle
				+ ", customerClaimContents=" + customerClaimContents + ", customerClaimDate=" + customerClaimDate
				+ ", customerClaimFile=" + customerClaimFile + ", headEmployeeAdmin=" + headEmployeeAdmin + "]";
	}

	public Claim(int customerClaimCode, String claimCategoryCode, String employeeCode, String customerClaimTitle,
			String customerClaimContents, String customerClaimDate, String customerClaimFile,
			String headEmployeeAdmin) {
		super();
		this.customerClaimCode = customerClaimCode;
		this.claimCategoryCode = claimCategoryCode;
		this.employeeCode = employeeCode;
		this.customerClaimTitle = customerClaimTitle;
		this.customerClaimContents = customerClaimContents;
		this.customerClaimDate = customerClaimDate;
		this.customerClaimFile = customerClaimFile;
		this.headEmployeeAdmin = headEmployeeAdmin;
	}

	public Claim() {
		super();
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

	public String getHeadEmployeeAdmin() {
		return headEmployeeAdmin;
	}

	public void setHeadEmployeeAdmin(String headEmployeeAdmin) {
		this.headEmployeeAdmin = headEmployeeAdmin;
	}

}
