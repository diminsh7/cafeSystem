package com.caffeesys.cafesystem.board.service;

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
public class BoardDao implements  BoardDaoInter {
	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);

	private final String NS ="com.caffeesys.cafesystem.board.service.BoardMapper.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

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
			
		return sqlSessionTemplate.selectOne(NS+"getBoardCount");
	}
	//board의 리스트 select
	@Override
	public List<BoardVO> selectBoardList(int currentPage, int pagePerRow) throws Exception {
		logger.debug("selectBoardList 메소드 확인");
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", (currentPage-1)*pagePerRow); //이숫자부터 시작하겠다:beginRow    현재페이지:currentPage, 한페이지의 행의 수:pagePerRow
		map.put("pagePerRow",pagePerRow);	//10	
		return sqlSessionTemplate.selectList(NS+"selectBoardList",map);
	}
	//board의 삭제
	@Override
	public int deleteBoard(int boardCode) throws Exception {
		logger.debug("deleteBoard 메소드의 boardCode :{}",boardCode);
		
		return sqlSessionTemplate.delete(NS+"deleteBoard",boardCode);
	}
	//board 수정한 값 update
	@Override
	public int updateBoard(BoardVO board) throws Exception {
		logger.debug("updateBoard 메소드의 board :{}",board);
		
		return sqlSessionTemplate.update(NS+"updateBoard",board);
	}
	//board 수정하기위해 select
	@Override
	public BoardVO selectBoard(int boardCode) throws Exception {
		
		return null;
	}
	//board 등록
	@Override
	public int insertBoard(BoardVO board) throws Exception {
		logger.debug("insertBoard 메소드 확인");
		logger.debug("insertBoard 메소드의 board :{}",board);
		return sqlSessionTemplate.insert(NS+"insertBoard",board);
	}
	//board 디테일 select
	@Override
	public BoardVO selectBoardDetail(int boardCode) throws Exception {
		logger.debug("selectBoardDetail 메소드의 boardCode :{}",boardCode);
		
		return sqlSessionTemplate.selectOne(NS +"selectBoardDetail", boardCode);
	}
	@Override
	public List<Category> selectBoardCategory() throws Exception {
		logger.debug("selectBoardCategory 메소드 확인");
		return sqlSessionTemplate.selectList(NS+"selectBoardCategory");
	}
}
