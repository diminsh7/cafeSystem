<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<h3>본사인사관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/headEmployeeList">목록</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/insertFormHeadEmployee">직원등록</a>
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
					<div class="x_content">
						<table id="datatable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>직원코드</th>
									<th>부서명</th>
									<th>아이디</th>
									<th>이름</th>
									<th>생년월일</th>
									<th>연락처</th>
									<th>주소</th>
									<th>입사일</th>
									<th>월급</th>
									<th>상여금</th>
									<th>월급계좌번호</th>
									<th>근로계약서</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${headEmployeeDetail.headEmployeeCode}</td>
									<td>${headEmployeeDetail.cateDepartment}</td>
									<td>${headEmployeeDetail.headEmployeeId}</td>
									<td>${headEmployeeDetail.headEmployeeName}</td>
									<td>${headEmployeeDetail.headEmployeeBirth}</td>
									<td>${headEmployeeDetail.headEmployeePhone}</td>
									<td>${headEmployeeDetail.headEmployeeAddress}</td>
									<td>${headEmployeeDetail.headEmployeeJoin}</td>
									<td>${headEmployeeDetail.headEmployeeSalary}</td>
									<td>${headEmployeeDetail.cateBonus}</td>
									<td>${headEmployeeDetail.headEmployeeBanknum}</td>
									<td>${headEmployeeDetail.headEmployeeContract}</td>
								</tr>
							</tbody>
						</table>
						<a class="btn btn-default" href="${pageContext.request.contextPath}/headEmployeeUpdate?headEmployeeCode=${headEmployeeDetail.headEmployeeCode}">수정</a>
						<a class="btn btn-default" onclick="deleteb()" id="DeleteButton" href ="${pageContext.request.contextPath}/headEmployeeDelete?headEmployeeCode=${headEmployeeDetail.headEmployeeCode}">삭제</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>