<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
	$(document).ready(function() {
		$('#accountTitleInsertButton').click(function() {
			$('#accountTitleInsertForm').submit();
		})
	})
</script>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>
					계정과목 관리 <small>계정과목 관리</small>
				</h3>
			</div>
		</div>

		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>계정과목 등록</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form id="accountTitleInsertForm" action="${pageContext.request.contextPath}/accountTitleInsert"
							method="post" class="form-horizontal form-label-left" novalidate>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="Name">계정과목명<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="accountTitleName" class="form-control col-md-7 col-xs-12" 
										data-validate-length-range="6" data-validate-words="2"
										name="accountTitleName" required="required" type="text">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="Content">상세내용<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="accountTitleContent" name="accountTitleContent" required="required"
										class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<!-- <button type="button" class="btn btn-primary">Cancel</button> -->
									<button id="accountTitleInsertButton" type="submit"	class="btn btn-success">계정과목 등록</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
