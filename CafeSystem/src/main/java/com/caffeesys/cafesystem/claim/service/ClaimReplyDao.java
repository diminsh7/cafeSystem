package com.caffeesys.cafesystem.claim.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClaimReplyDao implements ClaimReplyDaoInter {
	
	private static final Logger logger = LoggerFactory.getLogger(ClaimReplyDao.class);
	private final String NS = "com.caffeesys.cafesystem.claim.service.ClaimReplyMapper.";
	
	@Autowired
	private ClaimDao claimDao;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertClaimReply(ClaimVO claim) throws Exception {	
		logger.debug("[ClaimReplyDao.java/insertClaimReply Method] Loading");
		int claimCount = claimDao.getClaimCount();
		int claimCode = claimCount + 1;
		claim.setClaimCode(claimCode);
		int claimReLev = claim.getClaimReLev();		
		int claimReSeq = claim.getClaimReSeq();
		claimReSeq += 1;
		claimReLev += 1;
		claim.setClaimReSeq(claimReSeq);
		claim.setClaimReLev(claimReLev);	
		return sqlSessionTemplate.insert(NS + "claimReplyInsert", claim);
	}

}
