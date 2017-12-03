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
							<thead>
								<tr>
									<th>직원코드</th>
									<th>점포명</th>
									<th>아이디</th>
									<th>이름</th>
									<th>생년월일</th>
									<th>연락처</th>
									<th>주소</th>
									<th>보건증</th>
									<th>사업자번호</th>
									<th>사업시작일</th>
									<th>사업계좌은행명</th>
									<th>사업계좌</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${branchManager.branchEmployeeCode}</td>
									<td>${branchManager.shopName}</td>
									<td>${branchManager.branchEmployeeId}</td>
									<td>${branchManager.branchEmployeeName}</td>
									<td>${branchManager.branchEmployeeBirth}</td>
									<td>${branchManager.branchEmployeePhone}</td>
									<td>${branchManager.branchEmployeeAddress}</td>
									<td>${branchManager.branchEmployeeCetificate}</td>
									<td>${branchManager.branchManagerWorknum}</td>
									<td>${branchManager.branchManagerStart}</td>
									<td>${branchManager.branchManagerBank}</td>
									<td>${branchManager.branchManagerBanknum}</td>
								</tr>
							
							</tbody>
						</table>
						<a class="btn btn-default" href="${pageContext.request.contextPath}/updateBranchManager?branchEmployeeCode=${Detail.branchEmployeeCode}">수정</a>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>