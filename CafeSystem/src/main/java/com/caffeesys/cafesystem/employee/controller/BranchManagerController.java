package com.caffeesys.cafesystem.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caffeesys.cafesystem.employee.service.BranchManager;
import com.caffeesys.cafesystem.employee.service.BranchManagerDao;

@Controller
public class BranchManagerController {
	@Autowired
	private BranchManagerDao branchManagerDao;
	
	//지점장 등록 폼
	@RequestMapping(value ="/insertbranchManager", method = RequestMethod.GET)
	public String insertBranchManager(Model model) { //
			System.out.println("[employee.controller.BranchManagerController.java] : 지점장입력폼요청");
			List<BranchManager> list =  branchManagerDao.selectBranchManagerbyLocalCode();
			model.addAttribute("localcode",list);
		return "/employee/BranchManagerInsertForm";
	}
	
 
	
	
}
