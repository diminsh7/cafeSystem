package com.caffeesys.cafesystem.account.service;

import java.util.List;

public interface SalesServiceInter {
	public List<DailySalesVO> selectDailySalesList(DailySalesVO dailySales);
}
