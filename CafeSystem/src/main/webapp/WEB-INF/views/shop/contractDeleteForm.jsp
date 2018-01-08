<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
	$(document).ready(function() {
		$('#cancelButton').click(function(){
			var result = confirm('削除をキャンセルしますか？');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/contractDetail?contractCode=${param.contractCode}');
			}
		})
		
		$('#deleteButton').click(function() {
			if ($('#contractOwnerName').val().length < 2) {
				alert('所有者名は二文字以上です。');
				$('#contractOwnerName').focus();
			} else {
				$('#deleteContract').submit();
			}
		});
	});
</script>
<!-- page content -->
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
						<h2>契約書削除</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form action="./deleteContract" method="post"
							class="form-horizontal form-label-left" novalidate>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">契約コード</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="contractCode" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="contractCode" required="required" type="text" value="${param.contractCode}" readonly>
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">所有者名確認<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="contractOwnerName" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="contractOwnerName" required="required" type="text">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-5">
									<button id="cancelButton" type="button" class="btn btn-primary">Cancel</button>
									<button id="deleteButton" type="button" class="btn btn-danger">Delete</button>
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
