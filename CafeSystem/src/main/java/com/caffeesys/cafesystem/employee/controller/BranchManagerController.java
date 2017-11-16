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
import com.caffeesys.cafesystem.employee.service.BranchManagerService;

@Controller
public class BranchManagerController {
	@Autowired
	private BranchManagerDao branchManagerDao;
	private BranchManagerService branchManagerService;

	// 점장등록폼
	@RequestMapping(value = "/insertformbranchManager", method = RequestMethod.GET)
	public String insertBranchManager() { //
		System.out.println("[employee.controller.BranchManagerController.java] : 지점장 입력 폼으로 이동 컨트롤러");
		return "/employee/branchManagerInsertForm";
	}

	// 점장등록실행
	@RequestMapping(value = "/selectBranchManager", method = RequestMethod.POST)
	public String insertBranchManager(BranchManager branchManager) { //
		System.out.println("[employee.controller.BranchManagerController.java] : 지점장 입력 실행 컨트롤러");
		branchManagerService.insertBranchManager(branchManager);
		return "redirect:/branchManagerList";
	}
	
	// 지점장 리스트 
	@RequestMapping(value = "/branchManagerList")
	public String selectBranchManager(Model model) { //
		System.out.println("[employee.controller.BranchManagerController.java] : 지점장 리스트 출력 컨트롤러");
		List<BranchManager> branchManagerList = branchManagerDao.selectBranchManager();
		model.addAttribute("branchManagerList",branchManagerList);
		return "employee/branchManagerList";
	}

}
