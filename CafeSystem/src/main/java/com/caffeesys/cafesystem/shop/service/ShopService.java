package com.caffeesys.cafesystem.shop.service;

import org.springframework.beans.factory.annotation.Autowired;

public class ShopService {
	
	@Autowired
	private ShopDao shopDao;
	
	// 계약서등록 과정
	public int insertShop(ShopVO shop) {
		System.out.println("ShopService.java/ insertShop method 확인");
		System.out.println("ShopService.java / insertShop Param shop :" + shop);
		int shopmaxnum = shopDao.selectShopMax();
		System.out.println("ShopService.java/ insertShop의 리턴값 shopmaxnum :" + shopmaxnum);		
		String shop_code_temp = "";
		String shopcode = "001";
		String result_no = null;
		int result = 0;
		if(shopmaxnum != 0) {
			result = shopmaxnum;
			System.out.println("ShopService.java/ insertShop result1 :"+result);
			result = result + 1;
			System.out.println("ShopService.java/ insertShop result2 :"+result);
			result_no = String.format("%03d", result); // 자리수 맞추기
			System.out.println("ShopService.java/ insertShop result3 :"+result_no);
		}
		shopcode = shop_code_temp+ result_no;
		System.out.println("shopcode : "+ shopcode);
		shop.setShopCode(shopcode);
		System.out.println("ShopService.java/ shop:"+shop);
		return shopDao.insertShop(shop);
	}
}
