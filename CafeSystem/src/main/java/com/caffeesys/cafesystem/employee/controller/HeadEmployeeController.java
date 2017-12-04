package com.caffeesys.cafesystem.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.employee.service.HeadEmployeeDao;
import com.caffeesys.cafesystem.employee.service.HeadEmployeeService;
import com.caffeesys.cafesystem.employee.service.HeadEmployeeVO;

@Controller
public class HeadEmployeeController {
	
	@Autowired
	private HeadEmployeeDao headDao;
	
	@Autowired
	private HeadEmployeeService headService;

	//본사직원 입력 페이지 실행 컨트롤러
	@RequestMapping(value = "/insertFormHeadEmployee", method = RequestMethod.GET)
	public String insertHeadEmployee(Model model) { 
		System.out.println("[employee.controller.HeadEmployeeController.java] : 본사직원 폼 페이지 실행 컨트롤러");
		List<HeadEmployeeVO> department = headDao.selectDpartment(); //부서
		List<HeadEmployeeVO> Bonus= headDao.selectBonus(); //보너스 퍼센트
		model.addAttribute("department",department);
		model.addAttribute("Bonus",Bonus);
		return "/employee/headEmployeeInsertForm";
	}  
	
	//본사직원 입력 실행 컨트롤러
	@RequestMapping(value = "/insertHeadEmployee", method = RequestMethod.POST)
	public String insertHeadEmployee(Model model, HeadEmployeeVO HeadEmployeeVo) { 
		System.out.println("[employee.controller.HeadEmployeeController.java] : 본사직원 입력 실행 컨트롤러");
		System.out.println("HeadEmployeeVo : "+ HeadEmployeeVo);
		headService.insertHeadEmployee(HeadEmployeeVo);
		return "redirect:/headEmployeeList";
	}
	
	//본사직원리스트
	@RequestMapping(value = "/headEmployeeList")
	public String selectHeadEmployee(Model model
			,@RequestParam(value="cate", required=false) String cate
			,@RequestParam(value="input", required=false) String input) { 
		System.out.println("[employee.controller.HeadEmployeeController.java] : 본사직원리스트 컨트롤러");
		System.out.println("cate : " + cate);
		System.out.println("input : " + input);
		headService.selectHeadEmployeeCount(model,cate,input);
		
		return "/employee/headEmployeeList";
	}
	
	//본사직원 상세조회 리스트
	@RequestMapping(value = "/headEmployeeDetail", method = RequestMethod.GET)
	public String selectHeadEmployeeDetail(Model model,@RequestParam(value = "headEmployeeCode", required = true) String headEmployeeCode) { 
		System.out.println("[employee.controller.HeadEmployeeController.java] : 본사직원상세조회리스트 컨트롤러");
		HeadEmployeeVO headEmployeeDetail = headDao.selectHeadEmployeeDetail(headEmployeeCode);
		model.addAttribute("headEmployeeDetail",headEmployeeDetail);
		return "/employee/headEmployeeDetail";
	}

	//본사직원 삭제 
	@RequestMapping(value = "/headEmployeeDelete", method = RequestMethod.GET)
	public String deleteHeadEmployee(@RequestParam(value = "headEmployeeCode", required = true) String headEmployeeCode) { 
		System.out.println("[employee.controller.HeadEmployeeController.java] : 본사직원 삭제  컨트롤러");
		headDao.deleteHeadEmployee(headEmployeeCode);
		return "redirect:/headEmployeeList";
	}
	
	//본사직원 수정 페이지 이동
	@RequestMapping(value = "/headEmployeeUpdate", method = RequestMethod.GET)
	public String updateHeadEmployee(Model model,@RequestParam(value = "headEmployeeCode", required = true) String headEmployeeCode) { 
		System.out.println("[employee.controller.HeadEmployeeController.java] : 본사직원 수정 페이지 이동 컨트롤러");
		HeadEmployeeVO headEmployeeUpdate =  headDao.updateHeadEmployee(headEmployeeCode);
		List<HeadEmployeeVO> department = headDao.selectDpartment(); //부서
		List<HeadEmployeeVO> Bonus= headDao.selectBonus(); //보너스 퍼센트
		model.addAttribute("department",department);
		System.out.println("department : " + department );
		model.addAttribute("Bonus",Bonus);
		System.out.println("Bonus : " + Bonus );
		model.addAttribute("headEmployeeUpdate",headEmployeeUpdate);
		return "/employee/headEmployeeUpdateFrom";
	}
	
	//본사직원 수정실행
	@RequestMapping(value = "/headEmployeeUpdate", method = RequestMethod.POST)
	public String updateHeadEmployee(HeadEmployeeVO HeadEmployeeVo) { 
		System.out.println("[employee.controller.HeadEmployeeController.java] : 본사직원 수정 페이지 이동 컨트롤러");
		System.out.println("HeadEmployeeVo : " + HeadEmployeeVo );		 
		headDao.updateHeadEmployee(HeadEmployeeVo);
		return "redirect:/headEmployeeList";
	}



}


