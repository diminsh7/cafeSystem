package com.caffeesys.cafesystem.employee.service;

public class HeadEmployeeVO {
	private String headEmployeeCode; //직원코드
	private String departmentCategoryCode; //부서코드
	private String headEmployeeId; //아이디
	private String headEmployeeName; //이름
	private int headEmployeeBirth; //생년월일
	private String headEmployeePhone; //전화번호
	private String headEmployeeAddress; //주소
	private String headEmployeeJoin; //입사일
	private int headEmployeeSalary; //월급
	private String bonusCategoryCode; // 상여금코드
	private String headEmployeeBanknum; // 월급계좌번호
	private String headEmployeeContract; // 근로계약서
	private String cateDepartment; // 부서명
	private String cateBonus; // 상여금
	public String getHeadEmployeeCode() {
		return headEmployeeCode;
	}
	public void setHeadEmployeeCode(String headEmployeeCode) {
		this.headEmployeeCode = headEmployeeCode;
	}
	public String getDepartmentCategoryCode() {
		return departmentCategoryCode;
	}
	public void setDepartmentCategoryCode(String departmentCategoryCode) {
		this.departmentCategoryCode = departmentCategoryCode;
	}
	public String getHeadEmployeeId() {
		return headEmployeeId;
	}
	public void setHeadEmployeeId(String headEmployeeId) {
		this.headEmployeeId = headEmployeeId;
	}
	public String getHeadEmployeeName() {
		return headEmployeeName;
	}
	public void setHeadEmployeeName(String headEmployeeName) {
		this.headEmployeeName = headEmployeeName;
	}
	public int getHeadEmployeeBirth() {
		return headEmployeeBirth;
	}
	public void setHeadEmployeeBirth(int headEmployeeBirth) {
		this.headEmployeeBirth = headEmployeeBirth;
	}
	public String getHeadEmployeePhone() {
		return headEmployeePhone;
	}
	public void setHeadEmployeePhone(String headEmployeePhone) {
		this.headEmployeePhone = headEmployeePhone;
	}
	public String getHeadEmployeeAddress() {
		return headEmployeeAddress;
	}
	public void setHeadEmployeeAddress(String headEmployeeAddress) {
		this.headEmployeeAddress = headEmployeeAddress;
	}
	public String getHeadEmployeeJoin() {
		return headEmployeeJoin;
	}
	public void setHeadEmployeeJoin(String headEmployeeJoin) {
		this.headEmployeeJoin = headEmployeeJoin;
	}
	public int getHeadEmployeeSalary() {
		return headEmployeeSalary;
	}
	public void setHeadEmployeeSalary(int headEmployeeSalary) {
		this.headEmployeeSalary = headEmployeeSalary;
	}
	public String getBonusCategoryCode() {
		return bonusCategoryCode;
	}
	public void setBonusCategoryCode(String bonusCategoryCode) {
		this.bonusCategoryCode = bonusCategoryCode;
	}
	public String getHeadEmployeeBanknum() {
		return headEmployeeBanknum;
	}
	public void setHeadEmployeeBanknum(String headEmployeeBanknum) {
		this.headEmployeeBanknum = headEmployeeBanknum;
	}
	public String getHeadEmployeeContract() {
		return headEmployeeContract;
	}
	public void setHeadEmployeeContract(String headEmployeeContract) {
		this.headEmployeeContract = headEmployeeContract;
	}
	public String getCateDepartment() {
		return cateDepartment;
	}
	public void setCateDepartment(String cateDepartment) {
		this.cateDepartment = cateDepartment;
	}
	public String getCateBonus() {
		return cateBonus;
	}
	public void setCateBonus(String cateBonus) {
		this.cateBonus = cateBonus;
	}
	@Override
	public String toString() {
		return "HeadEmployeeVO [headEmployeeCode=" + headEmployeeCode + ", departmentCategoryCode="
				+ departmentCategoryCode + ", headEmployeeId=" + headEmployeeId + ", headEmployeeName="
				+ headEmployeeName + ", headEmployeeBirth=" + headEmployeeBirth + ", headEmployeePhone="
				+ headEmployeePhone + ", headEmployeeAddress=" + headEmployeeAddress + ", headEmployeeJoin="
				+ headEmployeeJoin + ", headEmployeeSalary=" + headEmployeeSalary + ", bonusCategoryCode="
				+ bonusCategoryCode + ", headEmployeeBanknum=" + headEmployeeBanknum + ", headEmployeeContract="
				+ headEmployeeContract + ", cateDepartment=" + cateDepartment + ", cateBonus=" + cateBonus + "]";
	}
	public HeadEmployeeVO(String headEmployeeCode, String departmentCategoryCode, String headEmployeeId,
			String headEmployeeName, int headEmployeeBirth, String headEmployeePhone, String headEmployeeAddress,
			String headEmployeeJoin, int headEmployeeSalary, String bonusCategoryCode, String headEmployeeBanknum,
			String headEmployeeContract, String cateDepartment, String cateBonus) {
		super();
		this.headEmployeeCode = headEmployeeCode;
		this.departmentCategoryCode = departmentCategoryCode;
		this.headEmployeeId = headEmployeeId;
		this.headEmployeeName = headEmployeeName;
		this.headEmployeeBirth = headEmployeeBirth;
		this.headEmployeePhone = headEmployeePhone;
		this.headEmployeeAddress = headEmployeeAddress;
		this.headEmployeeJoin = headEmployeeJoin;
		this.headEmployeeSalary = headEmployeeSalary;
		this.bonusCategoryCode = bonusCategoryCode;
		this.headEmployeeBanknum = headEmployeeBanknum;
		this.headEmployeeContract = headEmployeeContract;
		this.cateDepartment = cateDepartment;
		this.cateBonus = cateBonus;
	}
	public HeadEmployeeVO() {
		super();
	}
	
	
}