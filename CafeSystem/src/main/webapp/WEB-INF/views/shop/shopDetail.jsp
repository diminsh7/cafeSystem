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
						<h2>매장상세조회</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table id="datatable" class="table table-striped table-bordered">
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
								<tr>
									<td>${shop.contractCode}</td>
									<td>${shop.contractOwnerName}</td>
									<td>${shop.shopName}</td>
									<td>${shop.shopAddress}</td>
									<td>${shop.shopCall}</td>
									<td>${shop.shopPostcode}</td>
									<td>${shop.shopSize}</td>
								</tr>
							</tbody>
						</table>
						<a class="btn btn-default" href="${pageContext.request.contextPath}/updateShop?contractCode=${shop.contractCode}">수정</a>
						<a class="btn btn-default" href="${pageContext.request.contextPath}/deleteShop?contractCode=${shop.contractCode}">삭제</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
