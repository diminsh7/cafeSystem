package com.caffeesys.cafesystem.claim.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.claim.service.ClaimDao;
import com.caffeesys.cafesystem.claim.service.ClaimReplyDao;
import com.caffeesys.cafesystem.claim.service.ClaimVO;

@Controller
public class ClaimReplyController {
	
	@Autowired
	private ClaimReplyDao claimReplyDao;
	@Autowired
	private ClaimDao claimDao;
	
	private static final Logger logger = LoggerFactory.getLogger(ClaimReplyController.class);
	
	@RequestMapping(value = "/claimReply", method = RequestMethod.GET)
	public String claimReply(Model model, @RequestParam(value = "claimCode", required = true) int claimCode) throws Exception {
		logger.debug("[ClaimReplyController.java/claimReply Method] claimReplyInsertForm.jsp Loading");
		logger.debug("[ClaimReplyController.java/claimReply.Method] claimCode param: " + claimCode);
		ClaimVO claim = claimDao.selectOneForDetail(claimCode);
		model.addAttribute("claim", claim);
		return "/claim/claimReplyInsertForm";
	}
	
	@RequestMapping(value = "/claimReply", method = RequestMethod.POST)
	public String claimReply(ClaimVO claim) throws Exception {
		logger.debug("[ClaimReplyController.java/claimReply Method] Loading");
		logger.debug("[ClaimReplyController.java/claimReply.Method] ClaimVO param: " + claim);
		claimReplyDao.insertClaimReply(claim);
		return "redirect:/claimList";
	}
}
