package com.caffeesys.cafesystem.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
	
	@Autowired
	private ShopDao shopDao;

	// 매장등록
	public int insertShop(ShopVO shop) {
		
	}
}
