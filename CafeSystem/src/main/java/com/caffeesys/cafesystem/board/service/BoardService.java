package com.caffeesys.cafesystem.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.caffeesys.cafesystem.Category;
import com.caffeesys.cafesystem.account.controller.PasingService;
import com.caffeesys.cafesystem.account.service.AccountTitleDao;

@Service
public class BoardService implements BoardServiceInter {
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private PasingService pasingService;
	//검색한  board 리스트
	@Override
	public void searchBoardList(Model model, String searchOption, String keyword, int currentPage) throws Exception {
		logger.debug("searchBoardList메소드의 searchOption :{}",searchOption);	//all, account_title_code, account_title_name, account_title_content
		logger.debug("searchBoardList메소드의 keyword :{}",keyword);	//검색어
		Map<String, String> map;
		if(searchOption != "") {
			map = new HashMap<String, String>();
			map.put("searchOption", searchOption);
			map.put("keyword",keyword);			
		}else {
			map = null;
		}
		logger.debug("searchBoardList 메소드의  map :{}",map);
		map = pasingService.paging(model, currentPage, 10, boardDao.getBoardCount(map), map);
		model.addAttribute("boardList",boardDao.searchBoardList(map));
		logger.debug("searchBoardList 메소드의  map :{}",map);
	}

	//board의 리스트 select
	@Override
	public List<BoardVO> selectBoardList(int currentPage, int pagePerRow) throws Exception {
		logger.debug("selectBoardList 메소드 확인");
		List<BoardVO> list = boardDao.selectBoardList(currentPage, pagePerRow);
		logger.debug("selectBoardList 메소드의 list{}",list);
		return list;
	}
	//board의 삭제
	@Override
	public void deleteBoard(int boardCode) throws Exception {
		logger.debug("deleteBoard 메소드의 boardCode: {}",boardCode);
		boardDao.deleteBoard(boardCode);

	}
	//board 수정한 값 update
	@Override
	public void updateBoard(BoardVO board) throws Exception {
		logger.debug("updateBoard 메소드의 board: {}",board);
		boardDao.updateBoard(board);
	}
	//board 수정하기위해 select
	@Override
	public BoardVO selectBoard(int boardCode) throws Exception {
		
		return null;
	}
	//board Insert
	@Override
	public void insertBoard(BoardVO board) throws Exception {
		logger.debug("insertBoard 메소드의 board :{}",board);
		int boardCount = boardDao.selectBoardMax();
		int boardCode = boardCount + 1;
		board.setBoardCode(boardCode);
		logger.debug("insertBoard 메소드의 board :{}",board);
		boardDao.insertBoard(board);
	}
	//board 디테일
	@Override
	public BoardVO selectBoardDetail(int boardCode) throws Exception {
		logger.debug("selectBoardDetail 메소드의 boardCode :{}",boardCode);
		BoardVO board = boardDao.selectBoardDetail(boardCode);
		logger.debug("selectBoardDetail 메소드의  리턴값 board :{}",board);
		return board;
	}
	@Override
	public List<Category> selectBoardCategory() throws Exception {
		logger.debug("selectBoardCategory 메소드 확인");
		List<Category> boardCategory = boardDao.selectBoardCategory();
		logger.debug("selectBoardCategory 메소드의 list{}",boardCategory);
		return boardCategory;
	}


}
