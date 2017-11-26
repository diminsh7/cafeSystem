package com.caffeesys.cafesystem.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caffeesys.cafesystem.Category;

@Service
public class BoardService implements BoardServiceInter {
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	@Autowired
	private BoardDao boardDao;
	//검색한  board 리스트
	@Override
	public List<BoardVO> searchBoardList(String searchOption, String keyword) throws Exception {
	
		return null;
	}
	//검색한 board 레코드 개수
	@Override
	public int searchBoardCount(String searchOption, String keyword) throws Exception {
		
		return 0;
	}
	
	//리스트의 레코드 개수 get
	@Override
	public int getBoardCount() throws Exception {
		logger.debug("getBoardCount 메소드 확인");
		int boardCount=0;
		boardCount = boardDao.getBoardCount();
		logger.debug("getBoardCount메소드의 boardCount{}",boardCount);
		
		return boardCount;
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
		int boardCount = boardDao.getBoardCount();
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
