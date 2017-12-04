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
	public String insertBranchPersonneel(Model model) { 
		System.out.println("[employee.controller.BranchPersonnelController.java] : 지점직원 입력 폼 페이지 실행 컨트롤러");
		List<BranchPersonnelVO> ShopCodeList = branchPersonnelDao.selectBranchPersonnelShopcode();
		List<BranchPersonnelVO> localList = branchPersonnelDao.selectBranchPersonnelLocal();
		model.addAttribute("branchShopCode",ShopCodeList);
		model.addAttribute("localList",localList);
		return "/employee/branchPersonnelInsertForm";
	}  
	
	//직원 입력 실행 컨트롤러
	@RequestMapping(value = "/insertBranchPersonnel", method = RequestMethod.POST)
	public String insertBranchPersonneel(BranchPersonnelVO branchPersonnelVo) { 
		System.out.println("[employee.controller.BranchPersonnelController.java] : 지점직원 입력 실행 컨트롤러");
		System.out.println("branchPersonnelVo : " + branchPersonnelVo);
		branchPersonnelService.insertBranchEmployee(branchPersonnelVo); //지점인사관리테이블 insert
		branchPersonnelService.insertBranchPersonnel(branchPersonnelVo); //지점점주관리테이블 insert
		return "redirect:/branchPersonnelList";
	}  
	
	//직원 리스트 페이지 요청 컨트롤러
	@RequestMapping(value = {"/branchPersonnelList"})
	public String selectBranchPersonneel(Model model
			, @RequestParam(value="cate", required=false) String cate
			, @RequestParam(value="input", required=false) String input) { 
		System.out.println("[employee.controller.BranchPersonnelController.java] : 지점 직원,매니져 리스트 페이지 요청 컨트롤러");
		System.out.println("cate : " + cate);
		System.out.println("input : " + input);
		branchPersonnelService.selectBranchPersonneel(model,cate,input);
		return "employee/branchPersonnelList";
		
		}
	
	//선택 직원 상세페이지 요청 컨트롤러 
	@RequestMapping(value = {"/branchPersonnelDetail"}, method = RequestMethod.GET)
	public String selectBranchPersonneelDetail(Model model,@RequestParam(value = "branchEmployeeCode", required = true) String branchEmployeeCode) { 
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
		return "redirect:/branchPersonnelList";
	}
	
	//삭제 실행 컨트롤러 deleteBranchPersonnel
	@RequestMapping(value = {"/deleteBranchPersonnel"}, method = RequestMethod.GET)
	public String deleteBranchPersonnel(@RequestParam(value = "branchEmployeeCode", required = true) String branchEmployeeCode) { 
		System.out.println("[employee.controller.BranchPersonnelController.java] : 삭제 실행 컨트롤러");
		branchPersonnelDao.deleteBranchEmployee(branchEmployeeCode);
		branchPersonnelDao.deleteBranchPersonnel(branchEmployeeCode);
		
		return "redirect:/branchPersonnelList";
	}
	
	//각 지점에서 보는 직원 리스트
	@RequestMapping(value = {"/branchPersonnelInfoList"})
	public String selectBranchPersonneelInfoList(Model model,HttpSession session) throws IOException { 
		System.out.println("[employee.controller.BranchPersonnelController.java] : 각 지점에서 보는 직원 리스트요청 컨트롤러");
		branchPersonnelService.selectBranchPersonneelInfoList(model,session);
		return "employee/branchPersonnelInfoList";
	}
	
}