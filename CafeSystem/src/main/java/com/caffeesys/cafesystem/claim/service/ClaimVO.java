package com.caffeesys.cafesystem.claim.service;

public class ClaimVO {
	private int claimCode; // 클레임 관리코드 (PK)
	private String claimCategoryCode; // 카테고리 (FK)
	private String employeeCode; // 직원코드 (FK)
	private String claimTitle; // 제목
	private String claimContents; // 내용
	private String claimFile; // 첨부파일 저장경로
	private int claimReRef; // 답글의 원글 번호
	private int claimReLev; // 해당 원글의 몇번째 답글인가
	private int claimReSeq; // 답글 정렬을 위한 시퀀스
	private String claimDate; // 날짜
	private String claimCategoryName; // 카테고리 이름 저장용

	@Override
	public String toString() {
		return "ClaimVO [claimCode=" + claimCode + ", claimCategoryCode=" + claimCategoryCode + ", employeeCode="
				+ employeeCode + ", claimTitle=" + claimTitle + ", claimContents=" + claimContents + ", claimDate="
				+ claimDate + ", claimFile=" + claimFile + ", claimReRef=" + claimReRef + ", claimReLev=" + claimReLev
				+ ", claimReSeq=" + claimReSeq + ", claimCategoryName=" + claimCategoryName + "]";
	}

	public ClaimVO() {
		super();
	}

	public ClaimVO(int claimCode, String claimCategoryCode, String employeeCode, String claimTitle,
			String claimContents, String claimDate, String claimFile, int claimReRef, int claimReLev, int claimReSeq,
			String claimCategoryName) {
		super();
		this.claimCode = claimCode;
		this.claimCategoryCode = claimCategoryCode;
		this.employeeCode = employeeCode;
		this.claimTitle = claimTitle;
		this.claimContents = claimContents;
		this.claimDate = claimDate;
		this.claimFile = claimFile;
		this.claimReRef = claimReRef;
		this.claimReLev = claimReLev;
		this.claimReSeq = claimReSeq;
		this.claimCategoryName = claimCategoryName;
	}

	public int getClaimCode() {
		return claimCode;
	}

	public void setClaimCode(int claimCode) {
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

	public String getClaimTitle() {
		return claimTitle;
	}

	public void setClaimTitle(String claimTitle) {
		this.claimTitle = claimTitle;
	}

	public String getClaimContents() {
		return claimContents;
	}

	public void setClaimContents(String claimContents) {
		this.claimContents = claimContents;
	}

	public String getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimFile() {
		return claimFile;
	}

	public void setClaimFile(String claimFile) {
		this.claimFile = claimFile;
	}

	public int getClaimReRef() {
		return claimReRef;
	}

	public void setClaimReRef(int claimReRef) {
		this.claimReRef = claimReRef;
	}

	public int getClaimReLev() {
		return claimReLev;
	}

	public void setClaimReLev(int claimReLev) {
		this.claimReLev = claimReLev;
	}

	public int getClaimReSeq() {
		return claimReSeq;
	}

	public void setClaimReSeq(int claimReSeq) {
		this.claimReSeq = claimReSeq;
	}

	public String getClaimCategoryName() {
		return claimCategoryName;
	}

	public void setClaimCategoryName(String claimCategoryName) {
		this.claimCategoryName = claimCategoryName;
	}

}