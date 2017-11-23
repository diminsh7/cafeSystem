package com.caffeesys.cafesystem.employee.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BranchPersonnelDao {
	private static final Logger logger = LoggerFactory.getLogger(BranchManagerDao.class);

	private final static String NS = "com.caffeesys.cafesystem.employee.service.BranchPersonnelMapper.";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// 입력폼에서 필요한 점주 매장코드
	public List<BranchPersonnelVO> selectBranchPersonnelShopcode() {
		logger.debug("[selectBranchPersonnelShopcode] 지점 매장번호 구하기 실행");
		return sqlSessionTemplate.selectList(NS + "selectBranchEmployeeShopCode");
	}

	// 점주 등록
	// 지점 인사관리 테이블등록
	public int insertBranchEmployee(BranchPersonnelVO branchPersonnelVO) {
		System.out.println("[BranchPersonnelDao.insertBranchEmployee] 직원,매니져 등록 / 지점인사테이블에 입력 ");
		return sqlSessionTemplate.insert(NS + "insertBranchEmployee", branchPersonnelVO);
	}

	// 지점 직원테이블 등록
	public int insertBranchPersonnel(BranchPersonnelVO branchPersonnelVO) {
		System.out.println("[BranchPersonnelDao.insertBranchPersonnel] 직원,매니져 등록 / 지점직원테이블에 입력 ");
		return sqlSessionTemplate.insert(NS + "insertBranchPersonnel", branchPersonnelVO);
	}

	// 직원코드 마지막 번호 구하기
	public int selectBranchEmployeeCodeMax() {
		System.out.println("[BranchPersonnelDao.selectBranchEmployeeCodeMax] 직원 마지막 코드 번호 구하기 실행");
		return sqlSessionTemplate.selectOne(NS + "selectBranchImployeeCodeMax");
	}
	
	// 직원리스트
	public List<BranchPersonnelVO> selectBranchPersonnelList(){
		System.out.println("[BranchPersonnelDao.selectBranchPersonnelList] 직원 리스트 출력 실행");
		return sqlSessionTemplate.selectList(NS + "selectBranchPersonnelList");
	}

}
