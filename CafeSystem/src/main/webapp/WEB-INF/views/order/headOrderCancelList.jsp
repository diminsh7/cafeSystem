<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>Order Cancel LIST <small>for Head Office</small></h3>
			</div>
			<form id="orderCancelSearchForm "action="${pageContext.request.contextPath}/menuPriceList" method="post">
				<div class="title_right">
					<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
						<select name="cate" id="cate" required class="input-sm">
							<option id="opt" value="${cate}" class="input-sm">검색 조건 선택</option>							
							<option value="menu_name" class="input-sm">메뉴명</option>
							<option value="menu_code" class="input-sm">메뉴코드</option>
						</select>
						<div class="input-group">
							<input type="text" name="input" id="input" value="${input}" required class="input-sm">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-default" id="orderCancelSearchBtn" value="검색">
							</span>
						</div>
					</div>
				</div>
			</form>
		</div>

		<div class="clearfix"></div>
		
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>전표번호<small>를 클릭하여 상세조회 및 취소승인, 환불</small></h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>전표번호</th>
									<th>접수상태</th>									
									<th>취소신청일</th>
									<th>취소승인일</th>
									<th>취소승인 담당자</th>
									<th>환불여부</th>
									<th>환불 전표번호</th>
									<th>환불일</th>
									<th>환불승인 담당자</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="headOrderCancelList" items="${headOrderCancelList}">
									<tr>
										<td><a href="${pageContext.request.contextPath}/headOrderDetail?statementNumber=${headOrderCancelList.statementNumber}">${headOrderCancelList.statementNumber}</a></td>
										<td>${headOrderCancelList.receiptCateName}</td>
										<td>${headOrderCancelList.orderCancelRequest}</td>									
										<td>${headOrderCancelList.orderCancelApproval}</td>
										<td>${headOrderCancelList.headEmployeeCode}</td>
										<td>${headOrderCancelList.orderRefundAble}</td>
										<td>${headOrderCancelList.orderRefundStatement}</td>
										<td>${headOrderCancelList.orderRefundDate}</td>
										<td>${headOrderCancelList.orderRefundAdmin}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<c:import url="/WEB-INF/views/layout/paging.jsp" />
					</div>	
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>