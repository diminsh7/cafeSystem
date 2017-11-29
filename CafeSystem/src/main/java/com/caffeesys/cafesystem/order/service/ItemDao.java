package com.caffeesys.cafesystem.order.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {
	
private final String NS = "com.caffeesys.cafesystem.order.service.ItemMapper.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 발주품목리스트 및 조회 상세전
	public List<ItemVO> selectItemList(Map<String, String> map) {
		System.out.println("ItemDao.java / selectItemList method 확인");
	    return sqlSessionTemplate.selectList(NS+"selectItemList", map);
	}
	// 발주품목리스트 및 조회 상세전 행의수
	public int selectItemCount(Map<String, String> map) {
		System.out.println("ItemDao.java / selectItemCount method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectItemCount", map);
	}
}
