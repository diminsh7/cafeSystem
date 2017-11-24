package com.caffeesys.cafesystem.board.service;

import java.util.List;

import com.caffeesys.cafesystem.Category;

public interface BoardDaoInter {
		public List<Category> selectBoardCategory() throws Exception;
		
		public List<BoardVO> searchBoardList(String searchOption, String keyword) throws Exception;
		
		public int searchBoardCount(String searchOption, String keyword) throws Exception;
		
		public int getBoardCount() throws Exception;
		
		public List<BoardVO> selectBoardList(int currentPage,int pagePerRow) throws Exception;
		
		public int deleteBoard(int boardCode) throws Exception;
		
		public int updateBoard(BoardVO board) throws Exception;
		
		public BoardVO selectBoard(int boardCode) throws Exception;

		public int insertBoard(BoardVO board) throws Exception;
		
		public BoardVO selectBoardDetail(int boardCode) throws Exception;

}
