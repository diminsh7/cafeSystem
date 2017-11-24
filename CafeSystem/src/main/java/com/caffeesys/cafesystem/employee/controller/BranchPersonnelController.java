package com.caffeesys.cafesystem.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	//직원 리스트 페이지 요청 컨트롤러
	@RequestMapping(value = {"/branchPersonnelList"}, method = RequestMethod.GET)
	public String selectBranchManager(Model model, @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) { 
		System.out.println("[employee.controller.BranchPersonnelController.java] : 지점 직원,매니져 리스트 페이지 요청 컨트롤러");
		int branchPersonnelCount = branchPersonnelDao.selectBranchPersonnelCount(); // 직원 총 수
		int pagePerRow = 10; //한 페이지에 몇명의 직원를 보여줄 것인가
		int lastPage = (int) (Math.ceil(branchPersonnelCount / pagePerRow));; //마지막
		List<BranchPersonnelVO> branchPersonnelList = branchPersonnelDao.selectBranchPersonnelList(currentPage,pagePerRow);
		model.addAttribute("currentPage", currentPage); //첫번째 페이지
		model.addAttribute("branchPersonnelCount", branchPersonnelCount);//몇개보여줄것인가
		model.addAttribute("lastPage", lastPage);//마지막페이지
		model.addAttribute("branchPersonnelList",branchPersonnelList);
		return "employee/branchPersonnelList";
	}
	
	//선택 직원 상세페이지 요청 컨트롤러 
	@RequestMapping(value = {"/branchPersonnelDetail"}, method = RequestMethod.GET)
	public String selectBranchManagerDetail(Model model,@RequestParam(value = "branchEmployeeCode", required = true) String branchEmployeeCode) { 
		System.out.println("[employee.controller.BranchPersonnelController.java] : 선택 지원 상페 페이지 요청 컨트롤러");
		List<BranchPersonnelVO> branchPersonnelDetail = branchPersonnelDao.selectBranchPersonnelDetail(branchEmployeeCode);
		model.addAttribute("branchPersonnelDetail",branchPersonnelDetail);
		return "employee/branchPersonnelDetail";
	}
	
	//업데이트 폼 페이지 요청 컨트롤러
	@RequestMapping(value = {"/updateBranchPersonnelForm"}, method = RequestMethod.GET)
	public String selectUpdateBranchPersonnel(Model model,@RequestParam(value = "branchEmployeeCode", required = true) String branchEmployeeCode) { 
		System.out.println("[employee.controller.BranchPersonnelController.java] : 수정 페이지 요청 컨트롤러");
		List<BranchPersonnelVO> branchPersonnelUpdate = branchPersonnelDao.selectUpdateBranchPersonnel(branchEmployeeCode);
		model.addAttribute("branchPersonnelUpdate",branchPersonnelUpdate);
		return "employee/branchPersonnelUpdateForm";
	}
	
	//업데이트 실행 컨트롤러 
	@RequestMapping(value = {"/updateBranchPersonnel"}, method = RequestMethod.POST)
	public String UpdateBranchPersonnel(BranchPersonnelVO branchPersonnelVo) { 
		System.out.println("[employee.controller.BranchPersonnelController.java] : 수정 실행 컨트롤러");
		branchPersonnelDao.updateBranchEmployee(branchPersonnelVo);
		branchPersonnelDao.updateBranchPersonnel(branchPersonnelVo);
		System.out.println("[employee.controller.BranchPersonnelController.java] : 성공");
		return "redirect:/branchPersonnelList";
	}
	
}
