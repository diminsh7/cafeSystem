package com.caffeesys.cafesystem.order.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchOrderService {
	
	@Autowired
	BranchOrderDao branchOrderDao;
	
	@Autowired
	HttpSession session;
	
	public List<BranchOrderVO> branchOrderForm(){
		System.out.println("[BranchOrderService.java / branchOrderForm.method] Access");
		return branchOrderDao.branchOrderForm();
	}
}
