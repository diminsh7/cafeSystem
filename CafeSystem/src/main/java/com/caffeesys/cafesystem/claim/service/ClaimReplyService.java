package com.caffeesys.cafesystem.claim.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaimReplyService implements ClaimReplyServiceInter {

	private static final Logger logger = LoggerFactory.getLogger(ClaimReplyService.class);
	
	@Autowired
	private ClaimReplyDao claimReplyDao;

	@Override
	public void insertClaimReply(ClaimReplyVO claimReply) throws Exception {
		logger.debug("[ClaimReplyService.java/insertClaimReply.method] Loading Complete");
		logger.debug("[ClaimReplyService.java/insertClaimReply.method] claimReply param : " + claimReply);
		claimReplyDao.insertClaimReply(claimReply);
	}

	@Override
	public List<ClaimReplyVO> selectClaimReply(Integer customerClaimCode) throws Exception {
		logger.debug("[ClaimReplyService.java/selectClaimReply.method] Loading Complete");
		logger.debug("[ClaimReplyService.java/selectClaimReply.method] customerClaimCode param : " + customerClaimCode);
		return claimReplyDao.selectClaimReply(customerClaimCode);
	}

	@Override
	public void updateClaimReply(ClaimReplyVO claimReply) throws Exception {
		logger.debug("[ClaimReplyService.java/updateClaimReply.method] Loading Complete");
		logger.debug("[ClaimReplyService.java/updateClaimReply.method] claimReply param : " + claimReply);
		claimReplyDao.updateClaimReply(claimReply);
	}

	@Override
	public void deleteClaimReply(Integer claimReplyCode) throws Exception {
		logger.debug("[ClaimReplyService.java/deleteClaimReply.method] Loading Complete");
		logger.debug("[ClaimReplyService.java/deleteClaimReply.method] claimReplyCode param : " + claimReplyCode);
		claimReplyDao.deleteClaimReply(claimReplyCode);
	}

}
