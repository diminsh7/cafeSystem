package com.caffeesys.cafesystem.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.order.service.BranchOrderRequestService;
import com.caffeesys.cafesystem.order.service.BranchOrderRequestVO;

@Controller
public class BranchOrderRequestController {
	
	@Autowired
	private BranchOrderRequestService RequestService;

	
	//지점에  따른 리스트 출력
	@RequestMapping(value = "/branchOrderRequestList", method = RequestMethod.GET)
	public String seleteBranchOrderRequestList(Model model,HttpSession session
			, @RequestParam(value="cate", required=false) String cate
			, @RequestParam(value="input", required=false) String input) throws IOException{
		System.out.println("[order.controller.insertBranchManager] 점주에 따른 리스트 출력 컨트롤러");
		List<BranchOrderRequestVO> orderRequestList = RequestService.selectBranchOrderRequestList(model,session,cate,input);
		model.addAttribute("orderRequestList",orderRequestList);
		
		System.out.println("model : " + model);
		return "/order/branchOrderRequestList";
	}
	
	//선택 전표번호 상세 조회
	@RequestMapping(value = "/branchOrderRequestDetail", method = RequestMethod.GET)
	public String seleteBranchOrderRequest(Model model,@RequestParam(value = "statementNumber", required = true) String statementNumber){
		System.out.println("[order.controller.seleteBranchOrderRequest] 선택한 전표번호 상세조회 컨트롤러 ");
		 List<BranchOrderRequestVO> orderDetail = RequestService.selectOrderRequestDetail(statementNumber);
		model.addAttribute("orderDetail",orderDetail);
		return "/order/branchOrderRequestDetail";
	}
}
