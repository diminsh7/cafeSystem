<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function shopBtn(btn){
		if(btn == 'list'){
			//console.log("rollback shop List");
			result = confirm('작성을 취소하시겠습니까?');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/shopList');
			} else {
				
			}
		} 
		if(btn == 'insert'){
			//console.log("shop Insert Action");
			result = confirm('등록하시겠습니까?');
			if(result){
				$('#shopInsertForm').submit();
			} else {
				
			}
		}
	}
</script>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>매장기초정보관리</h3>
				<%-- <a class="btn btn-default" href="${pageContext.request.contextPath}/shopList">매장(전체리스트)</a> --%>
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
						<form id="shopInsertForm" action="${pageContext.request.contextPath}/shopInsert" method="post"
							class="form-horizontal form-label-left" novalidate>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">지역코드<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select id="localCategoryCode" name="localCategoryCode">
										<c:forEach var="category" items="${shopCategory}">
											<option value="${category.categoryCode}">${category.categorySmall}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">매장코드<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopCode"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="shopCode" required="required" type="text" placeholder="ex)001~999">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">계약코드<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select id="contractCode" name="contractCode">
										<c:forEach var="sContractCode" items="${shopContractCode}">
											<option>${sContractCode.contractCode}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">점포명<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopName"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="shopName" required="required" type="text">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">점포주소<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopAddress"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="shopAddress" required="required" type="text">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">점포연락처<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopCall"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="shopCall" required="required" type="text"  placeholder="ex)00-000-0000">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">점포우편번호<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopPostcode"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="shopPostcode" required="required" type="text">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">점포규모<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopSize"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="shopSize" required="required" type="text">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<input type="button" id="shopListBtn" value="목록" onclick="ShopBtn('list')">
									<input type="button" id="shopInsertBtn" value="등록" onclick="ShopBtn('insert')">
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
