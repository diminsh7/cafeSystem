<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
	$(document).ready(function(){
		$('#cancelBtn').click(function(){
			var result = confirm('修正をキャンセルしますか？');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/contractDetail?contractCode=${contract.contractCode}');
			}
		});
		
		$('#modifyBtn').click(function(){
			var result = confirm('上記の内容で修正しますか？');
			if(result){
				$('form').submit();
			}
		})
	});
</script>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>加盟契約書管理</h3>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>契約書修正</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form action="./updateContract" method="post" class="form-horizontal form-label-left" novalidate>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">契約コード<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="contractCode" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="contractCode" required="required" type="text" value="${contract.contractCode}" readonly="readonly">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">所有主名<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="contractOwnerName" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="contractOwnerName" required="required" type="text" value="${contract.contractOwnerName}">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">店舗名<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="contractShopName" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="contractShopName" required="required" type="text" value="${contract.contractShopName}">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">所有主連絡先<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="contractOwnerPhone" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="contractOwnerPhone" required="required" type="text" value="${contract.contractOwnerPhone}">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">契約日<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="contractStartDate" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="contractStartDate" required="required" type="text" value="${contract.contractStartDate}">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">契約終了日<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="contractEndDate" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="contractEndDate" required="required" type="text" value="${contract.contractEndDate}">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">契約書イメージ<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="contractPhoto" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="contractPhoto" required="required" type="file" value="${contract.contractPhoto}">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<button id="cancelBtn" class="btn btn-primary" type="button">Cancel</button>
									<button id="modifyBtn" class="btn btn-warning" type="button">Modify</button>
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
