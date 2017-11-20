package com.caffeesys.cafesystem.employee.service;
  
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository  
public class BranchManagerDao { 

	private final static String NS = "com.caffeesys.cafesystem.employee.service.BranchManagerMapper.";
 
	@Autowired
	private static SqlSessionTemplate sqlSessionTemplate;
	
	//입력폼에서 필요한 점주 매장코드 
	public static List<BranchManager> selectBranchManagerShopcode(){
		System.out.println("[BranchManagerDao.selectBranchManagerShopcode] 지점 매장번호 구하기 실행");
		System.out.println("[BranchManagerDao.selectBranchManagerShopcode] 쿼리문확인" + sqlSessionTemplate.selectList(NS + "selectBranchEmployeeShopCode"));
		return sqlSessionTemplate.selectList(NS+"selectBranchEmployeeShopCode");	
	}
	
	// 점주코드 마지막 번호 구하기
	public int selectBranchEmployeeCodeMax() {
		System.out.println("[BranchManagerDao.branchManagerCodeMax] 직원 마지막 코드 번호 구하기 실행");
		return sqlSessionTemplate.selectOne(NS + "selectBranchImployeeCodeMax");
	}
	
	// 점주 등록 (지점인사/지점점주 두개의 테이블에 들어감)
	public int insertBranchEmployeeAndManager(BranchManager branchManager) {
		System.out.println("[BranchManagerDao.insertBranchEmployeeAndManager] 점주등록 지점인사,지점점주 두개의 테이블에 입력 ");
		sqlSessionTemplate.insert(NS + "insertBranchEmployee",branchManager); //지점 인사관리 테이블
		sqlSessionTemplate.insert(NS + "insertBranchManager",branchManager); //지점 점주 테이블
		return 0;
	}
	
	//점주 리스트
	public List<BranchManager> selectBranchManagerList() {
		System.out.println("[BranchManagerDao.selectBranchManager] 실행");
		System.out.println("[BranchManagerDao.selectBranchManagerList] 쿼리문" + sqlSessionTemplate.selectList(NS + "selectBranchManagerList"));
		return sqlSessionTemplate.selectList(NS + "selectBranchManagerList");
	}

	

}
