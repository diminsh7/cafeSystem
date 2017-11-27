package com.caffeesys.cafesystem.board.service;

import java.util.List;

import org.springframework.ui.Model;

import com.caffeesys.cafesystem.Category;


public interface BoardServiceInter {
	public List<Category> selectBoardCategory() throws Exception;
	
	public void searchBoardList(Model model, String searchOption, String keyword, int currentPage) throws Exception;

	//public int searchBoardCount(String searchOption, String keyword) throws Exception;
	
	//public int getBoardCount() throws Exception;
	
	public List<BoardVO> selectBoardList(int currentPage,int pagePerRow) throws Exception;
	
	public void deleteBoard(int boardCode) throws Exception;
	
	public void updateBoard(BoardVO board) throws Exception;
	
	public BoardVO selectBoard(int boardCode) throws Exception;
	
	public void insertBoard(BoardVO board) throws Exception;
	
	public BoardVO selectBoardDetail(int boardCode) throws Exception;

}
