package com.caffeesys.cafesystem.account.service;

import java.util.HashMap;
import java.util.List;

public interface SalesDaoInter {
	public List<DailySalesVO> selectDailySalesList();
	public List<MonthlySalesVO> selectMonthlySalesList();
	public List<HashMap<String, Object>> selectDailyTop();
	public List<HashMap<String, Object>> selectMonthlyTop();
	public List<FeeVO> selectFeeList();
}
