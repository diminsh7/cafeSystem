package com.caffeesys.cafesystem.employee.service;
  
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository  
public class BranchManagerDao { 
	private static final Logger logger = LoggerFactory.getLogger(BranchManagerDao.class);

	private final static String NS = "com.caffeesys.cafesystem.employee.service.BranchManagerMapper.";
 
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	//입력폼에서 필요한 지역
		public List<BranchManagerVO> selectBranchPersonnelLocal() {
			logger.debug("[selectBranchPersonnelShopcode] 지점 지역 구하기 실행");
			return sqlSessionTemplate.selectList(NS + "selectBranchEmployeeLocal");
	}
	
	// 점주 등록 (지점인사/지점점주 두개의 테이블에 들어감)
	//지점 인사관리 테이블
	public int insertBranchEmployee(BranchManagerVO branchManagerVo) {
		System.out.println("[BranchManagerDao.insertBranchEmployeeAndManager] 점주등록 / 지점인사 테이블에 입력 ");
		return sqlSessionTemplate.insert(NS + "insertBranchEmployee",branchManagerVo);
	}
	//지점 점주관리 테이블
	public int insertBranchManager(BranchManagerVO branchManagerVo) {
		System.out.println("[BranchManagerDao.insertBranchEmployeeAndManager] 점주등록 / 지점점주 테이블에 입력 ");
		return sqlSessionTemplate.insert(NS + "insertBranchManager",branchManagerVo);
	}
	
	//점주 리스트
	public List<BranchManagerVO> selectBranchManagerList(int branchManagerCount, int pagePerRow) {
		System.out.println("[BranchManagerDao.selectBranchManager] 실행");
		 Map<String, Integer> map = new HashMap<String, Integer>();
	     map.put("beginRow", (branchManagerCount-1)*pagePerRow);
	     map.put("pagePerRow", pagePerRow);
		return sqlSessionTemplate.selectList(NS + "selectBranchManagerList",map);
	}
	
	//점주 상세조회
	public List<BranchManagerVO> selectBranchManagerDetail(String branchEmployeeCode){
		System.out.println("[BranchManagerDao.selectBranchManagerDetail] 실행");
		return sqlSessionTemplate.selectList(NS + "selectBranchManagerDetail",branchEmployeeCode);
	}
	
	//점주 삭제 (지점인사/지점점주 두개의 테이블에서 삭제)
	//지점인사테이블에서 삭제
	public int deleteBranchEmployee(String branchEmployeeCode) {
		System.out.println("[BranchManagerDao.branchEmployeeCode] 실행");
		return sqlSessionTemplate.delete(NS + "deleteBranchEmployee",branchEmployeeCode);
	}
	
	//지점점주관리테이블에서 삭제
	public int deleteBranchManager(String branchEmployeeCode) {
		System.out.println("[BranchManagerDao.deleteBranchManager] 실행");
		return sqlSessionTemplate.delete(NS + "deleteBranchManager",branchEmployeeCode);
	}
	
	//점주 수정폼에 들어갈 내용 조회
	public List<BranchManagerVO> updateSelectBranchManager(String branchEmployeeCode) {
		System.out.println("[BranchManagerDao.updateSelectBranchManager] 실행");
		return sqlSessionTemplate.selectList(NS + "selectUpdateBranchManger",branchEmployeeCode);
	}
	
	//점주 수정
	//지점인사테이블에서 수정 (1) DB-branch_employee
	public List<BranchManagerVO> updateBranchEmployee(BranchManagerVO branchManagerVo) {
		System.out.println("[BranchManagerDao.updateBranchEmployee] 실행");
		return  sqlSessionTemplate.selectList(NS + "updateBranchEmployee",branchManagerVo);
		
	}
	//지점인사테이블에서 수정 (2) DB-branch_manager
	public List<BranchManagerVO> updateBranchManager(BranchManagerVO branchManagerVo) {
		System.out.println("[BranchManagerDao.updateBranchManager] 실행");
		return  sqlSessionTemplate.selectList(NS + "updateBranchManger",branchManagerVo);
	}
	
	//지점장 갯수구하기
	public int selectBranchMangerCount() {
		System.out.println("[BranchManagerDao.selectBranchMangerCount] 지점장 전체 숫자 구하기");
		return sqlSessionTemplate.selectOne(NS + "selectBranchMangerCount");
	}
	
	//입력폼에서 필요한 점주 매장코드 
	public List<BranchManagerVO> selectBranchManagerShopcode(){
		logger.debug("[selectBranchManagerShopcode] 지점 매장번호 구하기 실행");
		return sqlSessionTemplate.selectList(NS + "selectBranchEmployeeShopCode");
	}
	
	// 점주코드 마지막 번호 구하기
	public int selectBranchEmployeeCodeMax() {
		System.out.println("[BranchManagerDao.branchManagerCodeMax] 직원 마지막 코드 번호 구하기 실행");
		return sqlSessionTemplate.selectOne(NS + "selectBranchImployeeCodeMax");
	}
	

	
	

}
