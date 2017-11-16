package com.caffeesys.cafesystem.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caffeesys.cafesystem.board.service.Claim;
import com.caffeesys.cafesystem.board.service.ClaimDao;

@Controller
public class ClaimController {
	@Autowired
	private ClaimDao claimDao;

	// 클레임 입력 폼 요청
	@RequestMapping(value = "/insertClaim", method = RequestMethod.GET)
	public String insertClaim() {
		System.out.println("[ClaimController.java/insertClaim Method] claimInsertForm.jsp Loading");
		return "/board/claimInsertForm";
	}
	
	// 클레임 입력 처리
	@RequestMapping(value = "insertClaim", method = RequestMethod.GET)
	public String insertClaim(Claim claim) {
		System.out.println("[ClaimController.java/insertClaim Method] Claim Insert Action");
		return "/board/claimView";
	}
}
