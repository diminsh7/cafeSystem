package com.caffeesys.cafesystem.shop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDao {
	
	private final String NS = "com.caffeesys.cafesystem.shop.service.ShopMapper.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 매장리스트 및 조회 상세전
	public List<ShopVO> selectShopList(Map<String, String> map) {
		System.out.println("ShopDao.java / selectShopList method 확인");
	     return sqlSessionTemplate.selectList(NS+"selectShopList", map);
	}
	// 매장리스트 및 조회 상세전 행의수
	public int selectShopCount(Map<String, String> map) {
		System.out.println("ShopDao.java / selectShopCount method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectShopCount", map);
	}
	// 매장등록
	public int insertShop(ShopVO shop) {
		System.out.println("ShopDao.java / insertShop Param shop: "+shop);
		return sqlSessionTemplate.insert(NS+"insertShop", shop);
	}
	// 매장의 shop_code컬럼에서 글자말고, 숫자의 최대값 증가 select
	public int selectShopMax(ShopVO shop) {
		System.out.println("ShopDao.java / selectShopMax method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectShopMax", shop);
	}
	// 매장등록 contract에서 계약코드 가져오는 select 
	public List<ShopVO> selectShopContractCode(){
		System.out.println("ShopDao.java / selectShopContractCode method 확인");
		return sqlSessionTemplate.selectList(NS + "selectShopContractCode");
	}
	// 매장등록 category에서 소분류 가져오는 select 
	public List<ShopVO> selectShopCategorySmall(){
		System.out.println("ShopDao.java / selectShopCategorySmall method 확인");
		return sqlSessionTemplate.selectList(NS + "selectShopCategorySmall");
	}
	// 매장수정 및 매장상세조회
	public ShopVO selectShop(String contractCode) {
		System.out.println("ShopDao.java / selectShop Param contractCode: "+contractCode);
		return sqlSessionTemplate.selectOne(NS+"selectShop", contractCode);
	}
	// 매장수정
	public int updateShop(ShopVO shop) {
		System.out.println("ShopDao.java / updateShop Param shop: "+shop);
		return sqlSessionTemplate.update(NS+"updateShop", shop);
	}
	// 매장삭제 점포명확인하고 삭제
	public int deleteShop(String contractCode, String shopName) {
		System.out.println("ShopDao.java / deleteShop Param contractCode: "+contractCode);
		System.out.println("ShopDao.java / deleteShop Param shopName: "+shopName);
		ShopVO shop = new ShopVO();
		shop.setContractCode(contractCode);
		shop.setShopName(shopName);
		return sqlSessionTemplate.delete(NS+"deleteShop", shop);
	}

	// 매장연락망리스트 및 조회
	public List<ShopVO> selectBranchCallList(Map<String, String> map) {
		System.out.println("ShopDao.java / selectBranchCallList method 확인");
	     return sqlSessionTemplate.selectList(NS+"selectBranchCallList", map);
	}
	// 매장연락망리스트 및 조회 행의수
	public int selectBranchCallCount(Map<String, String> map) {
		System.out.println("ShopDao.java / selectBranchCallCount method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectBranchCallCount", map);
	}
}
