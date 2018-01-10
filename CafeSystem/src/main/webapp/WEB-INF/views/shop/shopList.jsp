<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>
					店舗基礎情報管理
					<a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/shopList">店舗リスト</a> 
					<a class="btn btn-success btn-sm" href="${pageContext.request.contextPath}/insertShop">店舗登録</a>
				</h3>			
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>店舗情報照会 <small>* 契約コードをクリックして詳細照会</small></h2>
						<div class="clearfix"></div>
					</div>
					<form action="./shopList" method="post" name="search">
						<select name="searchOption">
							<option value="all"
								<c:out value="${searchOption == 'all'?'selected':''}"/>>店舗名+店舗住所</option>
							<option value="shop_name"
								<c:out value="${map.searchOption == 'shopName'?'selected':''}"/>>店舗名</option>
							<option value="contract_owner_name"
									<c:out value="${map.searchOption == 'contractOwnerName'?'selected':''}"/>>所有主名</option>
							<option value="shop_address"
								<c:out value="${map.searchOption == 'shopAddress'?'selected':''}"/>>店舗住所</option>
						</select>
						<input name="keyword" value="${keyword}"> 
						<input type="submit" value="検索">
					</form>
					<div class="x_content">
						<div align="right">店舗数 : ${shopCount}</div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>契約コード</th>
									<th>店舗名</th>
									<th>所有主名</th>
									<th>店舗住所</th>
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
									href="${pageContext.request.contextPath}/shopList?currentPage=${currentPage-1}">Prev</a></li>
							</c:if>
							<c:if test="${currentPage < lastPage}">
								<li class="next"><a
									href="${pageContext.request.contextPath}/shopList?currentPage=${currentPage+1}">Next</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
