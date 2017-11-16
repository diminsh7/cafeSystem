package com.caffeesys.cafesystem.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClaimDao {
	private final String NS = "com.caffeesys.cafesystem.board.service.ClaimMapper.";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int insertClaim(Claim claim) {
		return sqlSessionTemplate.insert(NS + "insertClaim", claim);
	}
}
