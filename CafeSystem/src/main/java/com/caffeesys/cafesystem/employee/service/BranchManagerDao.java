package com.caffeesys.cafesystem.employee.service;
  
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository  
public class BranchManagerDao { 

	private final String NS = "com.caffeesys.cafesystem.employee.service.BranchManagerMapper.";
 
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// 지점장입력
	public int insertBranchManager(BranchManager branchManager) {
		System.out.println("[BranchManagerDao.insertBranchManager] 지점장 입력 폼으로 이동 실행");
		return sqlSessionTemplate.insert(NS + "insertBranchImployeeB");
	}
	
	// 지점장코드 마지막 번호 구하기
	public int branchEmployeeCodeMax() {
		System.out.println("[BranchManagerDao.branchManagerCodeMax] 지점장 마지막 코드 번호 구하기 실행");
		return sqlSessionTemplate.selectOne(NS + "selectBranchImployeeCodeMax");
	}
	
	// 지역에 따른 shopcode 구하기
	public String branchEmployeeShopCodeMax(String localCategoryCode) {
		System.out.println("[BranchManagerDao.branchEmployeeShopCodeMax] 지역에따른 매장코드 구하기 실행");
		System.out.println("branchEmployeeShopCodeMax 메소드 "+sqlSessionTemplate.selectOne(NS + "selectBranchEmployeeShopCodeMax",localCategoryCode));
		return sqlSessionTemplate.selectOne(NS + "selectBranchEmployeeShopCodeMax",localCategoryCode);
		
	}
		
		
	//지점장 리스트
	public List<BranchManager> selectBranchManager() {
		System.out.println("[BranchManagerDao.selectBranchManager] 실행");
		return sqlSessionTemplate.selectList(NS + "selectBranchEmployeeManager");
	}

	

}
