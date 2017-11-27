package com.caffeesys.cafesystem.menu.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MenuInfoDao {
	
	private final String NS = "com.caffeesys.cafesystem.menu.service.MenuInfoMapper.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 메뉴리스트 및 조회 상세전
	public List<MenuInfoVO> selectMenuInfoList(Map<String, String> map) {
		System.out.println("MenuInfoDao.java / selectMenuInfoList method 확인");
	    return sqlSessionTemplate.selectList(NS+"selectMenuInfoList", map);
	}
	// 메뉴리스트 및 조회 상세전 행의수
	public int selectMenuInfoCount(Map<String, String> map) {
		System.out.println("MenuInfoDao.java / selectMenuInfoCount method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectMenuInfoCount", map);
	}
}
