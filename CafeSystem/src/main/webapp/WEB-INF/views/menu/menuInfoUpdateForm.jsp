<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>메뉴수정</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form action="./updateMenuInfo" method="post"
							class="form-horizontal form-label-left" novalidate>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">메뉴코드<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuCode"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="menuCode" required="required" type="text"
										value="${menuInfo.menuCode}" readonly="readonly">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">메뉴카테고리명<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="categorySmall"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="categorySmall" required="required" type="text"
										value="${menuInfo.categorySmall}" readonly="readonly">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">메뉴명<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuName"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="menuName" required="required" type="text"
										value="${menuInfo.menuName}">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">출시일<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuStart"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="menuStart" required="required" type="text"
										value="${menuInfo.menuStart}">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">메뉴이미지<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuImage"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="menuImage" required="required" type="file"
										value="${menuInfo.menuImage}">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">레시피이미지<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuRecipe"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="menuRecipe" required="required" type="file"
										value="${menuInfo.menuRecipe}">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<button id="send" type="submit" class="btn btn-warning">수정</button>
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
