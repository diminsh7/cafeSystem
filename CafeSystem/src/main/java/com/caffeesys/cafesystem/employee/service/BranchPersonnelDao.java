package com.caffeesys.cafesystem.employee.service;

import java.util.List;
import java.util.Map;

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
	//입력폼에서 필요하 지역
	public List<BranchPersonnelVO> selectBranchPersonnelLocal() {
		logger.debug("[selectBranchPersonnelShopcode] 지점 지역 구하기 실행");
		return sqlSessionTemplate.selectList(NS + "selectBranchEmployeeLocal");
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
	
	// 직원 명수 구하기
	public int selectBranchPersonnelCount() {
		System.out.println("[BranchPersonnelDao.selectBranchPersonnelCount] 직원 전체 숫자 구하기");
		return sqlSessionTemplate.selectOne(NS + "selectBranchPersonnelCount");
	}
	
	//직원상세조회 
	public List<BranchPersonnelVO> selectBranchPersonnelDetail(String branchEmployeeCode){
		System.out.println("[BranchPersonnelDao.selectBranchPersonnelDetail] 직원 리스트 출력 실행");
		return sqlSessionTemplate.selectList(NS + "selectBranchPersonnelDetail",branchEmployeeCode);
	}
	
	//직원 수정 폼
	public List<BranchPersonnelVO> selectUpdateBranchPersonnel(String branchEmployeeCode){
		System.out.println("[BranchPersonnelDao.selectUpdateBranchPersonnel] 실행");
		return sqlSessionTemplate.selectList(NS + "selectUpdateBranchPersonnel",branchEmployeeCode);
	}
	
	//직원 수정 처리
	//지점인사테이블에서 수정(1) DB-branch_employee
	public List<BranchPersonnelVO> updateBranchEmployee(BranchPersonnelVO branchPersonnelVo) {
		System.out.println("[BranchManagerDao.updateBranchEmployee] 실행");
		return  sqlSessionTemplate.selectList(NS + "updateBranchEmployee",branchPersonnelVo);
	}
	//지점인사테이블에서 수정(2) DB-branch_personnel
	public List<BranchPersonnelVO> updateBranchPersonnel(BranchPersonnelVO branchPersonnelVo) {
		System.out.println("[BranchManagerDao.updateBranchPersonnel] 실행");
		return  sqlSessionTemplate.selectList(NS + "updateBranchPersonnel",branchPersonnelVo);
	}
	
	//직원 삭제 처리
	//지점인사테이블에서 삭제(1) DB-branch_employee
	public int deleteBranchEmployee(String branchEmployeeCode) {
		System.out.println("[BranchManagerDao.deleteBranchEmployee] 실행");
		return  sqlSessionTemplate.delete(NS + "deleteBranchEmployee",branchEmployeeCode);	
	}
	//지짐직원테이블에서의 삭제(2) DB-branch_personnel
	public int deleteBranchPersonnel(String branchEmployeeCode) {
		System.out.println("[BranchManagerDao.deleteBranchPersonnel] 실행");
		return  sqlSessionTemplate.delete(NS + "deleteBranchPersonnel",branchEmployeeCode);	
	}
	
	//지점직원검색
	public List<BranchPersonnelVO> selectBranchPersonnelSearch(Map<String, String> map){
		System.out.println("[BranchManagerDao.selectBranchPersonnelSearch] 실행");
		return sqlSessionTemplate.selectList(NS + "selectPersonnelAllList",map);
	}
	
	//검색된 행의 갯수, 컬럼말고 row 
	public int selectBranchPessonnelrow(Map<String, String> map) {
		System.out.println("[BranchManagerDao.selectBranchPessonnelrow] 실행");
		return sqlSessionTemplate.selectOne(NS + "selectBranchPersonnelRowCount",map);
	}
	
}