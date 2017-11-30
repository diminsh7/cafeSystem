<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>발주품목관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/itemList">발주품목(전체리스트)</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/insertItem">발주품목(등록)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>발주품목상세조회</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>품목코드</th>
									<th>품목카테고리명</th>
									<th>품목명</th>
									<th>품목용량</th>
									<th>품목원가</th>
									<th>품목마진</th>
									<th>품목가격</th>
									<th>품목상세</th>
									<th>품목이미지</th>
									<th>발주가능여부</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${item.itemCode}</td>
									<td>${item.categorySmall}</td>
									<td>${item.itemName}</td>
									<td>${item.itemSize}</td>
									<td>${item.itemCost}</td>
									<td>${item.itemProfit}</td>
									<td>${item.itemPrice}</td>
									<td>${item.itemDetail}</td>
									<td>${item.itemImage}</td>
									<td>${item.itemAble}</td>
								</tr>
							</tbody>
						</table>
						<a class="btn btn-default" href="${pageContext.request.contextPath}/updateItem?itemCode=${item.itemCode}">수정</a>
						<a class="btn btn-default" href="${pageContext.request.contextPath}/deleteItem?itemCode=${item.itemCode}">삭제</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
