package com.caffeesys.cafesystem.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchManagerService {

	@Autowired
	private BranchManagerDao branchManagerDao;
	
	public int insertBranchManager(BranchManager branchManager) {
		System.out.println("[BranchManagerService.insertBranchManager] 실행");
		System.out.println("[BranchManagerService.insertBranchManager] :" + branchManager);
		
		return branchManagerDao.insertBranchManager(branchManager);
	};
	

}