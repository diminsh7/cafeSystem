<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>매장연락망관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/branchCallList">매장연락망(전체리스트)</a> 
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>매장연락망전체조회</h2>
						<form action="./branchCallList" method="post" name="search">
							<select name="searchOption">
								<option value="all"
									<c:out value="${searchOption == 'all'?'selected':''}"/>>점포명+점포주소</option>
								<option value="shop_name"
									<c:out value="${map.searchOption == 'shopName'?'selected':''}"/>>점포명</option>
								<option value="shop_address"
									<c:out value="${map.searchOption == 'shopAddress'?'selected':''}"/>>점포주소</option>
							</select> <input name="keyword" value="${keyword}"> <input
								type="submit" value="조회">
						</form>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<p class="text-muted font-13 m-b-30">.</p>
						<div align="right">전체행의 수 : ${branchCallCount}</div>
						<table id="datatable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>소유자명</th>
									<th>점포명</th>
									<th>점포주소</th>
									<th>점포연락처</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="shop" items="${branchCallList}">
									<tr>
										<td>${shop.contractOwnerName}</td>
										<td>${shop.shopName}</td>
										<td>${shop.shopAddress}</td>
										<td>${shop.shopCall}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<ul class="pager">
							<c:if test="${currentPage > 1}">
								<li class="previous"><a
									href="${pageContext.request.contextPath}/branchCallList?currentPage=${currentPage-1}">이전</a></li>
							</c:if>
							<c:if test="${currentPage <= lastPage}">
								<li class="next"><a
									href="${pageContext.request.contextPath}/branchCallList?currentPage=${currentPage+1}">다음</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
