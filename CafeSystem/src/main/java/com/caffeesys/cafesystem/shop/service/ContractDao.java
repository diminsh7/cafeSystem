package com.caffeesys.cafesystem.shop.service;

import java.util.HashMap;
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
	// 계약서등록
	public int insertContract(Contract contract) {
		System.out.println("ContractDao.java / insertContract Param contract: "+contract);
		return sqlSessionTemplate.insert(NS+"insertContract", contract);
	}
	// 계약서의 contract_code컬럼에서 글자말고, 숫자의 최대값 증가 select
	public int selectContractMax() {
		System.out.println("ContractDao.java / selectContractMax method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectContractMax");
	}
	// 전체계약서조회 상세전
	public List<Contract> selectContractList(int currentPage, int pagePerRow) {
	     Map<String, Integer> map = new HashMap<String, Integer>();
	     map.put("beginRow", (currentPage-1)*pagePerRow);
	     map.put("pagePerRow", pagePerRow);
	     return sqlSessionTemplate.selectList(NS+"selectContractList", map);
	}
	// 전체계약서조회 상세전에서 전체행의 수
	public int selectContractCount() {
		System.out.println("ContractDao.java / selectContractCount method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectContractCount");
	}
	// 계약서수정 및 계약서상세조회
	public Contract selectContract(String contractCode) {
		return sqlSessionTemplate.selectOne(NS+"selectContract", contractCode);
	}
	// 계약서수정
	public int updateContract(Contract contract) {
		return sqlSessionTemplate.update(NS+"updateContract", contract);
	}
	// 계약서삭제 소유자명확인하고 삭제
	public int deleteContract(String contractCode, String contractOwnerName) {
		Contract contract = new Contract();
		contract.setContractCode(contractCode);
		contract.setContractOwnerName(contractOwnerName);
		return sqlSessionTemplate.delete(NS+"deleteContract", contract);
	}
}
