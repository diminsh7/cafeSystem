<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	// 날짜선택 등록(출시일)
	$(function() {
		$("#menuStart").datepicker({
			dateFormat : 'yymmdd'
		});
	});
</script>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>메뉴관리</h3>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/menuInfoList">메뉴(전체리스트)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>메뉴등록</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form id="menuInfoInsertForm" action="${pageContext.request.contextPath}/insertMenuInfo" method="post"
							class="form-horizontal form-label-left" novalidate>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">메뉴카테고리명<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select id="MenuCategoryCode" name="MenuCategoryCode">
										<c:forEach var="MenuCategory" items="${CategoryMenuList}">
											<option value='${MenuCategory.categoryCode}'>${MenuCategory.categorySmall}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">메뉴명<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuName"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="menuName" type="text">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">출시일<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuStart"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="menuStart" type="text">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">메뉴이미지<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuImage"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="menuImage" type="file">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">레시피이미지<span>*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuRecipe"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="menuRecipe" type="file">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<a type="submit" class="btn btn-primary" href="${pageContext.request.contextPath}/menuInfoList">취소</a>
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
