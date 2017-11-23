package com.caffeesys.cafesystem.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caffeesys.cafesystem.employee.service.BranchPersonnelDao;
import com.caffeesys.cafesystem.employee.service.BranchPersonnelService;
import com.caffeesys.cafesystem.employee.service.BranchPersonnelVO;

@Controller
public class BranchPersonnelController {

	@Autowired
	private BranchPersonnelDao branchPersonnelDao;
	@Autowired
	private BranchPersonnelService branchPersonnelService;
	
	//지점 직원 입펵 페이지 실행 컨트롤러
	@RequestMapping(value = "/insertformbranchPersonneel", method = RequestMethod.GET)
	public String insertBranchManager(Model model) { 
		System.out.println("[employee.controller.BranchPersonnelController.java] : 지점직원 입력 폼 페이지 실행 컨트롤러");
		List<BranchPersonnelVO> ShopCodeList = branchPersonnelDao.selectBranchPersonnelShopcode();
		model.addAttribute("branchShopCode",ShopCodeList);
		return "/employee/branchPersonnelInsertForm";
	}  
	
	//직원 입력 실행 컨트롤러
	@RequestMapping(value = "/insertBranchPersonnel", method = RequestMethod.POST)
	public String insertBranchManager(BranchPersonnelVO branchPersonnelVo) { 
		System.out.println("[employee.controller.BranchPersonnelController.java] : 지점직원 입력 실행 컨트롤러");
		branchPersonnelService.insertBranchEmployee(branchPersonnelVo); //지점인사관리테이블 insert
		branchPersonnelService.insertBranchPersonnel(branchPersonnelVo); //지점점주관리테이블 insert

		return "redirect:/branchPersonnelList";
	}  
	
	//직원리스트컨트롤러
	/*@RequestMapping(value = {"/branchPersonnelList"}, method = RequestMethod.GET)
	public String selectBranchManager(Model model) { 
		System.out.println("[employee.controller.BranchPersonnelController.java] : 지점 직원,매니져 리스트 페이지 요청 컨트롤러");
		List<BranchPersonnelVO> branchPersonnelList = branchPersonnelDao.selectBranchPersonnelList();
		System.out.println("컨트롤러 변수 값 확인 branchPersonnelList : " + branchPersonnelList);
		model.addAttribute("branchPersonnelList",branchPersonnelList);
		return "employee/branchManagerList";
	}*/
}
