package com.caffeesys.cafesystem.claim.service;

import java.util.List;
import com.caffeesys.cafesystem.Category;

public interface ClaimDaoInter {
	public int insertClaim(ClaimVO claim) throws Exception;
	
	public List<ClaimVO> getClaimList(int currentPage, int pagePerRow) throws Exception;
	
	public ClaimVO selectOneForDetail(int claimCode) throws Exception;
	
	public List<ClaimVO> claimSearch(String claimSearchOption, String claimSearchWord) throws Exception;
	
	public List<Category> selectCategoryForClaim() throws Exception;
	
	public int updateClaim(ClaimVO claim) throws Exception;
	
	public int getClaimCount() throws Exception;
	
	public int deleteClaim(int claimCode) throws Exception;
}
