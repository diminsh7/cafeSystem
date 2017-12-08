package com.caffeesys.cafesystem.salary.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caffeesys.cafesystem.employee.service.BranchPersonnelVO;
import com.caffeesys.cafesystem.login.service.LoginVO;


@Repository
public class BranchSalaryDao {
	private static final Logger logger = LoggerFactory.getLogger(BranchSalaryDao.class);

	private final String NS = "com.caffeesys.cafesystem.salary.service.BranchSalaryMapper.";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
		
	//상세데이터 select //수정하기위해 select
	public BranchSalaryVO selectBranchSalaryDetail(String branchSalaryCode) {
		logger.debug("selectBranchSalaryDetail 메소드의 branchSalaryCode :{}",branchSalaryCode);
		logger.debug("selectBranchSalaryDetail 리턴 확인 :{}",sqlSessionTemplate.selectOne(NS +"selectBranchSalaryDetail", branchSalaryCode));
		return sqlSessionTemplate.selectOne(NS +"selectBranchSalaryDetail", branchSalaryCode);
	}
	
	//삭제처리
	public int branchSalaryDelete(String branchSalaryCode) {
		return sqlSessionTemplate.delete(NS +"branchSalaryDelete",branchSalaryCode);
	}
	
	//수정처리
	public int branchSalaryUpdate(BranchSalaryVO branchSalary) {
		logger.debug("branchSalaryUpdate 메소드의 branchSalary :{}",branchSalary);
		return sqlSessionTemplate.update(NS + "branchSalaryUpdate",branchSalary);
	}
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
	public int branchEmployeeSalaryInsert(String branchEmployeeCode){
		
		logger.debug("branchEmployeeSalaryInsert메소드 확인 branchSalaryInsert :{}",branchEmployeeCode);
		logger.debug("branchEmployeeSalaryInsert메소드 확인 branchEmployeeCode: {}",sqlSessionTemplate.selectOne(NS + "branchEmployeeSalaryInsert", branchEmployeeCode));
		return sqlSessionTemplate.selectOne(NS + "branchEmployeeSalaryInsert", branchEmployeeCode);
	}
	
	//급여명세서 등록 처리
	public int branchSalaryInsert(BranchSalaryVO branchSalary) {
		logger.debug("branchSalaryInsert 메소드확인");
		return sqlSessionTemplate.insert(NS + "branchSalaryInsert" , branchSalary);
	}
	
	//명세서코드등록할때 오른쪽 숫자 최대값 select
	public int branchSalaryCodeMax() {
		logger.debug("branchSalaryCodeMax 메소드 확인");
		logger.debug("branchSalaryCodeMax 메소드 확인 : {}",sqlSessionTemplate.selectOne(NS + "branchSalaryCodeMax"));
		return sqlSessionTemplate.selectOne(NS + "branchSalaryCodeMax");
	}
	
	//명세서코드등록할때 가운데 숫자 최대값 select
	public int branchSalaryCodeMidMax() {
		logger.debug("branchSalaryCodeMidMax 메소드 확인");
		logger.debug("branchSalaryCodeMax 메소드 확인 : {}",sqlSessionTemplate.selectOne(NS + "branchSalaryCodeMidMax"));
		return sqlSessionTemplate.selectOne(NS + "branchSalaryCodeMidMax");
	}
	
	//전표번호 등록할때의 날짜select
	public String statementDate() {
		logger.debug("statementDate메소드 확인");
		logger.debug("statementDate메소드 확인 :{}",sqlSessionTemplate.selectOne(NS + "statementDate"));
		return sqlSessionTemplate.selectOne(NS + "statementDate");
	}
	
	//전표번호 등록할때 local, shop코드selext
	public BranchPersonnelVO bEmployeeLocalShop(String bEmployeeCode) {
		logger.debug("bEmployeeLocalShop메소드 확인");
		logger.debug("bEmployeeLocalShop메소드 확인 :{}",sqlSessionTemplate.selectOne(NS +"bEmployeeLocalShop", bEmployeeCode));
		return sqlSessionTemplate.selectOne(NS +"bEmployeeLocalShop", bEmployeeCode);
	}
	
	//전표번호의 최대값select
	public HashMap<String, Object> getStatementMax(String statementNumber) {
		logger.debug("getStatementMax메소드 확인");
		logger.debug("getStatementMax메소드 리턴 :{}",sqlSessionTemplate.selectOne(NS+"getStatementMax", statementNumber));	//숫자 또는 null값이 리턴됨
		return sqlSessionTemplate.selectOne(NS+"getStatementMax", statementNumber);
	}
}
