<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<script>
	$(document).ready(function() {
		//검색 카테고리 선택에 따른 검색 기본 양식 제공
		$('#cate').change(function() {
			var cate = $('#cate').val();
			if (cate == 'menu_code') {
				$('#input').val('menu_');
			} else if (cate == 'menu_name') {
				$('#input').val('');
			}
		});

		//삭제 처리 전 삭제 확인
		$('#menuPriceDelete').click(function() {
			result = confirm('정말 삭제하시겠습니까?');
			if (result) {
				return true;
			} else {
				return false;
			}
		});
	});
</script>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>MenuPrice List <small>MenuPrice List</small></h3>
			</div>
			 <%-- <c:choose>			
				<c:when test="${cate != null}">
						<input type="hidden" id="cate" value="${cate}">
						<input type="hidden" id="input" value="${input}">
				</c:when>
				<c:otherwise> --%>
					<form id="menuPriceSearchForm "action="${pageContext.request.contextPath}/menuPriceList" method="post">
						<div class="title_right">
							<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								<select name="cate" id="cate" required class="input-sm">
									<option id="opt" value="${cate}" class="input-sm">검색 조건 선택</option>							
									<option value="menu_name" class="input-sm">메뉴명</option>
									<option value="menu_code" class="input-sm">메뉴코드</option>
								</select>
								<div class="input-group">
									<input type="text" name="input" id="input" value="${input}" required class="input-sm">
									<span class="input-group-btn">
										<input type="submit" class="btn btn-default" id="menuPriceSearchBtn" value="검색">
									</span>
								</div>
							</div>
						</div>
					</form>
			<%-- </c:otherwise>
			</c:choose> --%>
		</div>

		<div class="clearfix"></div>
		
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>Menu Price LIST <small>Menu Price</small></h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>no</th>
									<th>메뉴명</th>
									<th>구분</th>									
									<th>사이즈</th>
									<th>원가</th>
									<th>판매가</th>
									<th>수정</th>
									<th>삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="menuPriceList" items="${menuPriceList}">
									<tr>
										<td>${menuPriceList.menuPriceCode}</td>
										<td>${menuPriceList.menuName}</td>
										<td>${menuPriceList.tempCateName}</td>									
										<td>${menuPriceList.sizeCateName}</td>
										<td>${menuPriceList.menuTotalCost}</td>
										<td>${menuPriceList.menuSellCost}</td>
										<td><a id="menuPriceUpdate" href="${pageContext.request.contextPath}/menuPriceUpdate?menuPriceCode=${menuPriceList.menuPriceCode}">수정</a></td>
										<td><a id="menuPriceDelete" href="${pageContext.request.contextPath}/menuPriceDelete?menuPriceCode=${menuPriceList.menuPriceCode}">삭제</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<c:import url="/WEB-INF/views/layout/paging.jsp" />
						<div>
							<a class="btn btn-default" href="${pageContext.request.contextPath}/menuPriceInsert">메뉴 가격 등록</a>
						</div>
					</div>	
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
