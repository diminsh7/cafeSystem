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
	
	//메뉴 가격 리스트 및 검색 처리
	public List<MenuPriceVO> menuPriceList(Map<String, String> map){
		System.out.println("[MenuPriceDao.java / menuPriceList.method] Loading");
		return sqlSessionTemplate.selectList(NS + "menuPriceList", map);
	}
	//메뉴 가격 입력 처리
	public int menuPriceInsert(MenuPriceVO menuPrice) {
		System.out.println("[MenuPriceDao.java / menuPriceInsert.method] Loading");
		return sqlSessionTemplate.insert(NS + "menuPriceInsert", menuPrice);
	}
	//메뉴코드 자동입력
	public String menuCodeInsert(String menuName) {
		return sqlSessionTemplate.selectOne(NS + "menuCodeInsert", menuName);
	}
}
