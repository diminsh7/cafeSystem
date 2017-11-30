package com.caffeesys.cafesystem.order.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BranchOrderDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	final String NS = "com.caffeesys.cafesystem.order.service.BranchOrderMapper.";

	public List<BranchOrderVO> branchOrderForm() {
		System.out.print("[BranchOrderDao.java / branchOrderForm.method] Access");
		return sqlSessionTemplate.selectList(NS + "branchOrderForm");
	}
}
