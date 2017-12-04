<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>매장기초정보관리</h3>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/shopList">매장(전체리스트)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>매장등록</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form id="shopInsertForm" action="${pageContext.request.contextPath}/insertShop" method="post"
							class="form-horizontal form-label-left" novalidate>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">지역코드<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select id="localCategoryCode" name="localCategoryCode">
										<c:forEach var="ShopCategoryLocal" items="${CategoryLocalList}">
											<option value='${ShopCategoryLocal.categoryCode}'>${ShopCategoryLocal.categorySmall}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">계약코드<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select id="contractCode" name="contractCode">
										<c:forEach var="ShopContractCode" items="${ContractCodeList}">
											<option>${ShopContractCode.contractCode}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">점포명<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopName"
										class="form-control col-md-7 col-xs-12"
										name="shopName" type="text">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">점포주소<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopAddress"
										class="form-control col-md-7 col-xs-12"
										name="shopAddress" type="text">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">점포연락처<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopCall"
										class="form-control col-md-7 col-xs-12"
										name="shopCall" type="text" placeholder="ex)00-000-0000">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">점포우편번호<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopPostcode"
										class="form-control col-md-7 col-xs-12"
										name="shopPostcode" type="text">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">점포규모<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopSize"
										class="form-control col-md-7 col-xs-12"
										name="shopSize" type="text">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<a type="submit" class="btn btn-primary" href="${pageContext.request.contextPath}/shopList">취소</a>
									<button id="send" type="submit" class="btn btn-success">등록</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
