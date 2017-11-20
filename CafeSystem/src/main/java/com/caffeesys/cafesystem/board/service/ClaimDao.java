package com.caffeesys.cafesystem.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClaimDao { 
	private final String NS = "com.caffeesys.cafesystem.board.service.ClaimMapper.";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	//전체 리스트 셀렉트
	public List<Claim> selectAllClaim(){
		return sqlSessionTemplate.selectList(NS + "selectAllClaim");
	}
	//클레임 게시글 등록
	public int insertClaim(Claim claim) {
		return sqlSessionTemplate.insert(NS + "insertClaim", claim);
	}
}
