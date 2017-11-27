package com.caffeesys.cafesystem.board.service;

public class BoardVO {
	private int boardCode; // 게시글코드(PK)
	private String categoryCode; // 카테고리(FK)
	private String employeeCode; // 직원코드(FK)
	private String boardTitle; // 제목
	private String boardContent; // 내용
	private String boardDate; // 날짜
	private String boardFile; // 첨부파일
	private String categorySmall;
	
	
	public BoardVO() {
		super();
	}
	public BoardVO(int boardCode, String categoryCode, String employeeCode, String boardTitle, String boardContent,
			String boardDate, String boardFile, String categorySmall) {
		super();
		this.boardCode = boardCode;
		this.categoryCode = categoryCode;
		this.employeeCode = employeeCode;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardFile = boardFile;
		this.categorySmall = categorySmall;
	}
	public int getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(String boardFile) {
		this.boardFile = boardFile;
	}
	public String getCategorySmall() {
		return categorySmall;
	}
	public void setCategorySmall(String categorySmall) {
		this.categorySmall = categorySmall;
	}
	@Override
	public String toString() {
		return "BoardVO [boardCode=" + boardCode + ", categoryCode=" + categoryCode + ", employeeCode=" + employeeCode
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardDate=" + boardDate
				+ ", boardFile=" + boardFile + ", categorySmall=" + categorySmall + "]";
	}
	
}