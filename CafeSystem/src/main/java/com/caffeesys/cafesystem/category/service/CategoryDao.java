package com.caffeesys.cafesystem.category.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.caffeesys.cafesystem.Category;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private String NS = "com.caffeesys.cafesystem.category.service.CategoryMapper.";
	
	public List<Category> cateList(Map<String, String> cateMap){
		System.out.println("[CategoryDao.java / cateList.method] Loading");
		return sqlSessionTemplate.selectList(NS + "cateList", cateMap);
	}
}
