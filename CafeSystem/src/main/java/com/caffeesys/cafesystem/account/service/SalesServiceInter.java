package com.caffeesys.cafesystem.account.service;

import java.util.Map;

public interface SalesServiceInter {
	public String selectDailySalesList();
	public String selectMonthlySalesList();
	public String selectDailyTop();
	public String selectMonthlyTop();
	public String selectDailySalesListByShop(Map<String, Object> param);
	public String selectMonthlySalesListByShop(Map<String, Object> param);
	public String selectDailyGraph(Map<String, Object> param);
	public String selectMonthlyGraph(Map<String, Object> param);
	public String selectDailyDateSearchByShop(Map<String, Object> param);
	public String selectMonthlyDateSearchByShop(Map<String, Object> param);
	public String selectFeeList();
	public String selectFeeListByShop(Map<String, Object> param);
}	
