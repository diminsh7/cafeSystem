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
	// contract_code의 최대값 갖고오기
	public int selectContractMax() {
		System.out.println("ContractDao.java / selectContractMax method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectContractMax");
	}
	// 전체계약서조회 상세전
	public List<Contract> selectContractList(){
		System.out.println("ContractDao.java / selectContractList method 확인");
		return sqlSessionTemplate.selectList(NS+"selectContractList");
	}
	/*// 전체계약서조회 상세전
	public List<Contract> selectContractList(int currentPage, int pagePerRow) {
	     Map<String, Integer> map = new HashMap<String, Integer>();
	     map.put("beginRow", (currentPage-1)*pagePerRow);
	     map.put("pagePerRow", pagePerRow);
	     return sqlSessionTemplate.selectList(NS+"selectContractList", map);
	}
	// 전체계약서조회 상세전2
	public int selectContractCount() {
		System.out.println("ContractDao.java / selectContractCount method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectContractCount");
	}*/
	// 계약서수정
	public int updateContract(Contract contract) {
		return sqlSessionTemplate.update(NS+"updateContract", contract);
	}
	// 계약서수정2
	public Contract selectContractUpdate(String contractCode) {
		return sqlSessionTemplate.selectOne(NS+"selectContractUpdate", contractCode);
	}
}
