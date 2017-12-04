package com.caffeesys.cafesystem.employee.service;

import java.util.List;

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
		/*return sqlSessionTemplate.selectList(NS + "selectDpartment");*/
		return null;
	}

	//입력 폼에 필요한 상여금
	public List<HeadEmployeeVO> selectBonus() {
		logger.debug("[selectBonus] 상여금코드, 상여금 구하기");
		/*return sqlSessionTemplate.selectList(NS + "selectBonus");*/
		return null;
	}
}
