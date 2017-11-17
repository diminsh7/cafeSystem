package com.caffeesys.cafesystem.claim.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ClaimReplyDao implements ClaimReplyInter {
	
	private static final Logger logger = LoggerFactory.getLogger(ClaimReplyDao.class);
	
	@Inject
	private SqlSession sqlSession;
	
	private final String NS = "com.caffeesys.cafesystem.claim.service.ClaimReplyMapper.";
	
	@Override
	public List<ClaimReply> selectClaimReply(Integer customerClaimCode) throws Exception {
		logger.debug("[ClaimReplyDao.java/selectClaimReply.method] Loading Complete");
		logger.debug("[ClaimReplyDao.java/selectClaimReply.method] customerClaimCode param : " + customerClaimCode);
		return sqlSession.selectList(NS + "selectClaimReply", customerClaimCode);
	}

	@Override
	public void insertClaimReply(ClaimReply claimReply) throws Exception {
		logger.debug("[ClaimReplyDao.java/insertClaimReply.method] Loading Complete");
		logger.debug("[ClaimReplyDao.java/insertClaimReply.method] claimReply param : " + claimReply);
		sqlSession.insert(NS + "insertClaimReply", claimReply);
	}

	@Override
	public void updateClaimReply(ClaimReply claimReply) throws Exception {
		logger.debug("[ClaimReplyDao.java/updateClaimReply.method] Loading Complete");
		logger.debug("[ClaimReplyDao.java/updateClaimReply.method] claimReply param : " + claimReply);
		sqlSession.update(NS + "updateClaimReply", claimReply);
	}

	@Override
	public void deleteClaimReply(Integer claimReplyCode) throws Exception {
		logger.debug("[ClaimReplyDao.java/deleteClaimReply.method] Loading Complete");
		logger.debug("[ClaimReplyDao.java/deleteClaimReply.method] claimReplyCode param : " + claimReplyCode);
		sqlSession.delete(NS + "deleteClaimReply", claimReplyCode);
	}

}
