package com.caffeesys.cafesystem.employee.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HeadEmployeeDao {
	private static final Logger logger = LoggerFactory.getLogger(HeadEmployeeDao.class);

	private final static String NS = "com.caffeesys.cafesystem.employee.service.HeadEmployeeMapper.";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	//입력 폼에 필요한 직원 부서 
	public List<HeadEmployeeVO> selectDpartment() {
		logger.debug("[selectdepartment] 부서코드 부서명 구하기");
		return sqlSessionTemplate.selectList(NS + "selectDpartment");
		
	}
	//입력 폼에 필요한 상여금
	public List<HeadEmployeeVO> selectBonus() {
		logger.debug("[selectBonus] 상여금코드, 상여금 구하기");
		return sqlSessionTemplate.selectList(NS + "selectBonus");
	}
	
	//본사직원 마지막 코드 구하기
	public int selectheadEmployeeCodeMax() {
		logger.debug("[selectheadEmployeeCodeMax] 본사직원 마지막코드 구하기");
		return sqlSessionTemplate.selectOne(NS + "selectHeadEmployeeCodeMax");
	}
	
	//본사직원 등록실행
	public int insertHeadEmployee(HeadEmployeeVO headEmployeeVo) {
		logger.debug("[insertHeadEmployee] 본사직원 등록 실행");
		return sqlSessionTemplate.insert(NS + "insertHeadEmployee",headEmployeeVo);		
	}
	
	//본사직원 인원 구하기
	public int selectHeadEmployeeCount() {
		logger.debug("[selectHeadEmployeeCount] 본사직원 인원구하기");
		return sqlSessionTemplate.selectOne(NS + "selectHeadEmployeeCount");
	}
	
	//본사직원 리스트
	public List<HeadEmployeeVO> selectHeadEmployeeList(Map<String, String> map) {
		logger.debug("[selectHeadEmployeeList] 본사직원리스트");
		return sqlSessionTemplate.selectList(NS + "selectHeadEmployeeList",map);
	}
	
	//본사직원 상세 조회
	public HeadEmployeeVO selectHeadEmployeeDetail(String headEmployeeCode) {
		logger.debug("[selectHeadEmployeeDetail] 본사직원 상세 조회");
		return sqlSessionTemplate.selectOne(NS + "selectHeadEmployeeDetail",headEmployeeCode);
	}
	
	//본사직원 삭제 
	public int deleteHeadEmployee(String headEmployeeCode) {
		logger.debug("[deleteHeadEmployee] 본사직원 삭제");
		return sqlSessionTemplate.delete(NS + "deleteHeadEmployee",headEmployeeCode);
	}
	
	//수정 폼에 들어갈 내용 조회
	public HeadEmployeeVO updateHeadEmployee(String headEmployeeCode) {
		logger.debug("[updateHeadEmployee] 수정폼 이동");
		return sqlSessionTemplate.selectOne(NS + "selectUupdateHeadEmployee",headEmployeeCode);
	}
	
	//수정실행
	public  List<BranchManagerVO> updateHeadEmployee(HeadEmployeeVO headEmployeeVo) {
		logger.debug("[updateHeadEmployee] 수정실행");
		return sqlSessionTemplate.selectList(NS + "updateHeadEmployee",headEmployeeVo);
		
	}
	
}