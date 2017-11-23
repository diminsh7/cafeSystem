package com.caffeesys.cafesystem.shop.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.caffeesys.cafesystem.Category;
import com.caffeesys.cafesystem.shop.service.ShopDao;

public class ShopDao {
	
	private final String NS = "com.caffeesys.cafesystem.shop.service.ShopMapper.";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	// 매장등록처리
	public int insertShop(ShopVO shop) {
		
		return sqlSessionTemplate.insert(NS+"insertShop", shop);
	}
}
