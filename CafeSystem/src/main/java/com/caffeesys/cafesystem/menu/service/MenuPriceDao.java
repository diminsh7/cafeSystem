package com.caffeesys.cafesystem.menu.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MenuPriceDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private String NS = "com.caffeesys.cafesystem.menu.service.MenuPriceMapper.";
	
	//메뉴 가격 개수
	public int menuPriceCount(Map<String, String> map) {
		return sqlSessionTemplate.selectOne(NS + "menuPriceCount", map);
	}
	
	public List<MenuPriceVO> menuPriceList(Map<String, String> map){
		System.out.println("[MenuPriceDao.java / menuPriceList.method] Loading");
		return sqlSessionTemplate.selectList(NS + "menuPriceList", map);
	}
}
