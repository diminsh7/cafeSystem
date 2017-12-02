<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>가맹계약서관리</h3>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/contractList">계약서(전체리스트)</a>
				<a class="btn btn-success" href="${pageContext.request.contextPath}/insertContract">계약서(등록)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>계약서상세조회</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>계약코드</th>
									<th>소유자명</th>
									<th>점포명</th>
									<th>소유자연락처</th>
									<th>계약일</th>
									<th>계약만료일</th>
									<th>계약서사진</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${contract.contractCode}</td>
									<td>${contract.contractOwnerName}</td>
									<td>${contract.contractShopName}</td>
									<td>${contract.contractOwnerPhone}</td>
									<td>${contract.contractStartDate}</td>
									<td>${contract.contractEndDate}</td>
									<td>${contract.contractPhoto}</td>
								</tr>
							</tbody>
						</table>
						<a class="btn btn-warning" href="${pageContext.request.contextPath}/updateContract?contractCode=${contract.contractCode}">수정</a>
						<a class="btn btn-danger" href="${pageContext.request.contextPath}/deleteContract?contractCode=${contract.contractCode}">삭제</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
