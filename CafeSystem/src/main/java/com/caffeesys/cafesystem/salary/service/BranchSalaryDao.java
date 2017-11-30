package com.caffeesys.cafesystem.salary.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caffeesys.cafesystem.login.service.LoginVO;


@Repository
public class BranchSalaryDao {
	private static final Logger logger = LoggerFactory.getLogger(BranchSalaryDao.class);

	private final String NS = "com.caffeesys.cafesystem.salary.service.BranchSalaryMapper.";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//검색된 리스트
	public List<BranchSalaryVO> branchSalaryList(Map<String,String> map){
		logger.debug("branchSalaryList메소드 확인");
		logger.debug("branchSalaryList메소드의 리턴값 :{}",sqlSessionTemplate.selectList(NS+"branchSalaryList",map));
		return sqlSessionTemplate.selectList(NS + "branchSalaryList",map);
	}
	//검색된 레코드 개수
	public int branchSalaryCount(Map<String, String> map) {
		logger.debug("branchSalaryCount메소드 확인");
		logger.debug("branchSalaryCount메소드의 리턴값 :{}",sqlSessionTemplate.selectOne(NS + "branchSalaryCount", map));
		return sqlSessionTemplate.selectOne(NS + "branchSalaryCount", map);
	}

	//지점 직원 급여명세서 등록 폼에 쓸 직원 코드 가져오는 메소드
	public List<LoginVO> branchCodeList(String empCode){
		logger.debug("branchCodeList메소드 확인");
		logger.debug("branchCodeList 리턷 확인:{}", sqlSessionTemplate.selectList(NS + "branchCodeList", empCode));
		return sqlSessionTemplate.selectList(NS + "branchCodeList", empCode);
	}
	
	//지점직원 급여명세서 등록 폼에 쓸 직원 급여 가져오는 메소드 <직원코드를 눌렀을때 자동으로 입력>
	public String branchEmployeeSalaryInsert(String branchCodeList){
		logger.debug("branchEmployeeSalaryInsert메소드 확인 branchCodeList :{}",branchCodeList);
		logger.debug("branchEmployeeSalaryInsert메소드 확인 branchEmployeeSalaryInsert: {}",sqlSessionTemplate.selectOne(NS + "branchSalaryInsert", branchCodeList));
		return sqlSessionTemplate.selectOne(NS + "branchEmployeeSalaryInsert", branchCodeList);
	}
}
