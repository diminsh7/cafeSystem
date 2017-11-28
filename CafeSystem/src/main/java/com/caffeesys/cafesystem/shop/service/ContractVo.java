package com.caffeesys.cafesystem.shop.service;

public class ContractVo {
	private String contractCode; // 계약코드(PK)
	private String contractOwnerName; // 소유자명
	private String contractShopName; // 점포명
	private String contractOwnerPhone; // 소유자연락처
	private String contractStartDate; // 계약일
	private String contractEndDate; // 계약만료일
	private String contractPhoto; // 계약서사진
	
	public ContractVo() {
		super();
	}
	
	public ContractVo(String contractCode, String contractOwnerName, String contractShopName, String contractOwnerPhone,
			String contractStartDate, String contractEndDate, String contractPhoto) {
		super();
		this.contractCode = contractCode;
		this.contractOwnerName = contractOwnerName;
		this.contractShopName = contractShopName;
		this.contractOwnerPhone = contractOwnerPhone;
		this.contractStartDate = contractStartDate;
		this.contractEndDate = contractEndDate;
		this.contractPhoto = contractPhoto;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getContractOwnerName() {
		return contractOwnerName;
	}

	public void setContractOwnerName(String contractOwnerName) {
		this.contractOwnerName = contractOwnerName;
	}

	public String getContractShopName() {
		return contractShopName;
	}

	public void setContractShopName(String contractShopName) {
		this.contractShopName = contractShopName;
	}

	public String getContractOwnerPhone() {
		return contractOwnerPhone;
	}

	public void setContractOwnerPhone(String contractOwnerPhone) {
		this.contractOwnerPhone = contractOwnerPhone;
	}

	public String getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(String contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public String getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(String contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public String getContractPhoto() {
		return contractPhoto;
	}

	public void setContractPhoto(String contractPhoto) {
		this.contractPhoto = contractPhoto;
	}

	@Override
	public String toString() {
		return "Contract [contractCode=" + contractCode + ", contractOwnerName=" + contractOwnerName
				+ ", contractShopName=" + contractShopName + ", contractOwnerPhone=" + contractOwnerPhone
				+ ", contractStartDate=" + contractStartDate + ", contractEndDate=" + contractEndDate
				+ ", contractPhoto=" + contractPhoto + "]";
	}
}
