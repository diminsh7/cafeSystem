package com.caffeesys.cafesystem.account.service;

import java.util.Map;

public interface SalesServiceInter {
	public String selectDailySalesList();
	public String selectMonthlySalesList();
	public String selectDailyTop();
	public String selectMonthlyTop();
	public String selectFeeList();
	public String selectFeeListByShop(Map<String, Object> param);
}	
