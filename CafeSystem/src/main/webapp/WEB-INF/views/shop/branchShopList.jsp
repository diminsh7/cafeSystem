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
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/branchContractList">계약서정보(리스트)</a>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/branchShopList">매장정보(리스트)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>매장상세조회</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>계약코드</th>
									<th>소유자명</th>
									<th>점포명</th>
									<th>점포주소</th>
									<th>점포연락처</th>
									<th>점포우편번호</th>
									<th>점포규모</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="shop" items="${shopList}">
									<tr>
										<td>${shop.contractCode}</td>
										<td>${shop.contractOwnerName}</td>
										<td>${shop.shopName}</td>
										<td>${shop.shopAddress}</td>
										<td>${shop.shopCall}</td>
										<td>${shop.shopPostcode}</td>
										<td>${shop.shopSize}</td>
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
<!-- /page content -->
