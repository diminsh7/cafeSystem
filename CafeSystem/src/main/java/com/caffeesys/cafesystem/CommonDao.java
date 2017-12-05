package com.caffeesys.cafesystem;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	final String NS = "com.caffeesys.cafesystem.CommonMapper.";
	
	public List<HashMap<String, Object>> localShopCodeSelect(String employeeCode){	
		return sqlSessionTemplate.selectList(NS + "localShopCodeSelect", employeeCode);
	}
}
