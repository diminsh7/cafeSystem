<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>지점인사관리</h3>
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>점주 리스트 <small></small></h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">  </p>
                     	전 매장별 점주 리스트[직원 코드 클릭 시 상세자료 확인 가능]
                     	<form name="search" method="post" action="${pageContext.request.contextPath}/branchManagerList">
							<select name="searchOption">
								<!-- 검색조건을 검색처리후 결과화면에 보여주기위해  c:out 출력태그 사용, 삼항연산자 -->
								<option value="all"
									<c:out value="${searchOption == 'all'?'selected':''}"/>>관련검색어</option>
								<option value="account_title_name"
									<c:out value="${searchOption == 'branch_employee_code'?'selected':''}"/>>직원코드</option>
								<option value="account_title_content"
									<c:out value="${searchOption == 'branch_employee_name'?'selected':''}"/>>이름</option>
								<option value="account_title_content"
									<c:out value="${searchOption == 'shopName'?'selected':''}"/>>매장명</option>
							</select> 
							<input name="keyword" value="${keyword}"> <input type="submit" value="조회">
						</form>
					
					
                     <div align="right"> 총 점주 : ${branchManagerCount} 명</div>
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>직원코드</th>
                          <th>아이디</th>
                          <th>이름</th>
                          <th>생년월일</th>
                          <th>점포명</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach var="BMList" items="${branchManagerList}">
                      	<tr>
                          <td><a href="${pageContext.request.contextPath}/branchManagerDetail?branchEmployeeCode=${BMList.branchEmployeeCode}">${BMList.branchEmployeeCode}</a></td> 
                          <td>${BMList.branchEmployeeId}</td>
                          <td>${BMList.branchEmployeeName}</td>
                          <td>${BMList.branchEmployeeBirth}</td>
						  <td>${BMList.shopName}</td>
                        </tr>
                      </c:forEach>                            
                      </tbody>
                    </table>
                    
                  </div>
                </div>
              </div>
             </div>
            </div>
           </div>
           