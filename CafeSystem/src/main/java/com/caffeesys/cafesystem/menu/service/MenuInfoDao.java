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
	// 메뉴등록
	public int insertMenuInfo(MenuInfoVO MenuInfo) {
		System.out.println("MenuInfoDao.java / insertMenuInfo Param shop: "+MenuInfo);
		return sqlSessionTemplate.insert(NS+"insertMenuInfo", MenuInfo);
	}
	// 메뉴등록의 menu_code컬럼에서 글자말고, 숫자의 최대값 증가 select
	public int selectMenuInfoMax() {
		System.out.println("MenuInfoDao.java / selectMenuInfoMax method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectMenuInfoMax");
	}
	// 메뉴등록 category에서 소분류 가져오는 select 
	public List<MenuInfoVO> selectMenuInfoCategorySmall(){
		System.out.println("MenuInfoDao.java / selectMenuInfoCategorySmall method 확인");
		return sqlSessionTemplate.selectList(NS + "selectMenuInfoCategorySmall");
	}
	// 메뉴수정 및 메뉴상세조회
	public MenuInfoVO selectMenuInfo(String menuCode) {
		System.out.println("MenuInfoDao.java / selectMenuInfo Param menuCode: "+menuCode);
		return sqlSessionTemplate.selectOne(NS+"selectMenuInfo", menuCode);
	}
	// 메뉴수정
	public int updateMenuInfo(MenuInfoVO menuInfo) {
		System.out.println("MenuInfoDao.java / updateMenuInfo Param menuInfo: "+menuInfo);
		return sqlSessionTemplate.update(NS+"updateMenuInfo", menuInfo);
	}
	// 메뉴삭제 메뉴명확인하고 삭제
	public int deleteMenuInfo(String menuCode, String menuName) {
		System.out.println("MenuInfoDao.java / deleteMenuInfo Param menuCode: "+menuCode);
		System.out.println("MenuInfoDao.java / deleteMenuInfo Param menuName: "+menuName);
		MenuInfoVO menuInfo = new MenuInfoVO();
		menuInfo.setMenuCode(menuCode);
		menuInfo.setMenuName(menuName);
		return sqlSessionTemplate.delete(NS+"deleteMenuInfo", menuInfo);
	}
}
