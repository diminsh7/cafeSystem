package com.caffeesys.cafesystem.claim.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.Category;
import com.caffeesys.cafesystem.claim.service.ClaimVO;
import com.caffeesys.cafesystem.claim.service.ClaimDao;

@Controller
public class ClaimController { 
	@Autowired
	private ClaimDao claimDao;
	
	private static final Logger logger = LoggerFactory.getLogger(ClaimController.class);

	// 클레임 입력 폼 요청
	@RequestMapping(value = "/claimInsert", method = RequestMethod.GET)
	public String claimInsert(Model model) throws Exception {
		logger.debug("[ClaimController.java/claimInsert Method] claimInsertForm.jsp Loading");
		//logger.debug("[ClaimController.java/claimInsert Method] categorylist param" + clist);	
		return "/claim/claimInsertForm";
	}
	
	// 클레임 입력 처리
	@RequestMapping(value = "/claimInsert", method = RequestMethod.POST)
	public String claimInsert(ClaimVO claim) throws Exception {
		logger.debug("[ClaimController.java/claimInsert Method] Claim Insert Action");	
		claimDao.insertClaim(claim);
		return "redirect:/claimList";
	}
	// 클레임 리스트 요청
	@RequestMapping(value ="/claimList", method = RequestMethod.GET)
	public String claimList(Model model, HttpSession session, @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) throws Exception {
		logger.debug("[ClaimController.java/claimList Method] claimList.jsp Loading");
		int claimCount = claimDao.getClaimCount();
		logger.debug("[ClaimController.java/claimList Method] claimCount Param : " + claimCount);
		int page = 1;
		int pagePerRow = 10;
		int lastPage = (int)(Math.ceil(claimCount / pagePerRow)) + 1;
		logger.debug("[ClaimController.java/claimList Method] lastPage Param : " + lastPage);
		List<ClaimVO> claimList = claimDao.getClaimList(currentPage, pagePerRow);
		
		//1,2,3.. 페이징을 위한 코드
		int maxPage = (int)((double)claimCount/pagePerRow+0.95);
		int startPage = (((int)((double)page / 10 + 0.9)) - 1 ) * 10 + 1;
		int endPage = startPage+10-1;
		if(endPage > maxPage) endPage = maxPage;
		
		//수정을 위해 세션에 카테고리 값 넣기
		List<Category> claimCategory = claimDao.selectCategoryForClaim(); 
		
		//logger.debug("[ClaimController.java/insertClaim Method] List<Claim> param : " + clist);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("claimCount", claimCount);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("claimList", claimList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("maxPage", maxPage);
		session.setAttribute("claimCategory", claimCategory);
		return "/claim/claimList";
	}
	
	// 클레임 게시글 상세보기 페이지 요청
	@RequestMapping(value = "/claimDetail", method = RequestMethod.GET)
	public String claimDetail(Model model, @RequestParam(value = "claimCode", required = true) int claimCode) throws Exception {
		logger.debug("[ClaimController.java/claimDetail Method] claimDetail.jsp Loading");
		logger.debug("[ClaimController.java/claimDetail.Method] claimCode param: " + claimCode);
		ClaimVO claim = claimDao.selectOneForDetail(claimCode);
		logger.debug("[ClaimController.java/claimDetail.Method] claim param: " + claim);
		model.addAttribute("claim", claim);
		return "/claim/claimDetail";
	}
	// 클레임 수정 폼 요청
	@RequestMapping(value="/claimUpdate", method = RequestMethod.GET)
	public String claimUpdate(Model model ,@RequestParam(value = "claimCode", required = true) int claimCode) throws Exception {
		logger.debug("[ClaimController.java/claimUpdate Method] claimUpdate.jsp Loading");
		logger.debug("[ClaimController.java/claimUpdate.Method] claimCode param: " + claimCode);
		ClaimVO claim = claimDao.selectOneForDetail(claimCode);
		logger.debug("[ClaimController.java/claimUpdate.Method] claim param: " + claim);
		model.addAttribute("claim", claim);
		return "/claim/claimUpdateForm";
	}
	// 클레임 수정 처리
	@RequestMapping(value="/claimUpdate", method = RequestMethod.POST)
	public String claimUpdate(ClaimVO claim) throws Exception {
		logger.debug("[ClaimController.java/claimUpdate Method] ClaimVO param : " + claim);
		logger.debug("[ClaimController.java/claimUpdate Method] Claim Update Action");
		claimDao.updateClaim(claim);
		return "redirect:/claimList";
	}
	// 클레임 삭제 처리
	@RequestMapping(value = "/claimDelete", method=RequestMethod.GET)
	public String claimDelete(@RequestParam(value = "claimCode", required = true) int claimCode) throws Exception {
		logger.debug("[ClaimController.java/claimDelete Method] Claim Delete Action");
		claimDao.deleteClaim(claimCode);
		return "redirect:/claimList";
	}
}
