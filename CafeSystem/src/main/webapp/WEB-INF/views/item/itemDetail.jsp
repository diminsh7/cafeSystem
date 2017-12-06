<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>발주품목관리</h3>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/itemList">발주품목(전체리스트)</a>
				<a class="btn btn-success" href="${pageContext.request.contextPath}/insertItem">발주품목(등록)</a>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/itemListX">발주품목(금지리스트)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-6 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>발주품목상세조회</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form class="form-horizontal form-label-left">
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">품목코드</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${item.itemCode}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">품목카테고리명</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${item.categorySmall}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">품목명</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${item.itemName}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">품목용량</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${item.itemSize}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">품목원가</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${item.itemCost}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">품목마진</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${item.itemProfit}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">품목가격</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${item.itemPrice}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">품목상세</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${item.itemDetail}</div>
									</div>
								</div>
								<%-- <div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">품목이미지</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${item.itemImage}</div>
									</div>
								</div> --%>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">발주가능여부</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${item.itemAble}</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				<a class="btn btn-warning" href="${pageContext.request.contextPath}/updateItem?itemCode=${item.itemCode}">수정</a>
				<a class="btn btn-danger" href="${pageContext.request.contextPath}/deleteItem?itemCode=${item.itemCode}">삭제</a>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
