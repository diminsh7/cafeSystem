package com.caffeesys.cafesystem.claim.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caffeesys.cafesystem.Category;


@Repository
public class ClaimDao implements ClaimDaoInter {

	private static final Logger logger = LoggerFactory.getLogger(ClaimDao.class);
	private final String NS = "com.caffeesys.cafesystem.claim.service.ClaimMapper.";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertClaim(Claim claim) throws Exception {
		logger.debug("[ClaimDao.java/insertClaim Method] Loading");
		logger.debug("[ClaimDao.java/insertClaim Method] claim Param : " + claim);
		return sqlSessionTemplate.insert(NS + "insertClaim", claim);
	}

	@Override
	public List<Claim> selectAllClaim() throws Exception {
		logger.debug("[ClaimDao.java/selectAllClaim Method] Loading");
		return sqlSessionTemplate.selectList(NS + "selectAllClaim");
	}

	@Override
	public Claim selectOneForDetail(int customerClaimCode) throws Exception {
		logger.debug("[ClaimDao.java/selectOneForDetail Method] Loading");
		return sqlSessionTemplate.selectOne(NS + "selectOneForDetail", customerClaimCode);
	}

	@Override
	public List<Category> selectCategoryForClaim() throws Exception {
		logger.debug("[ClaimDao.java/selectCategoryForClaim Method] Loading");
		return sqlSessionTemplate.selectList(NS + "selectCategoryForClaim");
	}

}
