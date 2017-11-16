package com.caffeesys.cafesystem.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@RequestMapping(value = "/insertClaim", method = RequestMethod.POST)
	public String insertClaim(Claim claim) {
		System.out.println("[ClaimController.java/insertClaim Method] Claim Insert Action");
		claimDao.insertClaim(claim);
		return "redirect:/board/claimList";
	}
	
	@RequestMapping(value ="/listClaim", method = RequestMethod.GET)
	public String listClaim(Model model) {
		System.out.println("[ClaimController.java/insertClaim Method] claimList.jsp Loading");
		List<Claim> clist = claimDao.selectAllClaim();
		//System.out.println("[ClaimController.java/insertClaim Method param] " + clist);
		model.addAttribute("clist", clist);
		return "/board/claimList";
	}
}
