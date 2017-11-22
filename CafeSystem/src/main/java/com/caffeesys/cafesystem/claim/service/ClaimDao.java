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

	@Override //클레임 게시글 입력처리
	public int insertClaim(ClaimVO claim) throws Exception {
		logger.debug("[ClaimDao.java/insertClaim Method] Loading");
		logger.debug("[ClaimDao.java/insertClaim Method] claim Param : " + claim);
		return sqlSessionTemplate.insert(NS + "insertClaim", claim);
	}

	@Override //클레임 리스트용 
	public List<ClaimVO> selectAllClaim() throws Exception {
		logger.debug("[ClaimDao.java/selectAllClaim Method] Loading");
		return sqlSessionTemplate.selectList(NS + "selectAllClaim");
	}

	@Override //클레임 상세보기, 업데이트폼
	public ClaimVO selectOneForDetail(int customerClaimCode) throws Exception {
		logger.debug("[ClaimDao.java/selectOneForDetail Method] Loading");
		return sqlSessionTemplate.selectOne(NS + "selectOneForDetail", customerClaimCode);
	}

	@Override //CategoryVo 셀렉트
	public List<Category> selectCategoryForClaim() throws Exception {
		logger.debug("[ClaimDao.java/selectCategoryForClaim Method] Loading");
		return sqlSessionTemplate.selectList(NS + "selectCategoryForClaim");
	}
	
	@Override
	public int updateClaim(ClaimVO claim) throws Exception	{
		logger.debug("[ClaimDao.java/updateClaim Method] Loading");
		logger.debug("[ClaimDao.java/updateClaim Method] claim Param : " + claim);
		return sqlSessionTemplate.update(NS + "updateClaim", claim);
	}

}
