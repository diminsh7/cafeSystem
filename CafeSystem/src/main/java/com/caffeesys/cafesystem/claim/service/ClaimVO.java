package com.caffeesys.cafesystem.claim.service;

public class ClaimVO {
	private int claimCode; // 클레임 관리코드 (PK)
	private String claimCategoryCode; // 카테고리 (FK)
	private String employeeCode; // 직원코드 (FK)
	private String claimTitle; // 제목
	private String claimContents; // 내용
	private String claimDate; // 날짜
	private String claimFile; // 첨부파일 저장경로
	private String claimCategoryName; // 카테고리 이름 저장용

	public ClaimVO() {
		super();
	}

	public ClaimVO(int claimCode, String claimCategoryCode, String employeeCode, String claimTitle,
			String claimContents, String claimDate, String claimFile,
			String claimCategoryName) {
		super();
		this.claimCode = claimCode;
		this.claimCategoryCode = claimCategoryCode;
		this.employeeCode = employeeCode;
		this.claimTitle = claimTitle;
		this.claimContents = claimContents;
		this.claimDate = claimDate;
		this.claimFile = claimFile;
		this.claimCategoryName = claimCategoryName;
	}

	@Override
	public String toString() {
		return "ClaimVO [claimCode=" + claimCode + ", claimCategoryCode=" + claimCategoryCode
				+ ", employeeCode=" + employeeCode + ", claimTitle=" + claimTitle
				+ ", claimContents=" + claimContents + ", claimDate=" + claimDate
				+ ", claimFile=" + claimFile + ", claimCategoryName=" + claimCategoryName
				+ ", getclaimCode()=" + getclaimCode() + ", getClaimCategoryCode()="
				+ getClaimCategoryCode() + ", getEmployeeCode()=" + getEmployeeCode() + ", getclaimTitle()="
				+ getclaimTitle() + ", getclaimContents()=" + getclaimContents()
				+ ", getclaimDate()=" + getclaimDate() + ", getclaimFile()="
				+ getclaimFile() + ", getClaimCategoryName()=" + getClaimCategoryName() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public int getclaimCode() {
		return claimCode;
	}

	public void setclaimCode(int claimCode) {
		this.claimCode = claimCode;
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

	public String getclaimTitle() {
		return claimTitle;
	}

	public void setclaimTitle(String claimTitle) {
		this.claimTitle = claimTitle;
	}

	public String getclaimContents() {
		return claimContents;
	}

	public void setclaimContents(String claimContents) {
		this.claimContents = claimContents;
	}

	public String getclaimDate() {
		return claimDate;
	}

	public void setclaimDate(String claimDate) {
		this.claimDate = claimDate;
	}

	public String getclaimFile() {
		return claimFile;
	}

	public void setclaimFile(String claimFile) {
		this.claimFile = claimFile;
	}

	public String getClaimCategoryName() {
		return claimCategoryName;
	}

	public void setClaimCategoryName(String claimCategoryName) {
		this.claimCategoryName = claimCategoryName;
	}

}
