<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>店舗ネットワーク</h2>
						<div class="clearfix"></div>
					</div>
					<form action="./branchCallList" method="post" name="search">
						<select name="searchOption">
							<option value="all"
								<c:out value="${searchOption == 'all'?'selected':''}"/>>店舗名+店舗住所</option>
							<option value="shop_name"
								<c:out value="${map.searchOption == 'shopName'?'selected':''}"/>>店舗名</option>
							<option value="shop_address"
								<c:out value="${map.searchOption == 'shopAddress'?'selected':''}"/>>店舗住所</option>
						</select>
						<input name="keyword" value="${keyword}">
						<input type="submit" value="照会">
					</form>
					<div class="x_content">
						<p class="text-muted font-13 m-b-30">.</p>
						<div align="right">店舗数 : ${branchCallCount}</div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>店長</th>
									<th>店舗名</th>
									<th>店舗住所</th>
									<th>店舗連絡先</th>
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
									href="${pageContext.request.contextPath}/branchCallList?currentPage=${currentPage-1}">Prev</a></li>
							</c:if>
							<c:if test="${currentPage < lastPage}">
								<li class="next"><a
									href="${pageContext.request.contextPath}/branchCallList?currentPage=${currentPage+1}">Next</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
