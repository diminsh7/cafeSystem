<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>메뉴관리</h3>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/menuInfoList">메뉴(전체리스트)</a> 
				<a class="btn btn-success" href="${pageContext.request.contextPath}/insertMenuInfo">메뉴(등록)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-6 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>메뉴상세조회</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form class="form-horizontal form-label-left">
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">메뉴코드</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${menuInfo.menuCode}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">메뉴카테고리명</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${menuInfo.categorySmall}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">메뉴명</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${menuInfo.menuName}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">출시일</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${menuInfo.menuStart}</div>
									</div>
								</div>
								<%-- <div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">메뉴이미지</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${menuInfo.menuImage}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">레시피이미지</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${menuInfo.menuRecipe}</div>
									</div>
								</div> --%>
							</form>
						</div>
					</div>
				<a class="btn btn-warning" href="${pageContext.request.contextPath}/updateMenuInfo?menuCode=${menuInfo.menuCode}">수정</a>
				<a class="btn btn-danger" href="${pageContext.request.contextPath}/deleteMenuInfo?menuCode=${menuInfo.menuCode}">삭제</a>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
