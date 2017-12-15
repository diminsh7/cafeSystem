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
				<a class="btn btn-default" href="${pageContext.request.contextPath}/branchManagerList">목록</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/insertformbranchManager">점주등록</a>
			</div>

		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>점주상세조회</h2>
						
						<div class="clearfix"></div>
					</div>
					 <c:forEach var="Detail" items="${branchManagerDetail}">
					<div class="x_content">
						<table id="datatable" class="table table-striped table-bordered">
							
								<tr>
									<th>직원코드</th>
									<td>${Detail.branchEmployeeCode}</td>
								</tr>
 								<tr>	
									<th>점포명</th>
									<td>${Detail.shopName}</td>
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
									<th>사업자번호</th>
									<td>${Detail.branchManagerWorknum}</td>
								</tr>
 								<tr>	
									<th>사업시작일</th>
									<td>${Detail.branchManagerStart}</td>
								</tr>
 								<tr>	
									<th>사업계좌은행명</th>
									<td>${Detail.branchManagerBank}</td>
								</tr>
 								<tr>	
									<th>사업계좌</th>
									<td>${Detail.branchManagerBanknum}</td>
								</tr>
						</table>
						
						<a class="btn btn-default" href="${pageContext.request.contextPath}/updateBranchManager?branchEmployeeCode=${Detail.branchEmployeeCode}">수정</a>
						<a class="btn btn-default" onclick="deleteb()" id="DeleteButton" href ="${pageContext.request.contextPath}/deleteBranchManager?branchEmployeeCode=${Detail.branchEmployeeCode}">삭제</a>
						
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>