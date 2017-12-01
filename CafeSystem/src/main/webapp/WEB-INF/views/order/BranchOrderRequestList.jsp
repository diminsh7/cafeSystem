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
						<h2>발주신청내역조회 <small></small></h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<p class="text-muted font-13 m-b-30"></p>
						신청내역리스트				
						<table id="datatable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>전표번호</th>
									<th>총가격</th>
									<th>제품명</th>
									<th>접수상태</th>
									<th>신청일</th>
									<th>배송상태</th>
									<th>발주승인 담당자</th>
									<th>발주/불량구분</th>
									<th>불량여부</th>
									<th>환불 신청</th>
									<th>취소 신청</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="request" items="${orderRequestList}">
									<tr>
										<td><a href="${pageContext.request.contextPath}/BranchOrderRequestDetail?orderCode=${request.orderCode}">${request.statementNumber}</a></td>
										<td>${request.cal}</td>
										<td>${request.itemName}</td>
										<td>${request.cateReceipt}</td>
										<td>${request.orderRequest}</td>
										<td>${request.cateOrder}</td>
										<td>${request.headName}</td>
										<td>${request.divideName}</td>
										<td>${request.orderFaultyAble}</td>
										<td><a href="">환불신청</a></td>
										<td><a href="">취소신청</a></td>
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