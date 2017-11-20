package com.caffeesys.cafesystem.employee.controller; 
 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caffeesys.cafesystem.employee.service.BranchManagerVO;
import com.caffeesys.cafesystem.shop.service.ShopVO;
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
	public String insertBranchManager() { 
		System.out.println("[employee.controller.BranchManagerController.java] : 점주 입력 폼으로 이동 컨트롤러");
		/*List<ShopVO> ShopCodeList = BranchManagerDao.selectBranchManagerShopcode();
		model.addAttribute("branchManagerShopCode",ShopCodeList);
		System.out.println("[employee.controller.BranchManagerController.java] return ShopCodeList :" + ShopCodeList);*/
		return "/employee/branchManagerInsertForm";
	}  
	 
	//직원코드 , 포지션코드는 null -> service에서 추가 작업
	// 점주등록실행
	@RequestMapping(value = "/insertBranchManager", method = RequestMethod.POST)
	public String insertBranchManager(BranchManagerVO branchManager) { 
		System.out.println("[employee.controller.BranchManagerController.java] : 점주 입력 실행 컨트롤러");
		System.out.println("[employee.controller.BranchManagerController.java] : " + branchManager);
		branchManagerService.insertBranchManager(branchManager);
		return "redirect:/branchManagerList";
	}
	
	// 점주 리스트 / Service 안거치고 바로 Dao
	@RequestMapping(value = "/branchManagerList")
	public String selectBranchManager(Model model) { 
		System.out.println("[employee.controller.BranchManagerController.java] : 점주 리스트 출력 컨트롤러");
		List<BranchManagerVO> branchManagerList = branchManagerDao.selectBranchManagerList();
		model.addAttribute("branchManagerList",branchManagerList);
		System.out.println("[employee.controller.BranchManagerController.java]  branchManagerList값 : "+branchManagerList);
		return "employee/branchManagerList";
	}
	
	//점주 상세 조회
	
}
