package com.caffeesys.cafesystem.shop.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContractDao {
	
	private final String NS = "com.caffeesys.cafesystem.shop.service.ContractMapper.";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 계약서리스트 및 조회 상세전
	public List<ContractVo> selectContractList(Map<String, String> map) {
		System.out.println("ContractDao.java / selectContractList method 확인");
	     return sqlSessionTemplate.selectList(NS+"selectContractList", map);
	}
	// 계약서리스트 및 조회 상세전 행의수
	public int selectContractCount(Map<String, String> map) {
		System.out.println("ContractDao.java / selectContractCount method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectContractCount", map);
	}
	// 계약서등록
	public int insertContract(ContractVo contract) {
		System.out.println("ContractDao.java / insertContract Param contract: "+contract);
		return sqlSessionTemplate.insert(NS+"insertContract", contract);
	}
	// 계약서의 contract_code컬럼에서 글자말고, 숫자의 최대값 증가 select
	public int selectContractMax() {
		System.out.println("ContractDao.java / selectContractMax method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectContractMax");
	}
	// 계약서수정 및 계약서상세조회
	public ContractVo selectContract(String contractCode) {
		System.out.println("ContractDao.java / selectContract Param contractCode: "+contractCode);
		return sqlSessionTemplate.selectOne(NS+"selectContract", contractCode);
	}
	// 계약서수정
	public int updateContract(ContractVo contract) {
		System.out.println("ContractDao.java / updateContract Param contract: "+contract);
		return sqlSessionTemplate.update(NS+"updateContract", contract);
	}
	// 계약서삭제 소유자명확인하고 삭제
	public int deleteContract(String contractCode, String contractOwnerName) {
		System.out.println("ContractDao.java / deleteContract Param contractCode: "+contractCode);
		System.out.println("ContractDao.java / deleteContract Param contractOwnerName: "+contractOwnerName);
		ContractVo contract = new ContractVo();
		contract.setContractCode(contractCode);
		contract.setContractOwnerName(contractOwnerName);
		return sqlSessionTemplate.delete(NS+"deleteContract", contract);
	}
	
	// 계약서상세조회(지점)
	public List<ContractVo> branchContractList(String branchEmployeeCode) {
		System.out.println("ContractDao.java / branchContractList Param branchEmployeeCode: "+branchEmployeeCode);
		return sqlSessionTemplate.selectList(NS+"branchContractList", branchEmployeeCode);
	}
}
