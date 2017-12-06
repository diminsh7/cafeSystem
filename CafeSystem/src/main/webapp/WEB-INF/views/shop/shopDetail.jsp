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
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/shopList">매장(전체리스트)</a>
				<a class="btn btn-success" href="${pageContext.request.contextPath}/insertShop">매장(등록)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-6 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>매장상세조회</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form class="form-horizontal form-label-left">
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">계약코드</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${shop.contractCode}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">소유자명</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${shop.contractOwnerName}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">점포명</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${shop.shopName}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">점포주소</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${shop.shopAddress}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">점포연락처</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${shop.shopCall}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">점포우편번호</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${shop.shopPostcode}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">점포규모</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${shop.shopSize}</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				<a class="btn btn-warning" href="${pageContext.request.contextPath}/updateShop?contractCode=${shop.contractCode}">수정</a>
				<a class="btn btn-danger" href="${pageContext.request.contextPath}/deleteShop?contractCode=${shop.contractCode}">삭제</a>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
