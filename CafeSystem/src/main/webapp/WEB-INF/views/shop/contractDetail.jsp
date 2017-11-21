<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>계약서관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/contractList">전체계약서 리스트</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/insertContract">계약서 등록</a>
			</div>
			<div class="title_right">
				<div
					class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search for..."> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button">Go!</button>
						</span>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>계약서상세조회</h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
							</li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-expanded="false"><i
									class="fa fa-wrench"></i></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">Settings 1</a></li>
									<li><a href="#">Settings 2</a></li>
								</ul></li>
							<li><a class="close-link"><i class="fa fa-close"></i></a></li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table id="datatable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>계약코드</th>
									<th>소유자명</th>
									<th>점포명</th>
									<th>소유자연락처</th>
									<th>계약일</th>
									<th>계약만료일</th>
									<th>계약서사진 파일작업보류!</th>
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
						<a class="btn btn-default" href="${pageContext.request.contextPath}/updateContract?contractCode=${contract.contractCode}">수정</a>
						<a class="btn btn-default" href="${pageContext.request.contextPath}/deleteContract?contractCode=${contract.contractCode}">삭제</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
