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

	//  점주 입력 폼 페이지 실행 컨트롤러 /shop코드 먼저 select함
	@RequestMapping(value = "/insertformbranchManager", method = RequestMethod.GET)
	public String insertBranchManager(Model model) { 
		System.out.println("[employee.controller.BranchManagerController.java] : 점주 입력 폼 페이지 실행 컨트롤러");
		List<BranchManagerVO> ShopCodeList = branchManagerDao.selectBranchManagerShopcode();
		model.addAttribute("branchManagerShopCode",ShopCodeList);
		return "/employee/branchManagerInsertForm";
	}  
	 
	//직원코드 , 포지션코드는 null -> service에서 추가 작업
	// 점주 입력 실행 컨트롤러
	@RequestMapping(value = "/insertBranchManager", method = RequestMethod.POST)
	public String insertBranchManager(BranchManagerVO branchManagerVo) { 
		System.out.println("[employee.controller.BranchManagerController.java] : 점주 입력 실행 컨트롤러");
		branchManagerService.insertBranchEmployee(branchManagerVo); //지점인사관리테이블 insert
		branchManagerService.insertBranchManager(branchManagerVo); //지점점주관리테이블 insert
		return "redirect:/branchManagerList";
	}
	
	//점주 리스트 페이지 요청 컨트롤러
	@RequestMapping(value = {"/branchManagerList"}, method = RequestMethod.GET)
	public String selectBranchManager(Model model, @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) { 
		System.out.println("[employee.controller.BranchManagerController.java] : 점주 리스트 페이지 요청 컨트롤러");
		int branchManagerCount = branchManagerDao.selectBranchMangerCount(); // 점주 총 수
		int pagePerRow = 10; //한 페이지에 몇명의 점주를 보여줄 것인가
		int lastPage = (int) (Math.ceil(branchManagerCount / pagePerRow));; //마지막
		List<BranchManagerVO> branchManagerList = branchManagerDao.selectBranchManagerList(currentPage,pagePerRow);
		model.addAttribute("currentPage", currentPage); //첫번째 페이지
		model.addAttribute("branchManagerCount", branchManagerCount);//몇개보여줄것인가
		model.addAttribute("lastPage", lastPage);//마지막페이지
		model.addAttribute("branchManagerList",branchManagerList);
		return "employee/branchManagerList";
	}
	
	//점주 상세조회 페이지 요청 컨트롤러
	@RequestMapping(value = "/branchManagerDetail")
	public String selectBranchManagerDetail(Model model,@RequestParam(value = "branchEmployeeCode", required = true) String branchEmployeeCode ) {
		System.out.println("[employee.controller.selectBranchManagerDetail.java] : 점주 상세조회 페이지 요청 컨트롤러");
		List<BranchManagerVO> branchManagerDetail = branchManagerDao.selectBranchManagerDetail(branchEmployeeCode);
		model.addAttribute("branchManagerDetail",branchManagerDetail);
		return "employee/branchManagerDetail";
	}
	
	//점주 삭제 컨트롤러
	@RequestMapping(value = "/deleteBranchManager", method = RequestMethod.GET)
	public String deleteBranchManager(@RequestParam(value = "branchEmployeeCode", required = true) String branchEmployeeCode) {
		System.out.println("[employee.controller.selectBranchManagerDelete.java] : 점주 삭제 처리 컨트롤러");
		branchManagerDao.deleteBranchEmployee(branchEmployeeCode);
		branchManagerDao.deleteBranchManager(branchEmployeeCode);
		return "redirect:/branchManagerList";
	}
	
	//점주 업데이트 폼 페이지 요청 컨트롤러
	@RequestMapping(value = "/updateBranchManager", method = RequestMethod.GET)
	public String updateBranchManager(Model model,@RequestParam(value = "branchEmployeeCode", required = true) String branchEmployeeCode) {
		System.out.println("[employee.controller.selectBranchManagerDelete.java] : 점주 업데이트 폼 페이지 요청 컨트롤러");
		List<BranchManagerVO> branchManager = branchManagerDao.updateSelectBranchManager(branchEmployeeCode);
		model.addAttribute("BranchManagerUpdate",branchManager);
		return "employee/branchManagerUpdateForm";
	}
	
	//점주 업데이트 처리 컨트롤러
	@RequestMapping(value = "/updateBranchManager", method = RequestMethod.POST)
	public String updateBranchManager(BranchManagerVO branchManagerVo) {
		System.out.println("[employee.controller.selectBranchManagerDelete.java] : 점주 업데이트 처리 컨트롤러");
		branchManagerDao.updateBranchEmployee(branchManagerVo);
		branchManagerDao.updateBranchManager(branchManagerVo);
		return "redirect:/branchManagerList";
	}
	
	

}
