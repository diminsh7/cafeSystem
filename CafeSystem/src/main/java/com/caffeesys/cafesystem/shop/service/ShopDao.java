package com.caffeesys.cafesystem.shop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopDao {
	
	private final String NS = "com.caffeesys.cafesystem.shop.service.ShopMapper.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 매장조회 상세전
	public List<ShopVO> selectShopList(int currentPage, int pagePerRow) {
		System.out.println("ShopDao.java / selectShopList method 확인");
	     Map<String, Integer> map = new HashMap<String, Integer>();
	     map.put("beginRow", (currentPage-1)*pagePerRow);
	     map.put("pagePerRow", pagePerRow);
	     return sqlSessionTemplate.selectList(NS+"selectShopList", map);
	}
	// 매장조회 상세전에서 전체행의 수
	public int selectShopCount() {
		System.out.println("ShopDao.java / selectShopCount method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectShopCount");
	}
	// 매장등록
	public int insertShop(ShopVO shop) {
		System.out.println("ShopDao.java / insertShop Param shop: "+shop);
		return sqlSessionTemplate.insert(NS+"insertShop", shop);
	}
	// 매장의 shop_code컬럼에서 글자말고, 숫자의 최대값 증가 select
	public int selectShopMax() {
		System.out.println("ShopDao.java / selectShopMax method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectShopMax");
	}
}
