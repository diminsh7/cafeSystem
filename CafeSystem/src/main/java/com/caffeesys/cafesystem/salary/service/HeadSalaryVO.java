package com.caffeesys.cafesystem.salary.service;

public class HeadSalaryVO {
	private String headSalaryCode;
	private String headEmployeeCode;
	private String headSalaryWorkmonth;
	private int headEmployeeSalary;
	private int headSalaryBonus;
	private int headSalaryHealth;
	private int headSalaryInsurance;
	private int headSalaryPersion;
	private int headSalaryPayments;
	private int headSalaryDeduction;
	private int headSalaryReceipts;
	private String headSalaryPaydate;
	private String headEmployeeName;
	private int headEmployeeBirth;
	private String categoryDepartment;
	
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
	public String getCategoryDepartment() {
		return categoryDepartment;
	}
	public void setCategoryDepartment(String categoryDepartment) {
		this.categoryDepartment = categoryDepartment;
	}
	public String getHeadSalaryCode() {
		return headSalaryCode;
	}
	public void setHeadSalaryCode(String headSalaryCode) {
		this.headSalaryCode = headSalaryCode;
	}
	public String getHeadEmployeeCode() {
		return headEmployeeCode;
	}
	public void setHeadEmployeeCode(String headEmployeeCode) {
		this.headEmployeeCode = headEmployeeCode;
	}
	public String getHeadSalaryWorkmonth() {
		return headSalaryWorkmonth;
	}
	public void setHeadSalaryWorkmonth(String headSalaryWorkmonth) {
		this.headSalaryWorkmonth = headSalaryWorkmonth;
	}
	public int getHeadEmployeeSalary() {
		return headEmployeeSalary;
	}
	public void setHeadEmployeeSalary(int headEmployeeSalary) {
		this.headEmployeeSalary = headEmployeeSalary;
	}
	public int getHeadSalaryBonus() {
		return headSalaryBonus;
	}
	public void setHeadSalaryBonus(int headSalaryBonus) {
		this.headSalaryBonus = headSalaryBonus;
	}
	public int getHeadSalaryHealth() {
		return headSalaryHealth;
	}
	public void setHeadSalaryHealth(int headSalaryHealth) {
		this.headSalaryHealth = headSalaryHealth;
	}
	public int getHeadSalaryInsurance() {
		return headSalaryInsurance;
	}
	public void setHeadSalaryInsurance(int headSalaryInsurance) {
		this.headSalaryInsurance = headSalaryInsurance;
	}
	public int getHeadSalaryPersion() {
		return headSalaryPersion;
	}
	public void setHeadSalaryPersion(int headSalaryPersion) {
		this.headSalaryPersion = headSalaryPersion;
	}
	public int getHeadSalaryPayments() {
		return headSalaryPayments;
	}
	public void setHeadSalaryPayments(int headSalaryPayments) {
		this.headSalaryPayments = headSalaryPayments;
	}
	public int getHeadSalaryDeduction() {
		return headSalaryDeduction;
	}
	public void setHeadSalaryDeduction(int headSalaryDeduction) {
		this.headSalaryDeduction = headSalaryDeduction;
	}
	public int getHeadSalaryReceipts() {
		return headSalaryReceipts;
	}
	public void setHeadSalaryReceipts(int headSalaryReceipts) {
		this.headSalaryReceipts = headSalaryReceipts;
	}
	public String getHeadSalaryPaydate() {
		return headSalaryPaydate;
	}
	public void setHeadSalaryPaydate(String headSalaryPaydate) {
		this.headSalaryPaydate = headSalaryPaydate;
	}
	@Override
	public String toString() {
		return "HeadSalaryVO [headSalaryCode=" + headSalaryCode + ", headEmployeeCode=" + headEmployeeCode
				+ ", headSalaryWorkmonth=" + headSalaryWorkmonth + ", headEmployeeSalary=" + headEmployeeSalary
				+ ", headSalaryBonus=" + headSalaryBonus + ", headSalaryHealth=" + headSalaryHealth
				+ ", headSalaryInsurance=" + headSalaryInsurance + ", headSalaryPersion=" + headSalaryPersion
				+ ", headSalaryPayments=" + headSalaryPayments + ", headSalaryDeduction=" + headSalaryDeduction
				+ ", headSalaryReceipts=" + headSalaryReceipts + ", headSalaryPaydate=" + headSalaryPaydate
				+ ", headEmployeeName=" + headEmployeeName + ", headEmployeeBirth=" + headEmployeeBirth
				+ ", categoryDepartment=" + categoryDepartment + "]";
	}
	
}
