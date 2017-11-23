package com.caffeesys.cafesystem.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.caffeesys.cafesystem.board.service.BoardVO;
@Controller
public class BoardController {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// 클레임 입력 폼 요청
	@RequestMapping(value="/boardInsert", method = RequestMethod.GET)
	public String boardInsert() {
		logger.debug("boardInsert 메소드 확인 get방식");
		return "/board/boardInsertForm";
	}
	
	// 클레임 입력 처리
	@RequestMapping(value ="/boardInsert", method = RequestMethod.POST)
	public String boardInsert(BoardVO board) throws Exception {
		logger.debug("boardInsert 메소드확인 post방식");
		return "redirect:/boardList";
	}
	// 클레임 리스트 요청
	/*@RequestMapping(value ="/claimList", method = RequestMethod.GET)
	public String claimList(Model model, HttpSession session) throws Exception {
		logger.debug("[ClaimController.java/claimList Method] claimList.jsp Loading");
		List<ClaimVO> claimList = claimDao.selectAllClaim();
		List<Category> categoryList = claimDao.selectCategoryForClaim(); //수정을 위해 세션에 카테고리 값 넣기
		//logger.debug("[ClaimController.java/insertClaim Method] List<Claim> param : " + clist);
		model.addAttribute("claimList", claimList);
		session.setAttribute("categoryList", categoryList);
		return "/claim/claimList";
	}
	
	// 클레임 게시글 상세보기 페이지 요청
	@RequestMapping(value = "/claimDetail", method = RequestMethod.GET)
	public String claimDetail(Model model, @RequestParam(value = "customerClaimCode", required = true) int customerClaimCode) throws Exception {
		logger.debug("[ClaimController.java/claimDetail Method] claimDetail.jsp Loading");
		logger.debug("[ClaimController.java/claimDetail.Method] customerClaimCode param: " + customerClaimCode);
		ClaimVO claim = claimDao.selectOneForDetail(customerClaimCode);
		logger.debug("[ClaimController.java/claimDetail.Method] claim param: " + claim);
		model.addAttribute("claim", claim);
		return "/claim/claimDetail";
	}
	// 클레임 수정 폼 요청
	@RequestMapping(value="/claimUpdate", method = RequestMethod.GET)
	public String claimUpdate(Model model ,@RequestParam(value = "customerClaimCode", required = true) int customerClaimCode) throws Exception {
		logger.debug("[ClaimController.java/claimUpdate Method] claimUpdate.jsp Loading");
		logger.debug("[ClaimController.java/claimUpdate.Method] customerClaimCode param: " + customerClaimCode);
		ClaimVO claim = claimDao.selectOneForDetail(customerClaimCode);
		logger.debug("[ClaimController.java/claimUpdate.Method] claim param: " + claim);
		model.addAttribute("claim", claim);
		return "/claim/claimUpdateForm";
	}
	
	@RequestMapping(value="/claimUpdate", method = RequestMethod.POST)
	public String claimUpdate(ClaimVO claim) throws Exception {
		logger.debug("[ClaimController.java/claimUpdate Method] ClaimVO param : " + claim);
		logger.debug("[ClaimController.java/claimUpdate Method] Claim Update Action");
		claimDao.updateClaim(claim);
		return "redirect:/claimList";
	}
	
	@RequestMapping(value = "/claimDelete", method=RequestMethod.POST)
	public String claimDelete(@RequestParam(value = "customerClaimCode", required = true) int customerClaimCode) {
		return null;
	}*/
}

