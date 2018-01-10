<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
	$(document).ready(function(){
		$('#cancelBtn').click(function(){
			var result = confirm('修正をキャンセルしますか？');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/shopDetail?contractCode=${shop.contractCode}');
			}
		});
		
		$('#modifyBtn').click(function(){
			var result = confirm('修正しますか？');
			if(result){
				$('form').submit();
			}
		});
		
	});
</script>
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
						<h2>店舗情報修正</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form action="./updateShop" method="post"
							class="form-horizontal form-label-left" novalidate>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">契約コード<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="contractCode"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="contractCode" required="required" type="text"
										value="${shop.contractCode}" readonly="readonly">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">店舗名<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopName"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="shopName" required="required" type="text"
										value="${shop.shopName}">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">住所<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopAddress"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="shopAddress" required="required" type="text"
										value="${shop.shopAddress}">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">連絡先<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopCall"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="shopCall" required="required" type="text"
										value="${shop.shopCall}">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">郵便番号<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopPostcode"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="shopPostcode" required="required" type="text"
										value="${shop.shopPostcode}">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">店舗サイズ(㎡)<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="shopSize"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="shopSize" required="required" type="text"
										value="${shop.shopSize}">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-5">
									<button id="cancelBtn" type="button" class="btn btn-primary">Cancel</button>
									<button id="modifyBtn" type="button" class="btn btn-warning">Modify</button>									
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
