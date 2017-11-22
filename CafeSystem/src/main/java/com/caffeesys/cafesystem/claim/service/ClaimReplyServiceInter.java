package com.caffeesys.cafesystem.claim.service;

import java.util.List;

public interface ClaimReplyServiceInter {
	public void insertClaimReply(ClaimReplyVO claimReply) throws Exception;

	public List<ClaimReplyVO> selectClaimReply(Integer customerClaimCode) throws Exception;

	public void updateClaimReply(ClaimReplyVO claimReply) throws Exception;

	public void deleteClaimReply(Integer claimReplyCode) throws Exception;
}
