package com.caffeesys.cafesystem.item.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {
	
private final String NS = "com.caffeesys.cafesystem.item.service.ItemMapper.";
	
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
	// 발주품목등록
	public int insertItem(ItemVO item) {
		System.out.println("ItemDao.java / insertItem Param item: "+item);
		return sqlSessionTemplate.insert(NS+"insertItem", item);
	}
	// 발주품목등록의 item_code컬럼에서 글자말고, 숫자의 최대값 증가 select
	public int selectItemMax() {
		System.out.println("ItemDao.java / selectItemMax method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectItemMax");
	}
	// 발주품목등록 category에서 소분류 가져오는 select 
	public List<ItemVO> selectItemCategorySmall(){
		System.out.println("ItemDao.java / selectItemCategorySmall method 확인");
		return sqlSessionTemplate.selectList(NS + "selectItemCategorySmall");
	}
	// 발주품목수정 및 발주품목상세조회
	public ItemVO selectItem(String itemCode) {
		System.out.println("ItemDao.java / selectItem Param itemCode: "+itemCode);
		return sqlSessionTemplate.selectOne(NS+"selectItem", itemCode);
	}
	// 발주품목수정
	public int updateItem(ItemVO item) {
		System.out.println("ItemDao.java / updateItem Param item: "+item);
		return sqlSessionTemplate.update(NS+"updateItem", item);
	}
	// 발주품목삭제 품목명확인하고 삭제
	public int deleteItem(String itemCode, String itemName) {
		System.out.println("ItemDao.java / deleteItem Param itemCode: "+itemCode);
		System.out.println("ItemDao.java / deleteItem Param itemName: "+itemName);
		ItemVO item = new ItemVO();
		item.setItemCode(itemCode);
		item.setItemName(itemName);
		return sqlSessionTemplate.delete(NS+"deleteItem", item);
	}
	
	// 발주품목금지리스트 및 조회 상세전
	public List<ItemVO> selectItemListX(Map<String, String> map) {
		System.out.println("ItemDao.java / selectItemListX method 확인");
	    return sqlSessionTemplate.selectList(NS+"selectItemListX", map);
	}
	// 발주품목금지리스트 및 조회 상세전 행의수
	public int selectItemCountX(Map<String, String> map) {
		System.out.println("ItemDao.java / selectItemCountX method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectItemCountX", map);
	}
}
