package com.caffeesys.cafesystem.account.controller;

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

	//계정과목 list 보여주기<검색 포함>
	@RequestMapping(value= "/accountTitleList")
	public  String listAccountTitle(Model model	
			,@RequestParam(value="searchOption", required=false, defaultValue="all")String searchOption
			,@RequestParam(value="keyword", required=false, defaultValue="") String keyword
			,@RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) throws Exception {
		logger.debug("listAccountTitle메소드 확인");
		logger.debug("listAccountTitle메소드의 model :{}",model);
		logger.debug("listAccountTitle메소드의 searchOption :{}",searchOption);	//all
		logger.debug("listAccountTitle메소드의 keyword :{}",keyword);	//""
		logger.debug("listAccountTitle메소드의 currentPage :{}",currentPage);	//1
		accountTitleService.listAll(model, searchOption, keyword, currentPage);
	
		return "account/accountTitleList";
	}
	
	//계정과목 delete 
	@RequestMapping(value="/accountTitleDelete", method = RequestMethod.GET)
	public String deleteAccountTitle(@RequestParam(value="accountTitleCode", required=true) String accountTitleCode) throws Exception {
		logger.debug("deleteAccountTitle메소드의 accountTitleCode :{}",accountTitleCode);
		accountTitleService.deleteAccountTitle(accountTitleCode);
		
		return "redirect:/accountTitleList";
	}	
	
	//계정과목 updateForm 보여주기 get방식으로 accountTitleUpdateForm 보여주기
	@RequestMapping(value="/accountTitleUpdate", method = RequestMethod.GET)
	public String updateAccountTitle(Model model, 
									@RequestParam(value="accountTitleCode", required=true) String accountTitleCode) throws Exception {
		logger.debug("updateAccountTitle 메소드의 accountTitleCode 잘 넘어 왔나 확인:{}",accountTitleCode);
		AccountTitleVO accountTitleVo= accountTitleService.selectAccountTitle(accountTitleCode);
		model.addAttribute("accountTitle",accountTitleVo);
		return "/account/accountTitleUpdateForm"; 		
	}
	
	//계정과목 update하기 post 방식으로 accountTitleUpdateForm의 입력값 넘겨주기  
	@RequestMapping(value="/accountTitleUpdate", method = RequestMethod.POST)
	public String updateAccountTitle(AccountTitleVO accountTitleVo) throws Exception {
		logger.debug("updateAccountTitle 메소드의 입력값 : {}",accountTitleVo);
		accountTitleService.updateAccountTitle(accountTitleVo);
		return "redirect:/accountTitleList";
	}
	
	//계정과목 insertform 보여주기 get방식으로 accountTitleInsertForm 보여주기
	@RequestMapping(value="/accountTitleInsert", method = RequestMethod.GET)
	public String insertAccountTitle() throws Exception {
		logger.debug("insertAccountTitle 메소드 확인");
		return "/account/accountTitleInseartForm";
	}
	
	//계정과목 insert 작업 
	@RequestMapping(value="/accountTitleInsert", method = RequestMethod.POST)
	public String insertAccountTitle(AccountTitleVO accountTitleVo) throws Exception {
		logger.debug("insertAccountTitle메소드의 accountTitleVo 잘받아왔나확인 : {}",accountTitleVo);
		accountTitleService.insertAccountTitle(accountTitleVo);
		return "redirect:/accountTitleList";	// = response.sendRedirect("/accountTitleList");
	}
}
