package com.caffeesys.cafesystem.claim.service;

import java.util.List;
import com.caffeesys.cafesystem.Category;

public interface ClaimDaoInter {
	public int insertClaim(Claim claim) throws Exception;
	
	public List<Claim> selectAllClaim() throws Exception;
	
	public Claim selectOneForDetail(int customerClaimCode) throws Exception;
	
	public List<Category> Category() throws Exception;
}
