package com.caffeesys.cafesystem.employee.service;
  
public class BranchManagerVO {
 
	private String branchEmployeeCode; //직원코드
	private String localCategoryCode; //지역코드  
	private String shopCode; //매장코드
	private String positionCategoryCode; //직급코드
	private String branchEmployeeId; //아이디
	private String branchEmployeeName; //이름
	private int branchEmployeeBirth; //생년월일
	private String branchEmployeePhone; //연락처
	private String branchEmployeeAddress; //주소
	private String branchEmployeeCetificate; //보건증
	private String branchManagerWorknum; //사업자번호
	private String branchManagerStart; //사업시작일
	private String branchManagerBank; //사업계좌은행명
	private String branchManagerBanknum; //사업계좌
	private String shopName; //점포명
	private String categorySmall; //카테고리 내용
	private String categoryCode; //카테고리코드
	
	@Override
	public String toString() {
		return "BranchManagerVO [branchEmployeeCode=" + branchEmployeeCode + ", localCategoryCode=" + localCategoryCode
				+ ", shopCode=" + shopCode + ", positionCategoryCode=" + positionCategoryCode + ", branchEmployeeId="
				+ branchEmployeeId + ", branchEmployeeName=" + branchEmployeeName + ", branchEmployeeBirth="
				+ branchEmployeeBirth + ", branchEmployeePhone=" + branchEmployeePhone + ", branchEmployeeAddress="
				+ branchEmployeeAddress + ", branchEmployeeCetificate=" + branchEmployeeCetificate
				+ ", branchManagerWorknum=" + branchManagerWorknum + ", branchManagerStart=" + branchManagerStart
				+ ", branchManagerBank=" + branchManagerBank + ", branchManagerBanknum=" + branchManagerBanknum
				+ ", shopName=" + shopName + ", categorySmall=" + categorySmall + ", categoryCode=" + categoryCode
				+ "]";
	}

	public String getBranchEmployeeCode() {
		return branchEmployeeCode;
	}

	public void setBranchEmployeeCode(String branchEmployeeCode) {
		this.branchEmployeeCode = branchEmployeeCode;
	}

	public String getLocalCategoryCode() {
		return localCategoryCode;
	}

	public void setLocalCategoryCode(String localCategoryCode) {
		this.localCategoryCode = localCategoryCode;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getPositionCategoryCode() {
		return positionCategoryCode;
	}

	public void setPositionCategoryCode(String positionCategoryCode) {
		this.positionCategoryCode = positionCategoryCode;
	}

	public String getBranchEmployeeId() {
		return branchEmployeeId;
	}

	public void setBranchEmployeeId(String branchEmployeeId) {
		this.branchEmployeeId = branchEmployeeId;
	}

	public String getBranchEmployeeName() {
		return branchEmployeeName;
	}

	public void setBranchEmployeeName(String branchEmployeeName) {
		this.branchEmployeeName = branchEmployeeName;
	}

	public int getBranchEmployeeBirth() {
		return branchEmployeeBirth;
	}

	public void setBranchEmployeeBirth(int branchEmployeeBirth) {
		this.branchEmployeeBirth = branchEmployeeBirth;
	}

	public String getBranchEmployeePhone() {
		return branchEmployeePhone;
	}

	public void setBranchEmployeePhone(String branchEmployeePhone) {
		this.branchEmployeePhone = branchEmployeePhone;
	}

	public String getBranchEmployeeAddress() {
		return branchEmployeeAddress;
	}

	public void setBranchEmployeeAddress(String branchEmployeeAddress) {
		this.branchEmployeeAddress = branchEmployeeAddress;
	}

	public String getBranchEmployeeCetificate() {
		return branchEmployeeCetificate;
	}

	public void setBranchEmployeeCetificate(String branchEmployeeCetificate) {
		this.branchEmployeeCetificate = branchEmployeeCetificate;
	}

	public String getBranchManagerWorknum() {
		return branchManagerWorknum;
	}

	public void setBranchManagerWorknum(String branchManagerWorknum) {
		this.branchManagerWorknum = branchManagerWorknum;
	}

	public String getBranchManagerStart() {
		return branchManagerStart;
	}

	public void setBranchManagerStart(String branchManagerStart) {
		this.branchManagerStart = branchManagerStart;
	}

	public String getBranchManagerBank() {
		return branchManagerBank;
	}

	public void setBranchManagerBank(String branchManagerBank) {
		this.branchManagerBank = branchManagerBank;
	}

	public String getBranchManagerBanknum() {
		return branchManagerBanknum;
	}

	public void setBranchManagerBanknum(String branchManagerBanknum) {
		this.branchManagerBanknum = branchManagerBanknum;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getCategorySmall() {
		return categorySmall;
	}

	public void setCategorySmall(String categorySmall) {
		this.categorySmall = categorySmall;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public BranchManagerVO(String branchEmployeeCode, String localCategoryCode, String shopCode,
			String positionCategoryCode, String branchEmployeeId, String branchEmployeeName, int branchEmployeeBirth,
			String branchEmployeePhone, String branchEmployeeAddress, String branchEmployeeCetificate,
			String branchManagerWorknum, String branchManagerStart, String branchManagerBank,
			String branchManagerBanknum, String shopName, String categorySmall, String categoryCode) {
		super();
		this.branchEmployeeCode = branchEmployeeCode;
		this.localCategoryCode = localCategoryCode;
		this.shopCode = shopCode;
		this.positionCategoryCode = positionCategoryCode;
		this.branchEmployeeId = branchEmployeeId;
		this.branchEmployeeName = branchEmployeeName;
		this.branchEmployeeBirth = branchEmployeeBirth;
		this.branchEmployeePhone = branchEmployeePhone;
		this.branchEmployeeAddress = branchEmployeeAddress;
		this.branchEmployeeCetificate = branchEmployeeCetificate;
		this.branchManagerWorknum = branchManagerWorknum;
		this.branchManagerStart = branchManagerStart;
		this.branchManagerBank = branchManagerBank;
		this.branchManagerBanknum = branchManagerBanknum;
		this.shopName = shopName;
		this.categorySmall = categorySmall;
		this.categoryCode = categoryCode;
	}

	public BranchManagerVO() {
		super();
	}

}