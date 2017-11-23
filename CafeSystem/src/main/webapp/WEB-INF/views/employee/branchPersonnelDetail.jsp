<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
$(document).click(function button_click(){
	if (confirm("한번 삭제하면 다시 생성할 수 없습니다.") == true){    //삭제처리
		document.$('#DeleteButton').submit();
	}else{   
 		return false; //삭제 취소
	}
});
</script>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>지점인사관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/branchPersonnelList">목록</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/insertformbranchPersonneel">점주등록</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>선택직원상세조회</h2>
						<div class="clearfix"></div>
					</div>
					 <c:forEach var="Detail" items="${branchPersonnelDetail}">
					<div class="x_content">
						<table id="datatable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>직원코드</th>
									<th>직급명</th>
									<th>아이디</th>
									<th>이름</th>
									<th>생년월일</th>
									<th>연락처</th>
									<th>주소</th>
									<th>보건증</th>
									<th>입사일</th>
									<th>월급</th>
									<th>월급계좌은행명</th>
									<th>월급계좌번호</th>
									<th>근로계약서</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${Detail.branchEmployeeCode}</td>
									<td>${Detail.categorySmall}</td>
									<td>${Detail.branchEmployeeId}</td>
									<td>${Detail.branchEmployeeName}</td>
									<td>${Detail.branchEmployeeBirth}</td>
									<td>${Detail.branchEmployeePhone}</td>
									<td>${Detail.branchEmployeeAddress}</td>
									<td>${Detail.branchEmployeeCetificate}</td>
									<td>${Detail.branchPersonnelJoin}</td>
									<td>${Detail.branchPersonnelSalary}</td>
									<td>${Detail.branchPersonnelBank}</td>
									<td>${Detail.branchPersonnelBanknum}</td>
									<td>${Detail.branchPersonnelContract}</td>
								</tr>
							</tbody>
						</table>
						<a class="btn btn-default" href="${pageContext.request.contextPath}/updateBranchPersonnel?branchEmployeeCode=${Detail.branchEmployeeCode}">수정</a>
						<a class="btn btn-default" onclick="button_click()" id="DeleteButton" href ="${pageContext.request.contextPath}/deleteBranchPersonnel?branchEmployeeCode=${Detail.branchEmployeeCode}">삭제</a>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>