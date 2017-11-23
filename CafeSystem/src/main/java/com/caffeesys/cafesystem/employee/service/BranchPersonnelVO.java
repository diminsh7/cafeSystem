package com.caffeesys.cafesystem.employee.service;

public class BranchPersonnelVO {

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
	private String branchPersonnelJoin; //입사일
	private int branchPersonnelSalary; //월급
	private String branchPersonnelBank; //월급계좌은행명
	private String branchPersonnelBanknum; //월급계좌번호
	private String branchPersonnelContract; //근로계약서
	private String shopName; //점포명
	private String categorySmall; //직급명
	
	
	public String getBranchEmployeeCode() {
		return branchEmployeeCode;
	}
	public String getLocalCategoryCode() {
		return localCategoryCode;
	}
	public String getShopCode() {
		return shopCode;
	}
	public String getPositionCategoryCode() {
		return positionCategoryCode;
	}
	public String getBranchEmployeeId() {
		return branchEmployeeId;
	}
	public String getBranchEmployeeName() {
		return branchEmployeeName;
	}
	public int getBranchEmployeeBirth() {
		return branchEmployeeBirth;
	}
	public String getBranchEmployeePhone() {
		return branchEmployeePhone;
	}
	public String getBranchEmployeeAddress() {
		return branchEmployeeAddress;
	}
	public String getBranchEmployeeCetificate() {
		return branchEmployeeCetificate;
	}
	public String getBranchPersonnelJoin() {
		return branchPersonnelJoin;
	}
	public int getBranchPersonnelSalary() {
		return branchPersonnelSalary;
	}
	public String getBranchPersonnelBank() {
		return branchPersonnelBank;
	}
	public String getBranchPersonnelBanknum() {
		return branchPersonnelBanknum;
	}
	public String getBranchPersonnelContract() {
		return branchPersonnelContract;
	}
	public String getShopName() {
		return shopName;
	}
	public String getCategorySmall() {
		return categorySmall;
	}
	public void setBranchEmployeeCode(String branchEmployeeCode) {
		this.branchEmployeeCode = branchEmployeeCode;
	}
	public void setLocalCategoryCode(String localCategoryCode) {
		this.localCategoryCode = localCategoryCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	public void setPositionCategoryCode(String positionCategoryCode) {
		this.positionCategoryCode = positionCategoryCode;
	}
	public void setBranchEmployeeId(String branchEmployeeId) {
		this.branchEmployeeId = branchEmployeeId;
	}
	public void setBranchEmployeeName(String branchEmployeeName) {
		this.branchEmployeeName = branchEmployeeName;
	}
	public void setBranchEmployeeBirth(int branchEmployeeBirth) {
		this.branchEmployeeBirth = branchEmployeeBirth;
	}
	public void setBranchEmployeePhone(String branchEmployeePhone) {
		this.branchEmployeePhone = branchEmployeePhone;
	}
	public void setBranchEmployeeAddress(String branchEmployeeAddress) {
		this.branchEmployeeAddress = branchEmployeeAddress;
	}
	public void setBranchEmployeeCetificate(String branchEmployeeCetificate) {
		this.branchEmployeeCetificate = branchEmployeeCetificate;
	}
	public void setBranchPersonnelJoin(String branchPersonnelJoin) {
		this.branchPersonnelJoin = branchPersonnelJoin;
	}
	public void setBranchPersonnelSalary(int branchPersonnelSalary) {
		this.branchPersonnelSalary = branchPersonnelSalary;
	}
	public void setBranchPersonnelBank(String branchPersonnelBank) {
		this.branchPersonnelBank = branchPersonnelBank;
	}
	public void setBranchPersonnelBanknum(String branchPersonnelBanknum) {
		this.branchPersonnelBanknum = branchPersonnelBanknum;
	}
	public void setBranchPersonnelContract(String branchPersonnelContract) {
		this.branchPersonnelContract = branchPersonnelContract;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public void setCategorySmall(String categorySmall) {
		this.categorySmall = categorySmall;
	}
	@Override
	public String toString() {
		return "BranchPersonnelVO [branchEmployeeCode=" + branchEmployeeCode + ", localCategoryCode="
				+ localCategoryCode + ", shopCode=" + shopCode + ", positionCategoryCode=" + positionCategoryCode
				+ ", branchEmployeeId=" + branchEmployeeId + ", branchEmployeeName=" + branchEmployeeName
				+ ", branchEmployeeBirth=" + branchEmployeeBirth + ", branchEmployeePhone=" + branchEmployeePhone
				+ ", branchEmployeeAddress=" + branchEmployeeAddress + ", branchEmployeeCetificate="
				+ branchEmployeeCetificate + ", branchPersonnelJoin=" + branchPersonnelJoin + ", branchPersonnelSalary="
				+ branchPersonnelSalary + ", branchPersonnelBank=" + branchPersonnelBank + ", branchPersonnelBanknum="
				+ branchPersonnelBanknum + ", branchPersonnelContract=" + branchPersonnelContract + ", shopName="
				+ shopName + ", categorySmall=" + categorySmall + "]";
	}
	public BranchPersonnelVO(String branchEmployeeCode, String localCategoryCode, String shopCode,
			String positionCategoryCode, String branchEmployeeId, String branchEmployeeName, int branchEmployeeBirth,
			String branchEmployeePhone, String branchEmployeeAddress, String branchEmployeeCetificate,
			String branchPersonnelJoin, int branchPersonnelSalary, String branchPersonnelBank,
			String branchPersonnelBanknum, String branchPersonnelContract, String shopName, String categorySmall) {
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
		this.branchPersonnelJoin = branchPersonnelJoin;
		this.branchPersonnelSalary = branchPersonnelSalary;
		this.branchPersonnelBank = branchPersonnelBank;
		this.branchPersonnelBanknum = branchPersonnelBanknum;
		this.branchPersonnelContract = branchPersonnelContract;
		this.shopName = shopName;
		this.categorySmall = categorySmall;
	}
	
	public BranchPersonnelVO() {
		super();
	}

	
	

	
}
