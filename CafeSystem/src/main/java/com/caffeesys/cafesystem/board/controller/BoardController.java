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
	/*@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public String boardList(Model model, HttpSession session, 
							@RequestParam(value = "currentPage", 
							required = false, defaultValue = "1")int currentPage) throws Exception {
		
		logger.debug("boardList 메소드 get방식 확인");
		//페이징작업
		int pagePerRow = 10;	//한페이지당 10개
		int boardCount = boardService.getBoardCount(); //boardList의 레코드 수
		List<BoardVO> boardlist = boardService.selectBoardList(currentPage, pagePerRow); //현재페이지의 리스트
		int lastPage = (int)(Math.ceil(boardCount/pagePerRow));
		logger.debug("boardList 메소드 currentPage :{}",currentPage);
		logger.debug("boardList 메소드 accountTitleCount :{}",boardCount);
		logger.debug("boardList 메소드 boardlist :{}",boardlist);
		
		//카테고리 갖고오기 
		List<Category> boardCategory = boardService.selectBoardCategory();
		logger.debug("boardList 메소드 boardCategory :{}",boardCategory);
		model.addAttribute("totalRowCount",boardCount);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("lastPage",lastPage);
		model.addAttribute("boardList",boardlist);
		
		//카테고리 세션넣기 시작
		session.setAttribute("boardCategory", boardCategory);
		System.out.println("-------------------------------------------------------------");
		logger.debug("boardList 메소드 boardlist :{}",boardlist);
		return "board/boardList";
	}*/
	
	//통합게시판 리스트
	@RequestMapping(value="boardList")
	public String boardList(Model model, HttpSession session
			,@RequestParam(value="searchOption", required=false, defaultValue="all")String searchOption
			,@RequestParam(value="keyword", required=false, defaultValue="") String keyword
			,@RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) throws Exception {
		logger.debug("boardList메소드 확인");
		logger.debug("boardList메소드의 model :{}",model);
		logger.debug("boardList메소드의 searchOption :{}",searchOption);	//all
		logger.debug("boardList메소드의 keyword :{}",keyword);	//""
		logger.debug("boardList메소드의 currentPage :{}",currentPage);	//1
		boardService.searchBoardList(model, searchOption, keyword, currentPage);
		//카테고리 갖고오기 
		List<Category> boardCategory = boardService.selectBoardCategory();
		logger.debug("boardList 메소드 boardCategory :{}",boardCategory);
		//카테고리 세션넣기 시작
		session.setAttribute("boardCategory", boardCategory);
		System.out.println("-------------------------------------------------------------");
		return "board/boardList";
	}
	// 통합게시판 입력 폼 요청
	@RequestMapping(value="/boardInsert", method = RequestMethod.GET)
	public String boardInsert() {
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
	
	//게시글 상세보기위한 select
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String boardDetail(Model model, @RequestParam(value = "boardCode", required = true) int boardCode) throws Exception {
		logger.debug("boardDetail메소드 확인 get방식");
		logger.debug("boardDetail메소드의  " + boardCode);
		BoardVO board = boardService.selectBoardDetail(boardCode);
		
		model.addAttribute("board", board);
		return "/board/boardDetail";
	}
	// 통합게시판 수정 폼 요청
	@RequestMapping(value="/boardUpdate", method = RequestMethod.GET)
	public String boardUpdate(Model model ,@RequestParam(value = "boardCode", required = true) int boardCode) throws Exception {
		logger.debug("boardUpdate메소드 get방식 확인");
		logger.debug("boardUpdate메소드의 boardCode :{}",boardCode);
		BoardVO board = boardService.selectBoardDetail(boardCode);
		logger.debug("boardUpdate메소드의 board :{}",board);
		model.addAttribute("board", board);
		return "/board/boardUpdateForm";
	}
	//통합게시판 수정
	@RequestMapping(value="/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(BoardVO board) throws Exception {
		logger.debug("boardUpdate 메소드 post방식 확인");
		logger.debug("boardUpdate 메소드의  board :{}",board);
		boardService.updateBoard(board);
		return "redirect:/boardList";
	}
	//통합게시판 삭제
	@RequestMapping(value = "/boardDelete", method=RequestMethod.GET)
	public String boardDelete(@RequestParam(value = "boardCode", required = true) int boardCode) throws Exception {
		logger.debug("boardDelete 메소드 post방식 확인");
		logger.debug("boardDelete 메소드의  boardCode :{}",boardCode);
		boardService.deleteBoard(boardCode);
		return "redirect:/boardList";
	}
}

