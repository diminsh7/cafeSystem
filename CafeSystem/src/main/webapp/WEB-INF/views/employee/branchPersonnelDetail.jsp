<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
function deleteb(){
	if (confirm("한번 삭제하면 다시 생성할 수 없습니다.") == true){  //삭제처리
		document.$('#DeleteButton').submit();
	}else{   
			return false; //삭제 취소
	};
};
</script>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>지점인사관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/branchPersonnelList">목록</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/insertformbranchPersonneel">직원등록</a>
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
						
								<tr>
									<th>직원코드</th>
									<td>${Detail.branchEmployeeCode}</td>
								</tr>
								<tr>	
									<th>직급명</th>
									<td>${Detail.categorySmall}</td>
								</tr>
								<tr>
									<th>아이디</th>
									<td>${Detail.branchEmployeeId}</td>
								</tr>
								<tr>	
									<th>이름</th>
									<td>${Detail.branchEmployeeName}</td>
								</tr>
								<tr>	
									<th>생년월일</th>
									<td>${Detail.branchEmployeeBirth}</td>
								</tr>
								<tr>	
									<th>연락처</th>
									<td>${Detail.branchEmployeePhone}</td>
								</tr>
								<tr>	
									<th>주소</th>
									<td>${Detail.branchEmployeeAddress}</td>
								</tr>
								<tr>	
									<th>보건증</th>
									<td>${Detail.branchEmployeeCetificate}</td>
								</tr>
								<tr>	
									<th>입사일</th>
									<td>${Detail.branchPersonnelJoin}</td>
								</tr>
								<tr>	
									<th>월급</th>
									<td>${Detail.branchPersonnelSalary}</td>
								</tr>
								<tr>	
									<th>월급계좌은행명</th>
									<td>${Detail.branchPersonnelBank}</td>
								</tr>
								<tr>
									<th>월급계좌번호</th>
									<td>${Detail.branchPersonnelBanknum}</td>
								</tr>
								<tr>
									<th>근로계약서</th>
									<td>${Detail.branchPersonnelContract}</td>
								</tr>
							
						</table>
						<a class="btn btn-default" href="${pageContext.request.contextPath}/updateBranchPersonnelForm?branchEmployeeCode=${Detail.branchEmployeeCode}">수정</a>
						<a class="btn btn-default" onclick="deleteb()" id="DeleteButton" href ="${pageContext.request.contextPath}/deleteBranchPersonnel?branchEmployeeCode=${Detail.branchEmployeeCode}">삭제</a>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>