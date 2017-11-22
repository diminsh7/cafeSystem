package com.caffeesys.cafesystem.employee.controller; 
 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.employee.service.BranchManagerVO;
import com.caffeesys.cafesystem.employee.service.BranchManagerDao;
import com.caffeesys.cafesystem.employee.service.BranchManagerService;
 
@Controller
public class BranchManagerController {
	@Autowired
	private BranchManagerDao branchManagerDao;
	
	@Autowired
	private BranchManagerService branchManagerService;

	// 점주등록폼으로 이동 /ShopCode가지고 감 
	@RequestMapping(value = "/insertformbranchManager", method = RequestMethod.GET)
	public String insertBranchManager(Model model) { 
		System.out.println("[employee.controller.BranchManagerController.java] : 점주 입력 폼으로 이동 컨트롤러");
		List<BranchManagerVO> ShopCodeList = branchManagerDao.selectBranchManagerShopcode();
		model.addAttribute("branchManagerShopCode",ShopCodeList);
		return "/employee/branchManagerInsertForm";
	}  
	 
	//직원코드 , 포지션코드는 null -> service에서 추가 작업
	// 점주등록실행 
	@RequestMapping(value = "/insertBranchManager", method = RequestMethod.POST)
	public String insertBranchManager(BranchManagerVO branchManagerVo) { 
		System.out.println("[employee.controller.BranchManagerController.java] : 점주 입력 실행 컨트롤러");
		System.out.println("[employee.controller.BranchManagerController.java] : " + branchManagerVo);
		branchManagerService.insertBranchEmployee(branchManagerVo); //지점인사관리테이블 insert
		branchManagerService.insertBranchManager(branchManagerVo); //지점점주관리테이블 insert
		return "redirect:/branchManagerList";
	}
	
	// 점주 리스트  branchManagerList
	@RequestMapping(value = "/branchManagerList")
	public String selectBranchManager(Model model) { 
		System.out.println("[employee.controller.BranchManagerController.java] : 점주 리스트 출력 컨트롤러");
		List<BranchManagerVO> branchManagerList = branchManagerDao.selectBranchManagerList();
		model.addAttribute("branchManagerList",branchManagerList);
		return "employee/branchManagerList";
	}
	
	//점주 상세 조회 branchManagerDetail
	@RequestMapping(value = "/branchManagerDetail")
	public String selectBranchManagerDetail(Model model,@RequestParam(value = "branchEmployeeCode", required = true) String branchEmployeeCode ) {
		System.out.println("[employee.controller.selectBranchManagerDetail.java] : 점주 상세조회 출력 컨트롤러");
		List<BranchManagerVO> branchManagerDetail = branchManagerDao.selectBranchManagerDetail(branchEmployeeCode);
		model.addAttribute("branchManagerDetail",branchManagerDetail);
		return "employee/branchManagerDetail";
	}
	
	//점주 삭제 페이지 요청
	@RequestMapping(value = "/deleteBranchManager", method = RequestMethod.GET)
	public String deleteBranchManagerFrom(@RequestParam(value = "branchEmployeeCode", required = true) String branchEmployeeCode ) {
		System.out.println("[employee.controller.selectBranchManagerDelete.java] : 점주 삭제페이지요청 컨트롤러");
		return "employee/branchManagerDelete";
	}
	
	//점주 삭제  요청
	@RequestMapping(value = "/deleteBranchManager", method = RequestMethod.POST)
	public String deleteBranchManager(@RequestParam(value = "branchEmployeeCode", required = true) String branchEmployeeCode) {
		System.out.println("[employee.controller.selectBranchManagerDelete.java] : 점주 삭제 컨트롤러");
		branchManagerDao.deleteBranchEmployee(branchEmployeeCode);
		branchManagerDao.deleteBranchManager(branchEmployeeCode);
		return "redirect:/branchManagerList";
	}
	

}
