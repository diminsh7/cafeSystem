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
				<h3>메뉴관리</h3>
			</div>
		</div>

		<div class="clearfix"></div>

		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>메뉴 원가 관리 <small></small></h2>

						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<p class="text-muted font-13 m-b-30"></p>
						메뉴 원가 리스트 
				<%-- 		<form name="search" method="post" action="${pageContext.request.contextPath}/">
						<select name="searchOption">
							<!-- 검색조건을 검색처리후 결과화면에 보여주기위해  c:out 출력태그 사용, 삼항연산자 -->
							<option value="all"
								<c:out value="${searchOption == 'all'?'selected':''}"/>>관련검색어</option>
							<option value="account_title_name"
								<c:out value="${searchOption == 'branch_employee_code'?'selected':''}"/>>직원코드</option>
							<option value="account_title_content"
								<c:out value="${searchOption == 'branch_employee_name'?'selected':''}"/>>이름</option>
							<option value="account_title_content"
								<c:out value="${searchOption == 'position_category_code'?'selected':''}"/>>직급</option>
						</select> 
						<input name="keyword" value="${keyword}"> <input type="submit" value="조회">
					</form> --%>
											
					
						<table id="datatable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>메뉴명</th>
									<th>사이즈</th>
									<th>품목코드</th>
									<th>Hot/Ice</th>
									<th>단위(ml,g)</th>
									<th>단가</th>
									<th>수정</th>
									<th>삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="menu" items="${materialList}">
									<tr>
										<td>${menu.menuName}</td>
										<td>${menu.sizecate}</td>
										<td>${menu.itemName}</td>
										<td>${menu.tempcate}</td>
										<td>${menu.materialMeasure}</td>
										<td>${menu.materialCost}</td>
										<td><a href="${pageContext.request.contextPath}/updateMaterial?materialCode=${menu.materialCode}">수정</a></td>
										<td><a onclick="deleteb()" id="DeleteButton" href="${pageContext.request.contextPath}/deleteMaterial?materialCode=${menu.materialCode}">삭제</a></td>
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