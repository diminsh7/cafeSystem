<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>발주관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/">발주신청</a>
			</div>
		</div>

		<div class="clearfix"></div>

		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>발주신청상세내역조회 <small></small></h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<p class="text-muted font-13 m-b-30"></p>
						상내역리스트
			
						<table id="datatable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>전표번호</th>
									<th>구분</th>
									<th>품목명</th>
									<th>수량</th>
									<th>가격</th>
									<th>발주금액</th>
									<th>현 접수 상태</th>
									<th>현 배송 상태</th>
									<th>신청일</th>
									<th>승인일</th>
									<th>출고일</th>
									<th>승인담당자</th>
									<th>불량여부</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="Detail" items="${orderDetail}">
									<tr>
										<td>${Detail.statementNumber}</td>
										<td>${Detail.orderFaultyDivide}</td>
										<td>${Detail.itemName}</td>
										<td>${Detail.orderAmount}</td>
										<td>${Detail.orderPrice}</td>
										<td>${Detail.cal}</td>
										<td>${Detail.cateReceipt}</td>
										<td>${Detail.cateOrder}</td>
										<td>${Detail.orderRequest}</td>
										<td>${Detail.orderApproval}</td>
										<td>${Detail.orderRelease}</td>
										<td>${Detail.headEmployeeCode}</td>
										<td>${Detail.orderFaultyAble}</td>
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
