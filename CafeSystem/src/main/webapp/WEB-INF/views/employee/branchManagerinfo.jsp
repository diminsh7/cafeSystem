<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <!DOCTYPE html> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 
 <div class="right_col" role="main">
 	<div class="">
 		<div class="page-title">
 			<div class="title_left">
 				<h3>점주 신상 정보</h3>
 			</div>
 
 		</div>
 		<div class="clearfix"></div>
 		<div class="row">
 			<div class="col-md-12 col-sm-12 col-xs-12">
 				<div class="x_panel">
 					<div class="x_title">
 						<h2>점주 신상 정보</h2>
 						
 						<div class="clearfix"></div>
 					</div>
 					 <c:forEach var="branchManager" items="${branchManager}">
 					<div class="x_content">
 						<table id="datatable" class="table table-striped table-bordered">
 							
 								<tr>
 									<th>직원코드</th>
 									<td>${branchManager.branchEmployeeCode}</td>
 								</tr>
 								<tr>	
 									<th>점포명</th>
 									<td>${branchManager.shopName}</td>
 								</tr>
 								<tr>	
 									<th>아이디</th>
 									<td>${branchManager.branchEmployeeId}</td>
 								</tr>
 								<tr>	
 									<th>이름</th>
 									<td>${branchManager.branchEmployeeName}</td>
 								</tr>
 								<tr>	
 									<th>생년월일</th>
 									<td>${branchManager.branchEmployeeBirth}</td>
 								</tr>
 								<tr>	
 									<th>연락처</th>
 									<td>${branchManager.branchEmployeePhone}</td>
 								</tr>
 								<tr>	
 									<th>주소</th>
 									<td>${branchManager.branchEmployeeAddress}</td>
 								</tr>
 								<tr>	
 									<th>보건증</th>
 									<td>${branchManager.branchEmployeeCetificate}</td>
 								</tr>
 								<tr>	
 									<th>사업자번호</th>
 									<td>${branchManager.branchManagerWorknum}</td>
 								</tr>
 								<tr>	
 									<th>사업시작일</th>
 									<td>${branchManager.branchManagerStart}</td>
 								</tr>
 								<tr>	
 									<th>사업계좌은행명</th>
 									<td>${branchManager.branchManagerBank}</td>
 								</tr>
 								<tr>	
 									<th>사업계좌</th>
 									<td>${branchManager.branchManagerBanknum}</td>
 								</tr>
 							
 						</table>
 						<a class="btn btn-default" href="${pageContext.request.contextPath}/updateBranchManager?branchEmployeeCode=${Detail.branchEmployeeCode}">수정</a>
 				</div>
 				</c:forEach>
 				</div>
			</div>
		</div>
	</div>
</div> 