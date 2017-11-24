package com.caffeesys.cafesystem.board.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.caffeesys.cafesystem.Category;
import com.caffeesys.cafesystem.board.service.BoardService;
import com.caffeesys.cafesystem.board.service.BoardVO;
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	//통합게시판 리스트 
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public String boardList(Model model, HttpSession session, 
							@RequestParam(value = "currentPage", 
							required = false, defaultValue = "1")int currentPage) throws Exception {
		
		logger.debug("boardList 메소드 get방식 확인");
		//페이징작업
		int pagePerRow = 10;	//한페이지당 10개
		int boardCount = boardService.getBoardCount(); //boardList의 레코드 수
		List<BoardVO> list = boardService.selectBoardList(currentPage, pagePerRow); //현재페이지의 리스트
		int lastPage = (int)(Math.ceil(boardCount/pagePerRow));
		logger.debug("boardList 메소드 currentPage :{}",currentPage);
		logger.debug("boardList 메소드 accountTitleCount :{}",boardCount);
		logger.debug("boardList 메소드 list :{}",list);
		
		//카테고리 갖고오기 
		List<Category> boardCategory = boardService.selectBoardCategory();
		logger.debug("boardList 메소드 boardCategory :{}",boardCategory);
		model.addAttribute("totalRowCount",boardCount);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("lastPage",lastPage);
		model.addAttribute("boardList",list);
		//카테고리 세션넣기 시작
		session.setAttribute("boardCategory", boardCategory);
		return "/board/boardList";
	}
	// 통합게시판 입력 폼 요청
	@RequestMapping(value="/boardInsert", method = RequestMethod.GET)
	public String boardInsert(Model model) {
		logger.debug("boardInsert 메소드 확인 get방식");
		return "/board/boardInsertForm";
	}
	
	// 통합게시판 입력 처리
	@RequestMapping(value ="/boardInsert", method = RequestMethod.POST)
	public String boardInsert(BoardVO board) throws Exception {
		logger.debug("boardInsert 메소드확인 post방식");
		logger.debug("boardInsert 메소드확인 board:{}",board);
		boardService.insertBoard(board);
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

