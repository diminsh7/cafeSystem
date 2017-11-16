package com.caffeesys.cafesystem.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BranchManagerDao {

	private final String NS = "com.caffeesys.cafesystem.employee.service.BranchManagerMapper.";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// 지점장입력
	public int insertBranchManager(BranchManager branchManager) {
		System.out.println("[BranchManagerDao] 실행");
		return sqlSessionTemplate.insert(NS + "insertBranchImployeeB");
	}
	
	//지점장 리스트
	public List<BranchManager> selectBranchManager() {
		System.out.println("[BranchManagerDao.selectBranchManager] 실행");
		return sqlSessionTemplate.selectList(NS + "selectBranchEmployeeManager");
	}

	

}
