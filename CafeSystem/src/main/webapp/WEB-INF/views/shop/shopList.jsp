<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>매장기초정보관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/shopList">매장(전체리스트)</a> 
				<a class="btn btn-default" href="${pageContext.request.contextPath}/insertShop">매장(등록)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>매장전체조회</h2>
						<div class="clearfix"></div>
					</div>
					<form action="./shopList" method="post" name="search">
						<select name="searchOption">
							<option value="all"
								<c:out value="${searchOption == 'all'?'selected':''}"/>>점포명+점포주소</option>
							<option value="shop_name"
								<c:out value="${map.searchOption == 'shopName'?'selected':''}"/>>점포명</option>
							<option value="contract_owner_name"
									<c:out value="${map.searchOption == 'contractOwnerName'?'selected':''}"/>>소유자명</option>
							<option value="shop_address"
								<c:out value="${map.searchOption == 'shopAddress'?'selected':''}"/>>점포주소</option>
						</select>
						<input name="keyword" value="${keyword}"> 
						<input type="submit" value="조회">
					</form>
					<div class="x_content">
						<p class="text-muted font-13 m-b-30">계약코드클릭-상세조회</p>
						<div align="right">전체행의 수 : ${shopCount}</div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>계약코드</th>
									<th>점포명</th>
									<th>소유자명</th>
									<th>점포주소</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="shop" items="${shopList}">
									<tr>
										<td><a
											href="${pageContext.request.contextPath}/shopDetail?contractCode=${shop.contractCode}">${shop.contractCode}</a></td>
										<td>${shop.shopName}</td>
										<td>${shop.contractOwnerName}</td>
										<td>${shop.shopAddress}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<ul class="pager">
							<c:if test="${currentPage > 1}">
								<li class="previous"><a
									href="${pageContext.request.contextPath}/shopList?currentPage=${currentPage-1}">이전</a></li>
							</c:if>
							<c:if test="${currentPage < lastPage}">
								<li class="next"><a
									href="${pageContext.request.contextPath}/shopList?currentPage=${currentPage+1}">다음</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
