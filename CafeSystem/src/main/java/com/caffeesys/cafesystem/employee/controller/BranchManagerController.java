package com.caffeesys.cafesystem.employee.controller; 
 
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

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

	//  점주 입력 폼 페이지 실행 컨트롤러 /shop코드 먼저 select함
	@RequestMapping(value = "/insertformbranchManager", method = RequestMethod.GET)
	public String insertBranchManager(Model model) { 
		List<BranchManagerVO> ShopCodeList = branchManagerDao.selectBranchManagerShopcode();
		List<BranchManagerVO> localList = branchManagerDao.selectBranchPersonnelLocal();
		model.addAttribute("branchManagerShopCode",ShopCodeList);
		model.addAttribute("localList",localList);
		return "/employee/branchManagerInsertForm";
	}  
	 
	//직원코드 , 포지션코드는 null -> service에서 추가 작업
	// 점주 입력 실행 컨트롤러
	@RequestMapping(value = "/insertBranchManager", method = RequestMethod.POST)
	public String insertBranchManager(BranchManagerVO branchManagerVo) { 
		branchManagerService.insertBranchEmployee(branchManagerVo); //지점인사관리테이블 insert
		branchManagerService.insertBranchManager(branchManagerVo); //지점점주관리테이블 insert
		return "redirect:/branchManagerList";
	}
	
	//점주 리스트 페이지 요청 컨트롤러
	@RequestMapping(value = {"/branchManagerList"}, method = RequestMethod.GET)
	public String selectBranchManager(Model model) { 
		int branchManagerCount = branchManagerDao.selectBranchMangerCount(); // 점주 총 수
		List<BranchManagerVO> branchManagerList = branchManagerDao.selectBranchManagerList();
		model.addAttribute("branchManagerCount", branchManagerCount);
		model.addAttribute("branchManagerList",branchManagerList);
		return "employee/branchManagerList";
	}
	
	//점주 상세조회 페이지 요청 컨트롤러
	@RequestMapping(value = "/branchManagerDetail")
	public String selectBranchManagerDetail(Model model,@RequestParam(value = "branchEmployeeCode", required = true) String branchEmployeeCode ) {
		List<BranchManagerVO> branchManagerDetail = branchManagerDao.selectBranchManagerDetail(branchEmployeeCode);
		model.addAttribute("branchManagerDetail",branchManagerDetail);
		return "employee/branchManagerDetail";
	}
	
	//점주 삭제 컨트롤러
	@RequestMapping(value = "/deleteBranchManager", method = RequestMethod.GET)
	public String deleteBranchManager(@RequestParam(value = "branchEmployeeCode", required = true) String branchEmployeeCode) {
		branchManagerDao.deleteBranchEmployee(branchEmployeeCode);
		branchManagerDao.deleteBranchManager(branchEmployeeCode);
		return "redirect:/branchManagerList";
	}
	
	//점주 업데이트 폼 페이지 요청 컨트롤러
	@RequestMapping(value = "/updateBranchManager", method = RequestMethod.GET)
	public String updateBranchManager(Model model,@RequestParam(value = "branchEmployeeCode", required = true) String branchEmployeeCode) {
		List<BranchManagerVO> branchManager = branchManagerDao.updateSelectBranchManager(branchEmployeeCode);
		model.addAttribute("BranchManagerUpdate",branchManager);
		return "employee/branchManagerUpdateForm";
	}
	
	//점주 업데이트 처리 컨트롤러
	@RequestMapping(value = "/updateBranchManager", method = RequestMethod.POST)
	public String updateBranchManager(BranchManagerVO branchManagerVo) {
		branchManagerDao.updateBranchEmployee(branchManagerVo);
		branchManagerDao.updateBranchManager(branchManagerVo);
		return "redirect:/branchManagerList";
	}
	
	//점주본인 신상정보 조회
	@RequestMapping(value = "/selectBranchManager", method = RequestMethod.GET)
	public String selectBranchManager(Model model,HttpSession session) throws IOException {
		branchManagerService.selectBranchManager(model,session);
		return "employee/branchManagerinfo";
	}

}