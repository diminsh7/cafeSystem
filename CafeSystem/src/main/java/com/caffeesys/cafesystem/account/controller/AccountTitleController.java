package com.caffeesys.cafesystem.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.account.service.AccountTitleVO;
import com.caffeesys.cafesystem.account.service.AccountTitleService;

@Controller
public class AccountTitleController {
	private static final Logger logger = LoggerFactory.getLogger(AccountTitleController.class);
	@Autowired
	private AccountTitleService accountTitleService;
	
	//계정과목 updateForm 보여주기 get방식으로 accountTitleUpdateForm 보여주기
	@RequestMapping(value="/updateAccountTitleForm", method = RequestMethod.GET)
	public String updateAccountTitle(Model model, 
									@RequestParam(value="accountTitleCode", required=true) String accountTitleCode) {
		logger.debug("updateAccountTitle 메소드의 accountTitleCode 잘 넘어 왔나 확인:{}",accountTitleCode);
		AccountTitleVO accountTitleVo= accountTitleService.selectAccountTitle(accountTitleCode);
		model.addAttribute("accountTitle",accountTitleVo);
		return "/account/accountTitleUpdateForm"; 		
	}
	
	//계정과목 update하기 post 방식으로 accountTitleUpdateForm의 입력값 넘겨주기  
	@RequestMapping(value="/updateAccountTitleForm", method = RequestMethod.POST)
	public String updateAccountTitle(AccountTitleVO accountTitleVo) {
		logger.debug("updateAccountTitle 메소드의 입력값 : {}",accountTitleVo);
		accountTitleService.updateAccountTitle(accountTitleVo);
		return "redirect:/accountTitleList";
	}
	
	//계정과목 list 보여주기
	@RequestMapping(value= {"accountTitleList"}, method = RequestMethod.GET)
	public String listAccountTitle(Model model		
									,@RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) {
		logger.debug("listAccountTitle 메소드 currentPage 확인 :{}",currentPage);
		List<AccountTitleVO> list = accountTitleService.listAccountTitle(model, currentPage);
	
		return "/account/accountTitleList";
	}
	
	//계정과목 insertform 보여주기 get방식으로 accountTitleInsertForm 보여주기
	@RequestMapping(value="/insertAccountTitle", method = RequestMethod.GET)
	public String insertAccountTitle() {
		logger.debug("insertAccountTitle 메소드 확인");
		return "/account/accountTitleInsertForm";
	}
	
	//계정과목 insert 작업 
	@RequestMapping(value="/insertAccountTitle", method = RequestMethod.POST)
	public String insertAccountTitle(AccountTitleVO accountTitleVo) {
		logger.debug("insertAccountTitle메소드의 accountTitleVo 잘받아왔나확인 : {}",accountTitleVo);
		accountTitleService.insertAccountTitle(accountTitleVo);
		return "redirect:/accountTitleList";	// = response.sendRedirect("/accountTitleList");
	}
	
	
}
