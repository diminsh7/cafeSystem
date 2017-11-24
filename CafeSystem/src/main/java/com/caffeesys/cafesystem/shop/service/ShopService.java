package com.caffeesys.cafesystem.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
	
	@Autowired
	private ShopDao shopDao;
	
	// 계약서등록 과정
	public int insertShop(ShopVO shop) {
		System.out.println("ShopService.java/ insertShop method 확인");
		System.out.println("ShopService.java / insertShop Param shop :" + shop);
		int shopmaxnum = shopDao.selectShopMax(shop);
		System.out.println("ShopService.java/ insertShop의 리턴값 shopmaxnum :" + shopmaxnum);
		
		String result_shopCode = null;
		int result = 0;
		if(shopmaxnum != 0) {
			result = shopmaxnum;
			System.out.println("ShopService.java/ insertShop result1 :"+result);
			result = result + 1;
			System.out.println("ShopService.java/ insertShop result2 :"+result);
			result_shopCode = String.format("%03d", result); // 자리수 맞추기
			System.out.println("ShopService.java/ insertShop result3 :"+result_shopCode);
		} else {
			result_shopCode = "001";
		}
		shop.setShopCode(result_shopCode);
		System.out.println("ShopService.java/ shop:"+shop);
		return shopDao.insertShop(shop);
	}
}
