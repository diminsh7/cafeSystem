package com.caffeesys.cafesystem.salary.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HeadSalaryDao {
	private static final Logger logger = LoggerFactory.getLogger(HeadSalaryDao.class);
	
	private final String NS ="com.caffeesys.cafesystem.salary.service.HeadSalaryMapper.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
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

}
