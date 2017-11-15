package com.caffeesys.cafesystem.shop.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContractDao {
	
	private final String NS = "com.caffeesys.cafesystem.shop.ContractMapper.";

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int insertContract(Contract contract) { // 등록
		return sqlSession.insert(NS + "insertContract", contract);
	}
	public int updateContract(Contract contract) { // 수정
		return sqlSession.update(NS + "updateContract", contract);
	}
	public List<Contract> listContract() { // 전체계약서조회
		return sqlSession.selectList(NS + "listContract");
	}
	/*
	public Contract detailContract(int contractCode) { // 하나조회 선택지점계약서상세조회
		return sqlSession.selectOne(NS + "detailContract");
	}
	public List<Contract> detailContract2(Contract contract) {
		return sqlSession.selectList(NS + "detailContract2", contract);
	}
	*/
}
