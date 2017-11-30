<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
	$(document).ready(function() {
		$('#deleteButton').click(function() {
			if ($('#itemName').val().length < 1) {
				alert('itemName는 1자이상 이어야 합니다');
				$('#itemName').focus();
			} else {
				$('#deleteItem').submit();
			}
		});
	});
</script>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>발주품목관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/itemList">발주품목(전체리스트)</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/insertItem">발주품목(등록)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>발주품목삭제</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form action="./deleteItem" method="post"
							class="form-horizontal form-label-left" novalidate>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">품목코드<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="itemCode"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="itemCode" required="required" type="text"
										value="${param.itemCode}">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">품목명 확인<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="itemName"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="itemName" required="required" type="text">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<button id="deleteButton" type="submit" class="btn btn-success">삭제</button>
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
