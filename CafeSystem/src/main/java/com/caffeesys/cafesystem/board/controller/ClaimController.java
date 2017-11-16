package com.caffeesys.cafesystem.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caffeesys.cafesystem.board.service.ClaimDao;

@Controller
public class ClaimController {
	@Autowired
	private ClaimDao claimDao;
	
	@RequestMapping(value="/insertClaim", method = RequestMethod.GET)
	public String insertClaim() {
		System.out.println("[ClaimController.java/insertClaim Method] claimInsertForm Loading");
		return "/board/claimInsertForm";
	}
}
