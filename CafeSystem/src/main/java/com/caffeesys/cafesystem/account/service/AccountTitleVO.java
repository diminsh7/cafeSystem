package com.caffeesys.cafesystem.account.service;

public class AccountTitleVO {
	private String accountTitleCode;
	private String accountTitleName;
	private String accountTitleContent;
	
	public AccountTitleVO() {
		super();
		
	}
	
	public AccountTitleVO( String accountTitleCode, String accountTitleName, String accountTitleContent) {
		super();
		this.accountTitleCode = accountTitleCode;
		this.accountTitleName = accountTitleName;
		this.accountTitleContent = accountTitleContent;
	}
	
	public String getAccountTitleCode() {
		return accountTitleCode;
	}
	public void setAccountTitleCode(String accountTitleCode) {
		this.accountTitleCode = accountTitleCode;
	}
	public String getAccountTitleName() {
		return accountTitleName;
	}
	public void setAccountTitleName(String accountTitleName) {
		this.accountTitleName = accountTitleName;
	}
	public String getAccountTitleContent() {
		return accountTitleContent;
	}
	public void setAccountTitleContent(String accountTitleContent) {
		this.accountTitleContent = accountTitleContent;
	}
	
	@Override
	public String toString() {
		return "accountTitle [accountTitleCode=" + accountTitleCode + ", accountTitleName=" + accountTitleName
				+ ", accountTitleContent=" + accountTitleContent + "]";
	}
	
}
