<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>발주관리</h3>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>선택전표 상세조회</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table id="datatable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>전표번호</th>
									<th>발주상태</th>
									<th>품명명</th>
									<th>수량</th>
									<th>가격</th>
									<th>발주금액</th>
									<th>신청일</th>
									<th>승인일</th>
									<th>출고일</th>
									<th>접수상태</th>
									<th>배송상태</th>
									<th>승인담당장</th>
									<th>불량여부</th>
									<th>불량신청</th>

								</tr>
							</thead>
							<tbody>
							 <c:forEach var="detail" items="${orderDetail}">
								<tr>
									<td>${detail.statementNumber}</td><!-- 전표번호 -->
									<td>${detail.divideName}</td><!-- 발주상태 -->
									<td>${detail.itemName}</td><!-- 품목명 -->
									<td>${detail.orderAmount}</td><!-- 수량 -->
									<td>${detail.orderPrice}</td><!-- 가격 -->
									<td>${detail.cal}</td><!-- 발주금액 -->
									<td>${detail.orderRequest}</td><!-- 신청일 -->
									<td>${detail.orderApproval}</td><!-- 승인일 -->
									<td>${detail.orderRelease}</td><!-- 출고일 -->
									<td>${detail.cateReceipt}</td><!-- 접수상태 -->
									<td>${detail.cateOrder}</td><!-- 배송상태 -->
									<td>${detail.headName}</td><!-- 승인담당장 -->
									<td>${detail.orderFaultyAble}</td><!-- 불량여부 -->
									<td><a href="${pageContext.request.contextPath}/?ordercode=${detail.orderCode}">불량신청</a></td>
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