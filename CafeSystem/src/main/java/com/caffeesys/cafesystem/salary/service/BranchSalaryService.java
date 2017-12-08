package com.caffeesys.cafesystem.salary.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.caffeesys.cafesystem.account.controller.PasingService;
import com.caffeesys.cafesystem.employee.service.BranchPersonnelVO;
import com.caffeesys.cafesystem.login.service.LoginVO;
import com.google.gson.Gson;


@Service
public class BranchSalaryService {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	PasingService pasingService;
	
	@Autowired
	BranchSalaryDao branchSalaryDao;
	
	Gson gson = new Gson();
	
	private static final Logger logger = LoggerFactory.getLogger(BranchSalaryService.class);
	
	
	//급여명세서 상세데이터 보여주기위해 select
	public BranchSalaryVO selectBranchSalaryDetail(Model model, String branchSalaryCode) {
		logger.debug("selectBranchSalaryDetail메소드의 branchEmployeeCode :{}",branchSalaryCode);
		BranchSalaryVO branchSalary = branchSalaryDao.selectBranchSalaryDetail(branchSalaryCode);
		model.addAttribute("branchSalary",branchSalary);
		return branchSalary;
	}
	
	//급여명세서 수정하기위해 select
	public BranchSalaryVO selectBranchSalaryUpdate(Model model, String branchSalaryCode) {
		logger.debug("selectbranchSalaryUpdate메소드의 branchEmployeeCode :{}",branchSalaryCode);
		BranchSalaryVO branchSalary = branchSalaryDao.selectBranchSalaryDetail(branchSalaryCode);
		model.addAttribute("branchSalary",branchSalary);
		return branchSalary;
	}
	//급여명세서 수정 처리
	public void branchSalaryUpdate(BranchSalaryVO branchSalary) {
		logger.debug("branchSalaryInsert 메소드의 branchSalary :{}",branchSalary);
		branchSalaryDao.branchSalaryUpdate(branchSalary);
	}
	//검색한 급여명세서 list 
	public void branchSalaryList(Model model,String keyword1, String keyword2, int currentPage) {
		logger.debug("branchSalaryList메소드 확인");
		Map<String, String> map;
		if(keyword1 != null) {
			map = new HashMap<String, String>();
			map.put("keyword1", keyword1);
			map.put("keyword2", keyword2);			
		}else {
			map = null;
		}
		logger.debug("branchSalaryList 메소드의  map :{}",map);//{keyword=2017-09, searchOption=branch_salary_workmonth}
		map = pasingService.paging(model, currentPage, 10, branchSalaryDao.branchSalaryCount(map), map);
		logger.debug("branchSalaryList 메소드의  branchSalaryDao.branchSalaryCount(map) :{}",branchSalaryDao.branchSalaryList(map));
		model.addAttribute("branchSalaryCount",branchSalaryDao.branchSalaryCount(map));
		model.addAttribute("branchSalaryList",branchSalaryDao.branchSalaryList(map));
	}
	
	//지점 직원 급여명세서 등록 폼에 쓸 직원 코드 가져오는 메소드
	public void branchCodeList(Model model){
		logger.debug("branchCodeList메소드 확인");
		LoginVO loginInfo = (LoginVO)session.getAttribute("loginInfo");
		logger.debug("branchCodeList 메소드의 loginInfo :{}",loginInfo); //로그인 정보 갖고오기
		String empCode = loginInfo.getEmpCode();
		logger.debug("branchCodeList 메소드의 empCode :{}",empCode); //로그인 되어있는 직원코드 갖고오기
		List<LoginVO> branchCodeList = branchSalaryDao.branchCodeList(empCode);
		logger.debug("branchCodeList 메소드의 branchCodeList :{}",branchCodeList);
		model.addAttribute("branchCodeList", branchCodeList);	//로그인한 매장의 직원코드 갖고오기
	}	
	//삭제하기위해 login정보 갖고오기
	public String SelectLoginInfoForDelete() {
		logger.debug("SelectLoginInfoForDelete메소드 확인");
		LoginVO loginInfo = (LoginVO)session.getAttribute("loginInfo");
		logger.debug("SelectLoginInfoForDelete 메소드의 loginInfo :{}",loginInfo); //로그인 정보 갖고오기
		String empCode = loginInfo.getEmpCode();
		logger.debug("SelectLoginInfoForDelete 메소드의 empCode :{}",empCode);//로그인 되어있는 직원코드 갖고오기
		String pw=loginInfo.getPw();
		logger.debug("SelectLoginInfoForDelete 메소드의 pw :{}",pw);//로그인 되어있는 직원pw갖고오기
		List<String> loginList = new ArrayList<String>();
		loginList.add(empCode);
		loginList.add(pw);
		logger.debug("SelectLoginInfoForDelete 메소드 확인 :{}",loginList);
		return gson.toJson(loginList);
	}
	//삭제처리
	public void branchSalaryDelete(String branchSalaryCode) {
		branchSalaryDao.branchSalaryDelete(branchSalaryCode);
	}
	
	//지점직원 급여명세서 등록 폼에 쓸 직원 급여 가져오는 메소드 직원코드를 눌렀을때 자동으로 입력
	public String branchEmployeeSalaryInsert(String branchEmployeeCode) {		
		logger.debug("branchEmployeeSalaryInsert메소드 확인 map :{}",branchEmployeeCode);
		logger.debug("branchEmployeeSalaryInsert메소드 확인 :{}",gson.toJson(branchSalaryDao.branchEmployeeSalaryInsert(branchEmployeeCode)));
		return gson.toJson(branchSalaryDao.branchEmployeeSalaryInsert(branchEmployeeCode));
	}
	
	//지점직원 급여명세서코드 등록 처리 과정
	public void branchSalaryInsert(BranchSalaryVO branchSalary) {
		logger.debug("branchSalaryInsert 메소드의 branchSalary :{}",branchSalary);	
		
		//BranchSalaryWorkmonth 월로 갖고왔으니 data타입으로 변경 후 등록과정
		String BranchSalaryWorkmonth = branchSalary.getBranchSalaryWorkmonth(); //2017-10 
		BranchSalaryWorkmonth = BranchSalaryWorkmonth+"-01";	//2017-10-01
		branchSalary.setBranchSalaryWorkmonth(BranchSalaryWorkmonth);
		
		//전표번호 등록 과정
		String statementDate = branchSalaryDao.statementDate();	//날짜 get
		logger.debug("branchSalaryInsert 메소드 statementDate :{}", statementDate);
		String bEmployeeCode= branchSalary.getBranchEmployeeCode();	//선택직원 코드 get
		BranchPersonnelVO BranchPersonnel = branchSalaryDao.bEmployeeLocalShop(bEmployeeCode);//선택한 직원의 매장코드,shop코드 get
		String branchLocal = BranchPersonnel.getLocalCategoryCode();
		String branchShop= BranchPersonnel.getShopCode();
		String statementLocal = branchLocal+branchShop;
		String statementNumber = null;
		statementNumber = statementDate + "-" + statementLocal + "-A-";
		logger.debug("전표번효 :{}",statementNumber);	//171205-013001-A
		String result_statementMax = null;
		HashMap<String, Object> statementMax = branchSalaryDao.getStatementMax(statementNumber);	//전표번호 최대값
		logger.debug("------------------------------------------------------------------------------------------------------ statementMax :{}",statementMax);	
		if(statementMax == null) {
			logger.debug("branchSalaryInsert메소드의 statementMax :{}",statementMax);
			statementNumber = statementNumber + "01";
			logger.debug("branchSalaryInsert메소드의 statementMaxString :{}",statementNumber);			
		}else {
			int statementMaxInt= Integer.parseInt(statementMax.get("getStatementMax").toString());
			logger.debug("branchSalaryInsert메소드의 statementMaxInt0 :{}",statementMaxInt);	//1
			statementMaxInt = statementMaxInt+1;
			logger.debug("branchSalaryInsert메소드의 statementMaxInt1 :{}",statementMaxInt);	//2
			result_statementMax = String.format("%02d", statementMaxInt);
			logger.debug("branchSalaryInsert메소드의 result_statementMax :{}",result_statementMax);	//02
			statementNumber = statementNumber + result_statementMax;
			logger.debug("branchSalaryInsert메소드의 statementNumber :{}",statementNumber);		//171205-013001-A-02
		}
		branchSalary.setStatementNumber(statementNumber);	//branchSalary에 전표번호 set
		
		//지점직원 급여명세서코드 등록 과정
		int branchSalaryCodeMax;
		int branchSalaryCodeMidMax;
		int result = 0;
		int result2 = 0;
		String result_no = null;
		String result_no2 = null;
		String branchSalaryCode = null;
		String branch_salary_code = "_";
		String branch_salary_code2 = "bsalary_";
		
		branchSalaryCodeMax = branchSalaryDao.branchSalaryCodeMax();
		logger.debug("branchSalaryInsert메소드의 branchSalaryCodeMax:{}",branchSalaryCodeMax);
		branchSalaryCodeMidMax = branchSalaryDao.branchSalaryCodeMidMax();
		logger.debug("branchSalaryInsert메소드의 branchSalaryCodeMidMax:{}",branchSalaryCodeMidMax);

		
		if(branchSalaryCodeMax != 0 && branchSalaryCodeMax < 9999) {
			result = branchSalaryCodeMax;
			logger.debug("branchSalaryInsert 메소드 result1 :{}",result);//22
			result = result + 1;
			logger.debug("branchSalaryInsert 메소드 result2 :{}",result);//23
			result_no = String.format("%04d", result);	//자리수 맞추기
			logger.debug("branchSalaryInsert 메소드 result_no :{}",result_no);//0023		
			result2 = branchSalaryCodeMidMax;
			logger.debug("branchSalaryInsert 메소드 result2-1 :{}",result2);	//1
			result_no2 = String.format("%03d", result2);	//자리수 맞추기		
			logger.debug("branchSalaryInsert 메소드 result_no2 :{}",result_no2);//001			
		}else if(branchSalaryCodeMax == 9999) {
			result = branchSalaryCodeMax;
			logger.debug("branchSalaryInsert 메소드 result1 :{}",result);//9999
			result = result - 9998;
			logger.debug("branchSalaryInsert 메소드 result2 :{}",result);//1
			result_no = String.format("%04d", result);	//자리수 맞추기
			logger.debug("branchSalaryInsert 메소드 result_no :{}",result_no);//0001			
			result2 = branchSalaryCodeMidMax;
			logger.debug("branchSalaryInsert 메소드 result2-1 :{}",result2);	//1
			result2 = result2 + 1;
			logger.debug("branchSalaryInsert 메소드 result2-2 :{}",result2);	//2
			result_no2 = String.format("%03d", result2);	//자리수 맞추기		
			logger.debug("branchSalaryInsert 메소드 result_no2 :{}",result_no2);//002
		}		
		branchSalaryCode =branch_salary_code2 + result_no2 +branch_salary_code+ result_no;	//bsalary_001_0023
		logger.debug("branchSalaryInsert 메소드 bSalaryCode :{}",branchSalaryCode);	//bsalary_001_0023
		branchSalary.setBranchSalaryCode(branchSalaryCode);	
		logger.debug("branchSalaryInsert 메소드의 branchSalary :{}",branchSalary);
		branchSalaryDao.branchSalaryInsert(branchSalary);
	}
}
