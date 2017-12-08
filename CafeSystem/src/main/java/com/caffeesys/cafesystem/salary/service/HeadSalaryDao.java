package com.caffeesys.cafesystem.salary.service;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caffeesys.cafesystem.employee.service.HeadEmployeeVO;

@Repository
public class HeadSalaryDao {
	private static final Logger logger = LoggerFactory.getLogger(HeadSalaryDao.class);
	
	private final String NS ="com.caffeesys.cafesystem.salary.service.HeadSalaryMapper.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//상세데이터 select //수정하기위해 select
	public HeadSalaryVO selectHeadSalaryDetail(String headSalaryCode) {
		logger.debug("selectHeadSalaryDetail 메소드의 headSalaryCode :{}",headSalaryCode);
		logger.debug("selectHeadSalaryDetail 리턴 확인 :{}",sqlSessionTemplate.selectOne(NS +"selectHeadSalaryDetail", headSalaryCode));
		return sqlSessionTemplate.selectOne(NS +"selectHeadSalaryDetail", headSalaryCode);
	}
			
	//삭제처리
	public int headSalaryDelete(String headSalaryCode) {
		return sqlSessionTemplate.delete(NS +"headSalaryDelete",headSalaryCode);
	}
	//수정처리
	public int headSalaryUpdate(HeadSalaryVO headSalary) {
		logger.debug("headSalaryUpdate 메소드의 headSalary :{}",headSalary);
		return sqlSessionTemplate.update(NS + "headSalaryUpdate",headSalary);
	}
	//검색된 레코드 개수
	public int headSalaryCount(Map<String, String> map) {
		logger.debug("headSalaryCount메소드 확인");
		logger.debug("headSalaryCount메소드의 리턴값 :{}",sqlSessionTemplate.selectOne(NS + "headSalaryCount", map));
		return sqlSessionTemplate.selectOne(NS + "headSalaryCount", map);
	}
	
	//검색된 리스트
	public List<HeadSalaryVO> headSalaryList(Map<String,String> map){
		logger.debug("headSalaryList메소드 확인");
		logger.debug("headSalaryList메소드의 리턴값 :{}",sqlSessionTemplate.selectList(NS + "headSalaryList",map));
		return sqlSessionTemplate.selectList(NS + "headSalaryList",map);
	}

	//본사 직원 급여명세서 등록 폼에 쓸 직원 코드 가져오는 메소드
	public List<HeadEmployeeVO> headCodeList(){
		logger.debug("headCodeList메소드 확인");
		logger.debug("headCodeList 리턷 확인:{}", sqlSessionTemplate.selectList(NS + "headCodeList"));
		return sqlSessionTemplate.selectList(NS + "headCodeList");
	}
	
	//지점직원 급여명세서 등록 폼에 쓸 직원 급여 가져오는 메소드 <직원코드를 눌렀을때 자동으로 입력>
	public String headEmployeeSalaryInsert(String headEmployeeCode){
		logger.debug("headEmployeeSalaryInsert메소드 확인 headSalaryInsert :{}",headEmployeeCode);
		logger.debug("headEmployeeSalaryInsert메소드 확인 headEmployeeCode: {}",sqlSessionTemplate.selectOne(NS + "headEmployeeSalaryInsert", headEmployeeCode));
		return sqlSessionTemplate.selectOne(NS + "headEmployeeSalaryInsert", headEmployeeCode);
	}
	
	//본사직원 보너스 코드의 상여 select
	public String headEmployeeBonusSelect(String headEmployeeCode) {
		logger.debug("headEmployeeBonusSelect 메소드의 headEmployeeCode :{}",headEmployeeCode);
		return sqlSessionTemplate.selectOne(NS + "headEmployeeBonusSelect",headEmployeeCode);
	}
	
	//명세서코드등록할때 오른쪽 숫자 최대값 select
	public int headSalaryCodeMax() {
		logger.debug("headSalaryCodeMax 메소드 확인");
		logger.debug("headSalaryCodeMax 메소드 확인 : {}",sqlSessionTemplate.selectOne(NS + "headSalaryCodeMax"));
		return sqlSessionTemplate.selectOne(NS + "headSalaryCodeMax");
	}
	//명세서코드등록할때 가운데 숫자 최대값 select
	public int headSalaryCodeMidMax() {
		logger.debug("headSalaryCodeMidMax 메소드 확인");
		logger.debug("headSalaryCodeMax 메소드 확인 : {}",sqlSessionTemplate.selectOne(NS + "headSalaryCodeMidMax"));
		return sqlSessionTemplate.selectOne(NS + "headSalaryCodeMidMax");
	}
	
	//급여명세서 등록 처리
	public int headSalaryInsert(HeadSalaryVO headSalary) {
		logger.debug("headSalaryInsert 메소드확인");
		return sqlSessionTemplate.insert(NS + "headSalaryInsert" , headSalary);
	}
}
