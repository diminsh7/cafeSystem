package com.caffeesys.cafesystem.order.controller;



import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.caffeesys.cafesystem.order.service.BranchOrderRequestDao;
import com.caffeesys.cafesystem.order.service.BranchOrderRequestService;

@Controller
public class BranchOrderRequestController {
	
	@Autowired
	private BranchOrderRequestService RequestService;

	@Autowired
	private BranchOrderRequestDao RequestDao;
	


	//점주에 따른 리스트 출력
	@RequestMapping(value = "/branchOrderRequestList", method = RequestMethod.GET)
	public String seleteBranchOrderRequestList(Model model,HttpSession session) throws IOException{
		System.out.println("[employee.controller.insertBranchManager] 점주에 따른 리스트 출력");
		RequestService.selectBranchOrderRequestList(model,session);
		return "/order/BranchOrderRequestList";
	}
}
