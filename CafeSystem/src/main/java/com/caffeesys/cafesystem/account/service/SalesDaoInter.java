package com.caffeesys.cafesystem.account.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SalesDaoInter {
	public List<DailySalesVO> selectDailySalesList();
	public List<MonthlySalesVO> selectMonthlySalesList();
	public List<HashMap<String, Object>> selectDailyTop();
	public List<HashMap<String, Object>> selectMonthlyTop();
	public List<DailySalesVO> selectDailySalesListByShop(Map<String, Object> param);
	public List<MonthlySalesVO> selectMonthlySalesListByShop(Map<String, Object> param);
	public List<HashMap<String, Object>> selectMonthlyGraph(Map<String, Object> param);
	public List<FeeVO> selectFeeList();
	public List<FeeVO> selectFeeListByShop(Map<String, Object> param);
}
