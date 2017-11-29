<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>발주품목관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/itemList">발주품목(전체리스트)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>발주품목등록</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form id="shopInsertForm" action="${pageContext.request.contextPath}/insertItem" method="post"
							class="form-horizontal form-label-left" novalidate>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">품목카테고리명<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select id="ItemCategoryCode" name="ItemCategoryCode">
										<c:forEach var="ItemCategory" items="${CategoryItemList}">
											<option value='${ItemCategory.categoryCode}'>${ItemCategory.categorySmall}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">품목명<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="itemName"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="itemName" type="text">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">품목용량<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="itemSize"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="itemSize" type="text">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">품목원가<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="itemCost"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="itemCost" type="text">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">품목마진<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="itemProfit"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="itemProfit" type="text">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">품목가격<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="itemPrice" class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="itemPrice" type="text">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">품목상세<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="itemDetail" class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="itemDetail" type="text">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">품목이미지<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="itemImage" class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="itemImage" type="file">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">발주가능여부<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="itemAble" class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="itemAble" type="text">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<a type="submit" class="btn btn-primary" href="${pageContext.request.contextPath}/itemList">취소</a>
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
