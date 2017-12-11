package com.caffeesys.cafesystem.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.caffeesys.cafesystem.CommonService;
import com.caffeesys.cafesystem.employee.controller.AllService;
import com.caffeesys.cafesystem.login.service.LoginVO;

@Service
public class BranchOrderRequestService {

	//System.out.println("");
	@Autowired
	private HttpServletResponse response;
	
	@Autowired
	private BranchOrderRequestDao RequestDao;
	
	@Autowired
	private AllService allService;
	
	@Autowired
	CommonService commonService;

	
	//발주리스트 & 권한 확인
	public List<BranchOrderRequestVO> selectBranchOrderRequestList(Model model,HttpSession session, String cate, String input) throws IOException{
		System.out.println("BranchOrderRequestService.seleteBranchOrderRequestList 실행");
		System.out.println("session : " + session.getAttribute("loginInfo"));
		Object se = session.getAttribute("loginInfo");
		if(se != null) {
			LoginVO login = (LoginVO) session.getAttribute("loginInfo");
			System.out.println("login.getPosition() : " + login.getPosition());
			if(login.getPosition().equals("201") || login.getPosition().equals("202")) {
				System.out.println("점주 또는 매니져 권한으로 발주주문내역 확인 가능");
				Map<String, String> map;
				if(cate != "") {
					map = new HashMap<String, String>();
					map.put("cate", cate);
					map.put("input", input);
				} else {
					map = null;
				}
				
				map = allService.paging(model,map);
				
				String branchEmployeeCode = login.getEmpCode();
				BranchOrderRequestVO localShopCode = RequestDao.selectLocalShopCode(branchEmployeeCode); //지역 매장코드 구하기
				List<BranchOrderRequestVO> orderRequestList = RequestDao.selectOderRequestList(localShopCode,map); 
				
				// 전표번호에 대한 총 합계 구하기
				for(int i = 0; i < orderRequestList.size(); i++) {
					String statementNumber = orderRequestList.get(i).getStatementNumber();
					System.out.println("statementNumber : " + statementNumber);
					List<HashMap<String,Object>> price = RequestDao.selectPrice(statementNumber); //한 전표번호 물품 각각의 발주금액
					System.out.println("price : " + price);
					//포문 하다더 만들기 한전표번호에 대해 여러개
					int total = 0;
					for(int j = 0; j < price.size(); j++ ) {
						Integer sum = (Integer) price.get(j).get("order_price");
						total = total + sum;
						int cal = orderRequestList.get(i).setCal(total);
						orderRequestList.get(i).setCalComma(commonService.comma(cal));
					}
				};
				System.out.println("orderRequestList : " + orderRequestList);
				
				return orderRequestList;
				
			}else{
				System.out.println("점주 또는 매니져 권한미달로 발주주문내역 확인 불가능");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('각 지점의 점주,매니져만 확인이 가능합다.'); history.go(-1);</script>");
				out.flush();
			}
		}else {
			System.out.println("로그인이 되어 있지 않음");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인이 되어 있지 않습니다.'); history.go(-1);</script>");
			out.flush();
		}
		return null;
	}
	
	
	//상세조회보여질 합계구하기
	public  List<BranchOrderRequestVO> selectOrderRequestDetail(String statementNumber) {
		 List<BranchOrderRequestVO> orderDetail = RequestDao.selectOrderRequestDetail(statementNumber);
		System.out.println("orderDetail : "+orderDetail);
		return orderDetail;
	}
}