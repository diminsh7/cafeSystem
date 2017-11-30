package com.caffeesys.cafesystem.menu.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class MaterialDao {
	
	private static final Logger logger = LoggerFactory.getLogger(MaterialDao.class);

	private final static String NS = "com.caffeesys.cafesystem.menu.service.MaterialMapper.";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	//입력폼에서필요한메뉴명
	public List<MaterialVO> selectManuName(){
		logger.debug("[selectManuName] 메뉴코드, 메뉴명 구하기 실행");
		return sqlSessionTemplate.selectList(NS + "selectMenuName");	
	}
	//입력폼에서필요한 사이즈
	public List<MaterialVO> selectSize(){
		logger.debug("[selectSize] 사이즈 구하기 실행");
		return sqlSessionTemplate.selectList(NS + "selectSize");	
	}
	//입력폼에서 필요한 발주품목 
	public List<MaterialVO> selectTemp(){
		logger.debug("[selectitem] 핫 아이스 구하기 실행");
		return sqlSessionTemplate.selectList(NS + "selectTemp");	
	}
	//입력폼에서 필요한 온도 표시 
	public List<MaterialVO> selectitem(){
		logger.debug("[selectitem] 품목명 구하기 실행");
		return sqlSessionTemplate.selectList(NS + "selectitem");	
	}
	
	//코드 마지막 번호 구하기 실행
	public int selectMaterialCodeMax(){
		logger.debug("[selectMaterialCodeMax] 코드 마지막 번호 구하기 실행");
		return sqlSessionTemplate.selectOne(NS + "selectMaterialCodeMax");	
	}
	
	//원가관리 등록 실행 
	public int insertMaterial(MaterialVO materialVo){
		logger.debug("[insertMaterial] 원가 등록 실행");
		return sqlSessionTemplate.insert(NS + "insertMaterial",materialVo);	
	}
	
	//리스트
	public List<MaterialVO> selectBranchPersonnelList(){
		logger.debug("[selectBranchPersonnelList] 지점리스트 가져오기 실행");
		return sqlSessionTemplate.selectList(NS + "selectMaterialList");
	}
	
	/*//리스트
		public List<MaterialVO> selectBranchPersonnelList(Map<String, String> map){
			logger.debug("[selectBranchPersonnelList] 지점리스트 가져오기 실행");
			return sqlSessionTemplate.selectList(NS + "selectMaterialList",map);
		}*/
	
	//삭제 
	public int deleteMaterial(int materialCode){
		logger.debug("[deleteMaterial] 삭제실행");
		System.out.println("materialCode : " + materialCode);
		
		return sqlSessionTemplate.delete(NS + "deleteMaterial",materialCode);
	}

	//수정 폼 
	public List<MaterialVO> selectUpdateMaterial(int materialCode){
		logger.debug("[updateMaterial] 수정 폼으로 이동");		
		return sqlSessionTemplate.selectList(NS + "selectUpdateMaterial",materialCode);
	}
	
	//수정실행 
	public int updateMaterial(MaterialVO materialVo){
		logger.debug("[updateMaterial] 수정실행");
		System.out.println("materialVo : " + materialVo);
		return sqlSessionTemplate.update(NS + "updateMaterial",materialVo);
	}
	
	//단가 구하기 전 품목의 가격 용량 구하기 selectItemPriceSize
	public MaterialVO selectItemPriceSize(String itemCode) {
		logger.debug("[selectItemPriceSize] 가격 용량 구하기");
		return sqlSessionTemplate.selectOne(NS + "selectItemPriceSize",itemCode);
		
	}

}
