package com.caffeesys.cafesystem.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping(value = "/insertformHeadEmployee", method = RequestMethod.GET)
	public String insertHeadEmployee(Model model) { 
		System.out.println("[employee.controller.HeadEmployeeController.java] : 본사직원 폼 페이지 실행 컨트롤러");
		List<HeadEmployeeVO> department = headDao.selectDpartment();
		List<HeadEmployeeVO> Bonus= headDao.selectBonus();
		model.addAttribute("department",department);
		model.addAttribute("Bonus",Bonus);
		return "/employee/HeadEmployeeInsertForm";
	}  
}
