package com.caffeesys.cafesystem.order.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BranchOrderDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	final String NS = "com.caffeesys.cafesystem.order.service.BranchOrderMapper.";
	
	//지점 발주 화면 요청 & 카테고리별 품목 요청
	public List<BranchOrderVO> branchOrderForm(Map<String, String> map) {
		//System.out.print("[BranchOrderDao.java / branchOrderForm.method] Access");
		return sqlSessionTemplate.selectList(NS + "branchOrderForm", map);
	}
	
	//지점 발주 처리
	public int branchOrderInsert(BranchOrderAddVO branchOrderAdd) {
		//System.out.println("branchOrderAdd: " + branchOrderAdd);
		return sqlSessionTemplate.insert(NS + "branchOrderAdd", branchOrderAdd);
	}
	
	//수량에 따른 가격 계산
	public int itemPriceCal(String itemCodeSelect) {
		return sqlSessionTemplate.selectOne(NS + "itemPriceCal", itemCodeSelect);
	}
	
	//발주 승인 전, 발주 바로 취소
	public int branchOrderCancel(Map<String, String> map) {
		return sqlSessionTemplate.update(NS + "branchOrderCancel", map);
	}
	
	////DB order_cancel에 취소요청한 전표번호 등록(전표번호,취소요청상태,취소신청일)/승인전 취소
	public int insertBranchOrderDirectCancel(Map<String, String> map) {
		System.out.println("insertBranchOrderCancel 실행");
		return sqlSessionTemplate.update(NS + "insertBranchOrderDirectCancel", map);
	}
	
	////DB order_cancel에 취소요청한 전표번호 등록(전표번호,취소요청상태,취소신청일)/승인후 취소
	public int insertBranchOrderCancel(Map<String, String> map) {
		System.out.println("insertBranchOrderCancel 실행");
		return sqlSessionTemplate.update(NS + "insertBranchOrderCancel", map);
	}
	
}
