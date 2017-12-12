package com.caffeesys.cafesystem.item.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FaultyDao {

	private final String NS = "com.caffeesys.cafesystem.item.service.FaultyMapper.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 불량품목리스트 및 조회 상세전(본사)
	public List<FaultyVO> selectFaultyList(Map<String, String> map) {
		System.out.println("FaultyDao.java / selectFaultyList method 확인");
	    return sqlSessionTemplate.selectList(NS+"selectFaultyList", map);
	}
	// 불량품목리스트 및 조회 상세전 행의수(본사)
	public int selectFaultyCount(Map<String, String> map) {
		System.out.println("FaultyDao.java / selectFaultyCount method 확인");
		return sqlSessionTemplate.selectOne(NS+"selectFaultyCount", map);
	}
	
	// 불량품목등록(지점)
	public int insertFaulty(FaultyVO faulty) {
		System.out.println("FaultyDao.java / insertFaulty Param faulty: "+faulty);
		return sqlSessionTemplate.insert(NS+"insertFaulty", faulty);
	}
	// 불량품목등록 전표번호 가져오는 select(지점)
	public FaultyVO selectFaultyStatementNumber(int orderCode) {
		System.out.println("FaultyDao.java / selectFaultyStatementNumber Param orderCode: "+orderCode);
		return sqlSessionTemplate.selectOne(NS+"selectFaultyStatementNumber", orderCode);
	}
	// 불량품목등록 item코드 가져오는 select(지점)
	public FaultyVO selectFaultyItemCode(int orderCode){
		System.out.println("FaultyDao.java / selectFaultyItemCode Param orderCode: "+orderCode);
		return sqlSessionTemplate.selectOne(NS + "selectFaultyItemCode", orderCode);
	}
	// 불량품목등록 category에서 소분류 가져오는 select(지점)
	public List<FaultyVO> selectFaultyCategorySmall(){
		System.out.println("FaultyDao.java / selectFaultyCategorySmall method 확인");
		return sqlSessionTemplate.selectList(NS + "selectFaultyCategorySmall");
	}
	// 불량품목수정(지점) 및 발주품목상세조회(본사)
	public FaultyVO selectFaulty(int faultyCode) {
		System.out.println("FaultyDao.java / selectFaulty Param faultyCode: "+faultyCode);
		return sqlSessionTemplate.selectOne(NS+"selectFaulty", faultyCode);
	}
	// 불량품목수정(지점)
	public int updateFaulty(FaultyVO faulty) {
		System.out.println("FaultyDao.java / updateFaulty Param faulty: "+faulty);
		return sqlSessionTemplate.update(NS+"updateFaulty", faulty);
	}
	// 불량품목삭제 불량수량확인하고 삭제(지점)
	public int deleteFaulty(int faultyCode, int faultyAmount) {
		System.out.println("FaultyDao.java / deleteFaulty Param faultyCode: "+faultyCode);
		System.out.println("FaultyDao.java / deleteFaulty Param faultyAmount: "+faultyAmount);
		FaultyVO faulty = new FaultyVO();
		faulty.setFaultyCode(faultyCode);
		faulty.setFaultyAmount(faultyAmount);
		return sqlSessionTemplate.delete(NS+"deleteFaulty", faulty);
	}
	
	// 불량품목상세조회(지점)
	public List<FaultyVO> branchFaultyList(String branchEmployeeCode) {
		System.out.println("FaultyDao.java / branchFaultyList Param branchEmployeeCode: "+branchEmployeeCode);
		return sqlSessionTemplate.selectList(NS+"branchFaultyList", branchEmployeeCode);
	}
}
