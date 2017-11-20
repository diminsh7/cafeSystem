package com.caffeesys.cafesystem.claim.service;

import java.util.List;

public interface ClaimReplyDaoInter {
	public List<ClaimReply> selectClaimReply(Integer customerClaimCode) throws Exception;

	public void insertClaimReply(ClaimReply claimReply) throws Exception;

	public void updateClaimReply(ClaimReply claimReply) throws Exception;

	public void deleteClaimReply(Integer claimReplyCode) throws Exception;
}
