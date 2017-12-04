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
			<div class="col-md-6 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>계약서상세조회</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form class="form-horizontal form-label-left">
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">계약코드</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${contract.contractCode}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">소유자명</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${contract.contractOwnerName}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">점포명</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${contract.contractShopName}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">소유자연락처</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${contract.contractOwnerPhone}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">계약일</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${contract.contractStartDate}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">계약만료일</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${contract.contractEndDate}</div>
									</div>
								</div>
								<%-- <div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">계약서사진</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${contract.contractPhoto}</div>
									</div>
								</div> --%>
							</form>
						</div>
					</div>
				<a class="btn btn-warning" href="${pageContext.request.contextPath}/updateContract?contractCode=${contract.contractCode}">수정</a>
				<a class="btn btn-danger" href="${pageContext.request.contextPath}/deleteContract?contractCode=${contract.contractCode}">삭제</a>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
