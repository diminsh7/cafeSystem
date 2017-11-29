package com.caffeesys.cafesystem.menu.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caffeesys.cafesystem.menu.service.MaterialVO;

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
		System.out.println("[MenuPriceDao.java / menuPriceList.method] Access");
		return sqlSessionTemplate.selectList(NS + "menuPriceList", map);
	}
	
	//메뉴 이름 가져오기
	public List<String> menuNameSelect(){
		return sqlSessionTemplate.selectList(NS + "menuNameSelect");
	}
	
	//메뉴 가격 입력 처리
	public int menuPriceInsert(MenuPriceVO menuPrice) {
		System.out.println("[MenuPriceDao.java / menuPriceInsert.method] Access");
		return sqlSessionTemplate.insert(NS + "menuPriceInsert", menuPrice);
	}
	
	//메뉴 코드 자동 등록
	public String menuCodeInsert(String menuName) {
		System.out.println("[MenuPriceDao.java / menuCodeInsert.method] Access");
		return sqlSessionTemplate.selectOne(NS + "menuCodeInsert", menuName);
	}
	
	//메뉴 원가 자동 등록
	public List<MaterialVO> materialInsert(Map<String, String> map) { //list로 리턴 넘겨야함....
		System.out.println("[MenuPriceDao.java / materialInsert.method] Access");
		return sqlSessionTemplate.selectList("com.caffeesys.cafesystem.menu.service.MaterialMapper.materialInsert", map);
	}
	
	//메뉴 가격 관리 삭제처리
	public void menuPriceDelete(int menuPriceCode) {
		System.out.println("[MenuPriceDao.java / menuPriceDelete.method] Access");
		sqlSessionTemplate.delete(NS + "menuPriceDelete", menuPriceCode);
	}
	
	//메뉴 가격 수정 폼 요청
	public MenuPriceVO menuPriceUpdateForm(int menuPriceCode){	
		return sqlSessionTemplate.selectOne(NS + "menuPriceUpdateForm", menuPriceCode);
	}
	
	//메뉴 가격 수정 처리
	public int menuPriceUpdate(MenuPriceVO menuPrice) {
		return sqlSessionTemplate.update(NS + "menuPriceUpdate", menuPrice);
	}
}
