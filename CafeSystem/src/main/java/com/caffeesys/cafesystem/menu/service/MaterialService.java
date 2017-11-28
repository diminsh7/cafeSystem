package com.caffeesys.cafesystem.menu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MaterialService {
	private static final Logger logger = LoggerFactory.getLogger(MaterialService.class);

	@Autowired
	private MaterialDao materialDao;
	
	//원가등록  selectMaterialCodeMax
	public void insertMaterial(MaterialVO aterialVo) throws Exception {
		logger.debug("insertMaterial 실행 aterialVo : ", aterialVo);
		int codeMax = materialDao.selectMaterialCodeMax();
		int materialCode = codeMax + 1;
		aterialVo.setMaterialCode(materialCode);
		logger.debug("aterialVo : ", aterialVo);
		materialDao.insertMaterial(aterialVo);
	}
}
