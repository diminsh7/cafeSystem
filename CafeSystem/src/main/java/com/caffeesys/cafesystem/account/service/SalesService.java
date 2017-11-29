package com.caffeesys.cafesystem.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesService implements SalesServiceInter {
	@Autowired
	private SalesDao salesDao;
	
	@Override
	public List<DailySalesVO> selectDailySalesList(DailySalesVO dailySales) {
		List<DailySalesVO> list = salesDao.selectDailySalesList(dailySales);
		return list;
	}
}
