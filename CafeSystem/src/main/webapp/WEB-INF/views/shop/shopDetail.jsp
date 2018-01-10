<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>店舗基礎情報管理</h3>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>店舗詳細照会</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form class="form-horizontal form-label-left">
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">契約コード</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="form-control">${shop.contractCode}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">所有主名</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="form-control">${shop.contractOwnerName}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">店舗名</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="form-control">${shop.shopName}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">住所</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="form-control">${shop.shopAddress}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">連絡先</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="form-control">${shop.shopCall}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">郵便番号</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="form-control">${shop.shopPostcode}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">店舗サイズ(㎡)</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="form-control">${shop.shopSize}</div>
									</div>
								</div>
								<div class="col-md-6 col-md-offset-5">
									<button class="btn btn-primary" type="button" onclick="location.href='${pageContext.request.contextPath}/shopList'">List</button>
									<a class="btn btn-warning" href="${pageContext.request.contextPath}/updateShop?contractCode=${shop.contractCode}">Modify</a>
									<a class="btn btn-danger" href="${pageContext.request.contextPath}/deleteShop?contractCode=${shop.contractCode}">Delete</a>
								</div>
							</form>
						</div>
					</div>
			</div>
		</div>
	</div>
</div>