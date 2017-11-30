package com.caffeesys.cafesystem.salary.service;

public class BranchSalaryVO {
	private String branchSalaryCode;		//명세서 코드
	private String statementNumber;			//전표번호
	private String branchEmployeeCode;		//직원코드
	private String branchSalaryWorkmonth;	//귀속년월
	private int branchEmployeeSalary;		//월급
	private int branchSalaryHealth;			//건강보험
	private int branchSalaryInsurance;		//고용보험
	private int branchSalaryPersion;		//국민연금
	private int branchSalaryPayments;		//지급합계
	private int branchSalaryDeduction;		//공제합계
	private int branchSalaryReceipts;		//실 수령액
	private String branchSalaryPaydate;		//실 지급일자
	private String branchEmployeeName;		//지점직원 이름
	private int branchEmployeeBirth;		//지점직원 생년월일
	private String categoryPosition;		//부서
	public String getBranchSalaryCode() {
		return branchSalaryCode;
	}
	public void setBranchSalaryCode(String branchSalaryCode) {
		this.branchSalaryCode = branchSalaryCode;
	}
	public String getStatementNumber() {
		return statementNumber;
	}
	public void setStatementNumber(String statementNumber) {
		this.statementNumber = statementNumber;
	}
	public String getBranchEmployeeCode() {
		return branchEmployeeCode;
	}
	public void setBranchEmployeeCode(String branchEmployeeCode) {
		this.branchEmployeeCode = branchEmployeeCode;
	}
	public String getBranchSalaryWorkmonth() {
		return branchSalaryWorkmonth;
	}
	public void setBranchSalaryWorkmonth(String branchSalaryWorkmonth) {
		this.branchSalaryWorkmonth = branchSalaryWorkmonth;
	}
	public int getBranchEmployeeSalary() {
		return branchEmployeeSalary;
	}
	public void setBranchEmployeeSalary(int branchEmployeeSalary) {
		this.branchEmployeeSalary = branchEmployeeSalary;
	}
	public int getBranchSalaryHealth() {
		return branchSalaryHealth;
	}
	public void setBranchSalaryHealth(int branchSalaryHealth) {
		this.branchSalaryHealth = branchSalaryHealth;
	}
	public int getBranchSalaryInsurance() {
		return branchSalaryInsurance;
	}
	public void setBranchSalaryInsurance(int branchSalaryInsurance) {
		this.branchSalaryInsurance = branchSalaryInsurance;
	}
	public int getBranchSalaryPersion() {
		return branchSalaryPersion;
	}
	public void setBranchSalaryPersion(int branchSalaryPersion) {
		this.branchSalaryPersion = branchSalaryPersion;
	}
	public int getBranchSalaryPayments() {
		return branchSalaryPayments;
	}
	public void setBranchSalaryPayments(int branchSalaryPayments) {
		this.branchSalaryPayments = branchSalaryPayments;
	}
	public int getBranchSalaryDeduction() {
		return branchSalaryDeduction;
	}
	public void setBranchSalaryDeduction(int branchSalaryDeduction) {
		this.branchSalaryDeduction = branchSalaryDeduction;
	}
	public int getBranchSalaryReceipts() {
		return branchSalaryReceipts;
	}
	public void setBranchSalaryReceipts(int branchSalaryReceipts) {
		this.branchSalaryReceipts = branchSalaryReceipts;
	}
	public String getBranchSalaryPaydate() {
		return branchSalaryPaydate;
	}
	public void setBranchSalaryPaydate(String branchSalaryPaydate) {
		this.branchSalaryPaydate = branchSalaryPaydate;
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
	public String getCategoryPosition() {
		return categoryPosition;
	}
	public void setCategoryPosition(String categoryPosition) {
		this.categoryPosition = categoryPosition;
	}
	@Override
	public String toString() {
		return "BranchSalaryVO [branchSalaryCode=" + branchSalaryCode + ", statementNumber=" + statementNumber
				+ ", branchEmployeeCode=" + branchEmployeeCode + ", branchSalaryWorkmonth=" + branchSalaryWorkmonth
				+ ", branchEmployeeSalary=" + branchEmployeeSalary + ", branchSalaryHealth=" + branchSalaryHealth
				+ ", branchSalaryInsurance=" + branchSalaryInsurance + ", branchSalaryPersion=" + branchSalaryPersion
				+ ", branchSalaryPayments=" + branchSalaryPayments + ", branchSalaryDeduction=" + branchSalaryDeduction
				+ ", branchSalaryReceipts=" + branchSalaryReceipts + ", branchSalaryPaydate=" + branchSalaryPaydate
				+ ", branchEmployeeName=" + branchEmployeeName + ", branchEmployeeBirth=" + branchEmployeeBirth
				+ ", categoryPosition=" + categoryPosition + "]";
	}
	
	
	
}
