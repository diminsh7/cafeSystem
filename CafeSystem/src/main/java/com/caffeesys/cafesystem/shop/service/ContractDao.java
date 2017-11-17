package com.caffeesys.cafesystem.shop.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContractDao {
	
	private final String NS = "com.caffeesys.cafesystem.shop.service.ContractMapper.";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	// 계약서등록
	public int insertContract(Contract contract) {
		System.out.println("ContractDao.java / insertContract Param contract: "+contract);
		return sqlSessionTemplate.insert(NS+"insertContract", contract);
	}
	// contract_code의 최대값 갖고오기
	public int selectContractMax() {
		System.out.println("ContractDao.java / selectContractMax method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectContractMax");
	}
	// 전체게약서조회 상세전
	public List<Contract> selectContractList(){
		System.out.println("ContractDao.java / selectContractList method 확인");
		return sqlSessionTemplate.selectList(NS+"selectContractList");
	}
}
