package com.caffeesys.cafesystem.claim.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override // 클레임 게시글 입력처리
	public int insertClaim(ClaimVO claim) throws Exception {
		logger.debug("[ClaimDao.java/insertClaim Method] Loading");
		logger.debug("[ClaimDao.java/insertClaim Method] claim Param : " + claim);
		int claimCount = getClaimCount();
		int claimCode = claimCount + 1;
		claim.setClaimCode(claimCode);
		return sqlSessionTemplate.insert(NS + "insertClaim", claim);
	}

	@Override // 클레임 리스트+페이징 불러오기
	public List<ClaimVO> getClaimList(int currentPage, int pagePerRow) throws Exception {
		logger.debug("[ClaimDao.java/getClaimList Method] Loading");
		Map<String, Integer> claimMap = new HashMap<String, Integer>();
		claimMap.put("beginRow", (currentPage - 1) * pagePerRow);
		claimMap.put("pagePerRow", pagePerRow);		
		return sqlSessionTemplate.selectList(NS + "getClaimList", claimMap);
	}

	@Override // 클레임 검색 처리
	public List<ClaimVO> claimSearch(String claimSearchOption, String claimSearchWord) throws Exception {
		logger.debug("[ClaimDao.java/claimSearch Method] Loading");
		Map<String, String> claimSearhMap = new HashMap<String, String>();
		if(claimSearchOption.equals("claimCategoryCode")) {
			claimSearchOption = "claim_category_code";
		} else if(claimSearchOption.equals("claimTitle")) {
			claimSearchOption = "claim_title";
		} else if(claimSearchOption.equals("claimContents")) {
			claimSearchOption = "claim_contents";
		} else if(claimSearchOption.equals("claimDate")) {
			claimSearchOption = "claim_date";
		}
		
		claimSearhMap.put("claimSearchOption", claimSearchOption);
		claimSearhMap.put("claimSearchWord", claimSearchWord);
		System.out.println("--------------------------" + claimSearhMap);
		return sqlSessionTemplate.selectList(NS + "claimSearch", claimSearhMap);
	}

	@Override // 클레임 상세보기, 수정(업데이트)폼
	public ClaimVO selectOneForDetail(int claimCode) throws Exception {
		logger.debug("[ClaimDao.java/selectOneForDetail Method] Loading");
		return sqlSessionTemplate.selectOne(NS + "selectOneForDetail", claimCode);
	}

	@Override // CategoryVo 셀렉트
	public List<Category> selectCategoryForClaim() throws Exception {
		logger.debug("[ClaimDao.java/selectCategoryForClaim Method] Loading");
		return sqlSessionTemplate.selectList(NS + "selectCategoryForClaim");
	}

	@Override // 클레임 수정(업데이트) 처리
	public int updateClaim(ClaimVO claim) throws Exception {
		logger.debug("[ClaimDao.java/updateClaim Method] Loading");
		logger.debug("[ClaimDao.java/updateClaim Method] claim Param : " + claim);
		return sqlSessionTemplate.update(NS + "updateClaim", claim);
	}

	@Override // 클레임 리스트 페이징용 총 글 갯수 불러오기
	public int getClaimCount() throws Exception {
		logger.debug("[ClaimDao.java/getClaimCount Method] Loading");
		return sqlSessionTemplate.selectOne(NS + "getClaimCount");
	}

	@Override // 클레임 삭제 처리
	public int deleteClaim(int claimCode) throws Exception {
		logger.debug("[ClaimDao.java/deleteClaim Method] Loading");
		return sqlSessionTemplate.delete(NS + "deleteClaim", claimCode);
	}

}
